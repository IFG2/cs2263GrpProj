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

import java.io.IOException;
import java.util.ArrayList;

public class Handler {

    public int numPlayers = 0;
    public ArrayList<Player> players;
    public int requestNumStock = 0;
    public String filename;
    public Board board;

    /**
     * Empty constructor for the Handler class. This is used when starting a new game.
     */
    public Handler(){}

    /**
     * Full constructor for the Handler class. This contains everything to play the game and should be called when
     * resuming a saved game.
     *
     * @param players  ArrayList<Player> which contain the Player objects to resume a saved game.
     * @param board  Board object which contains tileStash, 2d Array of Tile on played on board, and Corporation list.
     * @author Paul Gilbreath
     */
    public Handler(ArrayList<Player> players, Board board){
        this.players = players;
        this.board = board;
    }

    /**
     * This method instances the board and creates the players to play the game. The players are given generic names, a
     * hand of tiles, and $6000. No Corporations are added to the stock holdings.
     *      Note: if return true, the game has successfully been started
     *
     *
     * @param numPlayers  The number of players to be involved in the game.
     * @throws Exception  if something goes wrong
     * @author Paul Gilbreath
     */
    public void startGame(int numPlayers) throws Exception{

        board = new Board();
        players = new ArrayList<Player>(numPlayers);

        for (int i=1; i<=numPlayers; i++){
            String playerName = "Player" + i;
            Player player = new Player(playerName);
            while (player.getHand().size() < 6){
                player.addTile(board.getTile());
            }
            players.add(player);
        }
    }

    /**
     * This method requests a tile to be added to a Player's hand. It returns a logical of the addition status based on
     * the ability to add a Tile to the hand (maximum of 6 Tiles).
     *      Note: if false, then player hand already has 6 Tiles.
     *
     * @param player  Player object which contains a hand of tiles.
     * @return boolean status of tile request
     * @throws Exception  if something goes wrong.
     * @author Paul Gilbreath
     */
    public boolean requestTile(Player player) throws Exception{
        int handSize = player.getHand().size();
        if (handSize < 6) {
            player.addTile(board.getTile());
            return true;
        } else{
            return false;
        }
    }

    /**
     * This method tries to play a Tile to the Board and returns a boolean on the status of success. It fails to play
     * the Tile if two adjacent Corporations are each safe.
     *      Note: if return false, then at least two Corporations adjacent to the Tile are safe.
     *
     * @param tile Tile object potentially played to the Board.
     * @return boolean of the success of playing the Tile.
     * @author Paul Gilbreath
     */
    public boolean playTile(Tile tile){
        ArrayList<Tile> adjacentTiles = board.checkMerge(tile);
        /* No Tile on the Board adjacent to the proposed Tile. */
        if (adjacentTiles.isEmpty() == true){
            board.addTile(tile);
            return true;
        }
        /* At lease two Corporations that are safe from mergers, so Tile is invalid on Board. Else, place the Tile.*/
        ArrayList<Corporation> adjacentCorporations = board.findCorporations(adjacentTiles);
        if (board.checkValid(adjacentCorporations) == false){
            return false;
        } else {
            board.addTile(tile);
            return true;
        }
    }

    /**
     * This method saves a game to a new filename passed as a String.
     *
     * @param filename  String of the filename.
     * @param gameHandler  Handler object which contains everything needed to recreate the game at another time.
     * @throws IOException
     * @author Paul Gilbreath
     */
    public void saveGame(String filename, Handler gameHandler) throws IOException {
        IOManager manager = new IOManager();
        manager.writeData(filename, gameHandler);
    }

    /**
     * This method creates a new Handler instance from a file.
     *
     * @param filepath  String of the path to the .json file that holds a game to load.
     * @return a Handler instance for a previous game.
     * @throws IOException
     * @author Paul Gilbreath
     */
    public Handler loadGame(String filepath) throws IOException {
        IOManager manager = new IOManager();
        Handler gameHandler = manager.readData(filepath);
        return gameHandler;
    }

    /**
     * Used only prior to implementation of other classes.
     *
     * @param args
     * @throws Exception
     * @author Paul Gilbreath
     */
    public static void main(String[] args) throws Exception {
        /*Handler inst = new Handler();
        inst.startGame(2);
        //System.out.println(players.get(1).toString()); // test for use case #1
        //System.out.println(players.get(1).getHand()); // print the Player hand
        //System.out.println(Arrays.toString(players.get(1).getHand().get(0).getIndex())); // print the index[] of Tile at hand index=0
        /*for (int i=0; i<45; i++){
            inst.board.addTile(inst.board.getTile());
        }
        inst.board.visualizeBoard(); //make sure the board is correctly visualized and addTile works correctly. Note: numPlayers=0
        Tile firstTile = inst.board.getTile();
        for (int i=0; i<80; i++) {
            Tile nextTile = inst.board.getTile();
            System.out.println(firstTile + " " + nextTile + "   " + firstTile.isAdjacent(nextTile));
        } //checks the isAdjacent() method.
        Tile nullTile = new Tile(0, "O");
        Tile nextTile = inst.board.getTile();
        System.out.println(nullTile + " " + nextTile + "   " + nullTile.isAdjacent(nextTile));*/
    }
}
