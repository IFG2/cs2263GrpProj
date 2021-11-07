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

public class Handler {

    public int numPlayers = 0;
    public static ArrayList<Player> players;
    public int requestNumStock = 0;
    public String filename;

    /**
     * This method instances the board and creates the players to play the game. The players are given generic names, a
     * hand of tiles, and $6000. No Corporations are added to the stock holdings.
     *
     * @param numPlayers  The number of players to be involved in the game.
     * @return boolean True if everything went as planned.
     * @throws Exception if something goes wrong
     * @author Paul Gilbreath
     */
    public boolean startGame(int numPlayers) throws Exception{

        Board board = new Board();
        players = new ArrayList<Player>(numPlayers);

        for (int i=1; i<=numPlayers; i++){
            String playerName = "Player" + i;
            Player player = new Player(playerName);
            while (player.getHand().size() < 6){
                player.addTile(board.getTile());
            }
            players.add(player);
        }
        return true;
    }

    /**
     * Used only prior to implementation of other classes.
     *
     * @param args
     * @throws Exception
     * @author Paul Gilbreath
     */
    /*public static void main(String[] args) throws Exception {
        Handler inst = new Handler();
        inst.startGame(2);
        System.out.println(players.get(1).toString());
    }*/
}
