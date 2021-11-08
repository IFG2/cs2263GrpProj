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
    public Tile[][] board = new Tile[12][9];

    /**
     * Constructor to create the tiles and board.
     * @author Paul Gilbreath
     */
    public Board(){
        createTiles();
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
        for(int i=1; i<=12; i++){
            for(var letter : letters){
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
