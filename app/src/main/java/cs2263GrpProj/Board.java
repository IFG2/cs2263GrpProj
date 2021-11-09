/**
 * Copyright 2021 IFG2
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cs2263GrpProj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    public int corporationsPlaced = 0;
    public int size;
    private static ArrayList<Tile> tileStash = new ArrayList<>(108);
    public ArrayList<Corporation> corporations;
    public Tile[][] board = new Tile[9][12];

    /**
     * Constructor to create the tiles and a board of 'null' Tiles.
     *
     * @author Paul Gilbreath
     */
    public Board(){
        createTiles();
        Tile nullTile = new Tile(0, "O");
        for (Tile[] row: board) {
            Arrays.fill(row, nullTile);
        }
    }

    /**
     * Full constructor for the Board object.
     *
     * @param tileStash  ArrayList<Tile> of unplayed Tiles that have not been drawn into a Player hand or discarded.
     * @param corporations  ArrayList<Corporation> of Corporation objects currently in play.
     * @param board  2D Array of the Tile objects on the board.
     * @author Paul Gilbreath
     */
    public Board(ArrayList<Tile> tileStash, ArrayList<Corporation> corporations, Tile[][] board){
        this.tileStash = tileStash;
        this.corporations = corporations;
        this.board = board;
    }

    /**
     * Creates the tiles and shuffle.
     *
     * @return tileStash  Returns an ArrayList<Tile>.
     * @author Paul Gilbreath
     */
    private ArrayList<Tile> createTiles(){
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        //This loop will add 4 cards with a different suit for each value
        for (int i=1; i<=12; i++){
            for (String letter : letters){
                Tile tile = new Tile(i, letter);
                tileStash.add(tile);
            }
        }
        Collections.shuffle(tileStash);
        return tileStash;
    }

    /**
     * Method to print the tiles in an ArrayList.
     * Used to visualize the tileStash and make sure it was created properly.
     *
     * @param list  ArrayList<String>
     * @author Paul Gilbreath
     */
    public void tilesToString(ArrayList<Tile> list){
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * This method pulls the top Tile from the shuffled tile stash.
     *
     * @return Tile from a shuffled pile
     * @author Paul Gilbreath
     */
    public Tile getTile(){
        if (tileStash.size() > 0) {
            return tileStash.remove(0);
        } else{
            return null;
        }
    }

    /**
     * Method to add a Tile to the board.
     *
     * @param tile Tile object to be added to the Board.
     * @return true
     * @author Paul Gilbreath
     */
    public void addTile(Tile tile){
        int[] index = tile.getIndex();
        board[index[0]][index[1]] = tile;
    }

    /**
     * This method checks to see if a potential Tile to be played would require a merge with a current Tile on the
     * Board. It returns an ArrayList<Tile> currently on the Board that are adjacent.
     *      Note: if return ArrayList length = 0, there are no tiles near the potential Tile.
     *            if return ArrayList length = 1, the Tile will either create a new Corporation or add to an existing one.
     *            if return ArrayList length = >1, a potential merge will need to take place.
     *
     * @param newTile potential Tile to be played
     * @return ArrayList<Tile> that are adjacent to the potential Tile.
     * @author Paul Gilbreath
     */
    public ArrayList<Tile> checkMerge(Tile newTile){
        ArrayList<Tile> adjacentTiles = new ArrayList<Tile>();
        for (Tile[] row : board) {
            for (Tile tile : row) {
                if (newTile.isAdjacent(tile) == true) {
                    adjacentTiles.add(tile);
                }
            }
        }
        return adjacentTiles;
    }

    /**
     * This method takes an ArrayList<Tile> currently on the board that are adjacent to a Tile to be potentially played
     * and finds out if any of the Tile objects are currently part of a corporation. It returns ArrayList<Corporation>
     * that are potentially involved in a merger.
     *      Note: if return ArrayList length = 0, a new Corporation will need to be created.
     *            if return ArrayList length = 1, a Tile should be added to an existing Corporation.
     *            if return ArrayList length = >1, a potential merge of two Corporation will need to happen.
     *
     * @param adjacentTiles  ArrayList<Tile> that need to be tested for involvement in a current established
     *                        Corporation.
     * @return ArrayList<Corporation>
     * @author Paul Gilbreath
     */
    public ArrayList<Corporation> findCorporations(ArrayList<Tile> adjacentTiles){
        ArrayList<Corporation> adjacentCorporations = new ArrayList<Corporation>();
        ArrayList<Tile> corporationTiles = new ArrayList<Tile>();

        for (Corporation corporation : corporations) {
            corporationTiles = corporation.getTiles();
            for (Tile corpTile : corporationTiles){
                for (Tile collTile : adjacentTiles){
                    if (collTile.isAdjacent(corpTile) == true){
                        adjacentCorporations.add(corporation);
                    }
                }
            }
        }
        return adjacentCorporations;
    }

    /**
     * This method takes an ArrayList<Corporation> and checks to see if the Corporations can be merged together. It
     * relies on the isSafe() method in the Corporation class.
     *
     * @param adjacentCorporations  ArrayList<Corporation> that are potentially to be merged.
     * @return boolean if the Corporations can be merged.
     * @author Paul Gilbreath
     */
    public boolean checkValid(ArrayList<Corporation> adjacentCorporations){
        if (adjacentCorporations.size() <= 1){ /* No merge to happen, therefore no need to check validity. */
            return true;
        }
        int numberSafeCorporations = 0;
        for (Corporation corporation : adjacentCorporations) {
            if (corporation.isSafe() == true) {
                numberSafeCorporations++;
            }
        }
        if (numberSafeCorporations > 1 ) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method to visualize the board's current tiles while doing implementation tasks. Outputs the board to the console.
     *
     * @author Paul Gilbreath
     */
    public void visualizeBoard(){
        for (Tile[] a : board) {
            for (Tile i : a) {
                System.out.print(i.toString() + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * main() used only for testing prior to implementation of other classes.
     *
     * @param args
     * @author Paul Gilbreath
     */
    /*public static void main(String[] args){
        Board board = new Board();
        board.tilesToString(tileStash);
    }*/

}
