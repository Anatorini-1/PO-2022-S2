package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Utility {
    public  static String[][] extractColumns(String[][] src, HashSet<String> column){
        String[][] toReturn = new String[src.length][];
        try{
            String[] headers = src[0];
            for(int i=0;i<src.length;i++){
                toReturn[i] = new String[column.size()];
                int k = 0;
                for(int j=0;j< headers.length;j++){
                    if(column.contains(headers[j])){
                        toReturn[i][k] = src[i][j];
                        k++;
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid data passed to ");
            e.printStackTrace();
        }
        return toReturn;
    }
    public  static void print2DArrayOfStrings(String[][] arr){
        for(var row: arr){
            System.out.println("");
            for(var cell:row)
                System.out.print(cell+ " ");
        }
    }
    public  static HashSet<String> iris_Y_fields = new HashSet<>(List.of("species"));
    public  static HashSet<String> iris_X_fields = new HashSet<>(Arrays.asList("sepal_length","sepal_width","petal_length","petal_width"));
    public  static String iris_train_path = "data/train_data_iris.txt";
    public  static String iris_test_path = "data/test_data_iris.txt";
    public  static HashSet<String> cancer_Y_fields = new HashSet<>(List.of("diagnosis"));
    public  static HashSet<String> cancer_X_fields = new HashSet<>(Arrays.asList(
            "radius_mean",
            "texture_mean",
            "perimeter_mean",
            "area_mean",
            "smoothness_mean",
            "compactness_mean",
            "concavity_mean",
            "concave points_mean",
            "symmetry_mean",
            "fractal_dimension_mean",
            "radius_se",
            "texture_se",
            "perimeter_se",
            "area_se",
            "smoothness_se",
            "compactness_se",
            "concavity_se",
            "concave points_se",
            "symmetry_se",
            "fractal_dimension_se",
            "radius_worst",
            "texture_worst",
            "perimeter_worst",
            "area_worst",
            "smoothness_worst",
            "compactness_worst",
            "concavity_worst",
            "concave points_worst",
            "symmetry_worst",
            "fractal_dimension_worst"));
    public  static String cancer_train_path = "data/train_data_cancer.txt";
    public  static String cancer_test_path = "data/test_data_cancer.txt";

}
