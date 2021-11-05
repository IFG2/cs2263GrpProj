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

    //imports

public class Tile {

    // instance variables
    private int number;
    private String letter;
    private final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

    /**
     * Constructor
     * @param number
     * @param letter
     */
    public Tile(int number, String letter){
        this.number = number;
        this.letter = letter;
    }

    /**
     * Null constructor
     */
    public Tile(){
        number = Integer.parseInt(null);
        letter = null;
    }

    /**
     * This method checks if a tile is adjacent to the tile passed as a parameter.
     * CURRENTLY STUBBED
     * @param checkTile
     * @return boolean
     */
    public boolean isAdjacent(Tile checkTile){

        return false;
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

    private void setNumber(int number) {
        this.number = number;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
