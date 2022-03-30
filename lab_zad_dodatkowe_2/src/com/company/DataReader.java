package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/*
* DataReader.read() specs:
*   @params : String path - should contain the name of the file that is to be read by
*                           this method. The file passed to the function should contain
*                           data written in a CSV style.
*                           If the path is invalid the method will return an empty String[][]
*  @return:
*           2D array of Strings containing all information read from a file.
*           The first row contains headers with the following lines containing data sets.
*
*           Or and empty String[][] if the argument is invalid
* */

public class DataReader {
    public static String[][] read(String path){
        String[][] readData;
        try{
            File fileAnchor = new File(path);
            Scanner fileReader = new Scanner(fileAnchor);
            long trainingSetSize = Files.lines(Paths.get(path)).count();
            if(trainingSetSize < 2)
                throw new Exception("Training data set to small");
            String[] headers = fileReader.nextLine().split(";");
            readData = new String[(int)trainingSetSize][headers.length];
            readData[0] = headers;
            for(int i=1;i<trainingSetSize && fileReader.hasNextLine();i++){
                String[] line = fileReader.nextLine().split(";");
                System.arraycopy(line, 0, readData[i], 0, headers.length);
            }
        }
       catch (FileNotFoundException f){
           System.out.println(f.getMessage() + "\n in ");
           f.printStackTrace();
           return new String[0][0];
       } catch (IOException e) {
            e.printStackTrace();
            return new String[0][0];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new String[0][0];
        }

        return readData;
    }
}
