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

// imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    //instance variables
    public int corporationsPlaced = 0;
    public int size;
    public static ArrayList<String> tileStash = new ArrayList<String>(108);
    //public Map? board

    /**
     * Constructor
     */
    public Board(){
        createTiles();
    }

    /**
     * Creates the tiles
     * @return ArrayList<String> tileStash
     */
    private ArrayList<String> createTiles(){
        //ArrayList<String> tileStash = new ArrayList<String>(108);
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        //This loop will add 4 cards with a different suit for each value
        for(int i=1; i<=12; i++){
            for(var letter : letters){
                tileStash.add(Integer.toString(i) + letter);
            }
        }
        Collections.shuffle(tileStash);
        return tileStash;
    }

    /**
     * Method to print the tiles in an ArrayList.
     * Used to visualize the tileStash and make sure it was created properly.
     * @param list ArrayList<String>
     */
    public void tilesToString(ArrayList<String> list){
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * main() used only for testing prior to implementation of other classes.
     * @param args
     */
    public static void main(String[] args){
        Board board = new Board();
        board.tilesToString(tileStash);
    }

}
