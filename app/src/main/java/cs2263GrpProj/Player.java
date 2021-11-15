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

public class Player {

    public String name;
    public ArrayList<Tile> hand;
    public int balance;
    public ArrayList<Stock> stocks;

    /**
     * Minimal Constructor for the Player object.
     *
     * @param name The name of a Player as a String.
     * @author Paul Gilbreath
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Tile>(6);
        balance = 6000;
        stocks = new ArrayList<Stock>(7);
    }

    /**
     * Full Constructor for the Player object.
     *
     * @param name    The name of a Player as a String.
     * @param hand    The player's hand, as an ArrayList of Tiles.
     * @param balance The player's balance as an int.
     * @param stocks  The player's stock holdings as an ArrayList of Stocks.
     * @author Paul Gilbreath
     */
    public Player(String name, ArrayList<Tile> hand, int balance, ArrayList<Stock> stocks) {
        this.name = name;
        this.hand = hand;
        this.balance = balance;
        this.stocks = stocks;
    }

    /**
     * This method prints a Player object in a human readable format.
     *
     * @return String of contents of a Player object
     * @author Paul Gilbreath
     */
    @Override
    public String toString() {
        return name + "\n" + hand + "\n" + balance + "\n" + stocks;
    }

    /**
     * This method adds a Tile to the Player hand.
     *
     * @param newTile Tile object
     * @author Paul Gilbreath
     */
    public void addTile(Tile newTile) {
        hand.add(newTile);
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }

}
