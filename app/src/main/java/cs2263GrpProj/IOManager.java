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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOManager {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String jsonString;

    /**
     * empty constructor
     */
    public IOManager(){}

    /**
     * Method to read the Handler data from an existing json file.
     *
     * @param filepath  String of the path/foobar/filename
     * @return gameHandler Handler object that holds the entire game configuration
     * @throws IOException
     * @author Paul Gilbreath
     */
    public Handler readData(String filepath) throws IOException{
        Path pathToFile = Path.of(filepath);
        String fileContents = Files.readString(pathToFile);
        // TypeToken? May need to find a different way to do this...
        Type type = new TypeToken<Handler>() {}.getType();
        Handler gameHandler = gson.fromJson(fileContents, type);
        return gameHandler;
    }

    /**
     * Method to write the Handler data to a json file.
     *
     * @param file  String of the filename
     * @param gameHandler  Handler object
     * @throws IOException
     * @author Paul Gilbreath
     */
    public void writeData(String file, Handler gameHandler) throws IOException {

        PrintWriter outFile = null;

        jsonString = gson.toJson(gameHandler);
        outFile = new PrintWriter(new FileWriter("./" + file));
        outFile.write(jsonString);
        outFile.close();
    }
}