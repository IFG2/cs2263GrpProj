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

import java.lang.Math;

public class Tile {

    private int number;
    private String letter;
    private final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private int[] index;

    /**
     * Constructor for a Tile object.
     *
     * @param number  Tile number as int.
     * @param letter  Tile letter as String
     * @author Paul Gilbreath
     */
    public Tile(int number, String letter){
        this.number = number;
        this.letter = letter;
    }

    /**
     * Null constructor
     *
     * @author Paul Gilbreath
     */
    public Tile(){
        number = Integer.parseInt(null);
        letter = null;
    }

    /**
     * This method checks if the Tile object is adjacent to the Tile passed as a parameter.
     *
     * @param checkTile  Tile object that should be checked.
     * @return boolean
     * @author Paul Gilbreath
     */
    public boolean isAdjacent(Tile checkTile){
        int[] checkIndex = checkTile.getIndex();
        int diffNumber = number - 1 - checkIndex[1];
        int currentLetter = -2;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == letter) {
                currentLetter = i;
            }
        }
        int diffLetter = currentLetter - checkIndex[0];
        if ((Math.abs(diffNumber) <= 1 && Math.abs(diffLetter) == 0) ||
                (Math.abs(diffNumber) == 0 && Math.abs(diffLetter) <= 1)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method gets the index used by the Board class of a tile as an array with the form [row,column].
     *
     * @return index array of the form [row,column]
     * @author Paul Gilbreath
     */
    public int[] getIndex(){
        index = new int[2];
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == letter) {
                index[0] = i;
            }
        }
        index[1] = number - 1; /* Remember the Tile number is NOT the index. */
        return index;
    }

    @Override
    public String toString() {
        return number + letter;
    }

    public int getNumber() {
        return number;
    }

    public String getLetter() {
        return letter;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
