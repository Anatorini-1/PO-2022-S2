package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FeaturesCalculator {
    private ArrayList<ArrayList<Integer>> matrix;
    private Integer[] massCenter;
    private final String filename;
    public FeaturesCalculator(String path){
        File fileHandle = new File(path);
        while(!fileHandle.exists() || fileHandle.isDirectory()){
            System.out.println("File "+path+" does not exist. Provide a correct file name: ");
            Scanner in = new Scanner(System.in);
            path = in.nextLine().trim();
            fileHandle = new File(path);
        }
        this.filename = path;
    }
    public void read_data(){
        File fileHandle = new File(this.filename);
        try (Scanner fileReader = new Scanner(fileHandle)) {
            this.matrix = new ArrayList<>();
            while(fileReader.hasNextLine()){
                this.matrix.add(new ArrayList<Integer>(Arrays.asList(Stream.of(fileReader.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new))));
            }
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }

    }
    public void calculate_mass_center() {
        if(matrix == null){
            System.out.println("Invoke read_data() before calculating the mass center");
            return;
        }
        int x_sum = 0, y_sum = 0, count = 0;
        for(int i=0;i<matrix.size();i++){
            for(int j = 0;j<matrix.get(i).size();j++){
                if(matrix.get(i).get(j) == 1){
                    x_sum += i;
                    y_sum += j;
                    count++;
                }
            }
        }
        massCenter = new Integer[2];
        massCenter[0] = Math.round((float)x_sum / count);
        massCenter[1] = Math.round((float)y_sum / count);
    }
    public void save_results(){
        if(matrix == null || massCenter == null){
            System.out.println("No input matrix / no mass center calculated");
            return;
        }
            try {
                FileWriter fw = new FileWriter(this.filename+"_results.txt");
                for(int i=0;i< matrix.size();i++){
                    for(int j=0;j<matrix.get(i).size();j++){
                        if(i == massCenter[0] && j == massCenter[1]) fw.write("P ");
                        else fw.write(matrix.get(i).get(j) == 0 ? "0 ":"1 ");
                    }
                    fw.write("\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args){
        var FC1 = new FeaturesCalculator(new Scanner(System.in).nextLine());
        FC1.read_data();
        FC1.calculate_mass_center();
        FC1.save_results();
    }
}
