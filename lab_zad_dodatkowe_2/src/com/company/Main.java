package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int k = 9;
        String metric = "euclidean";
        KNeighborsClassifier Classifier5 = new KNeighborsClassifier(k,metric);
        String[][] cancer_test = DataReader.read(Utility.cancer_test_path);
        String[][] cancer_train = DataReader.read(Utility.cancer_train_path);
        Classifier5.fit(Utility.extractColumns(cancer_train,Utility.cancer_X_fields),Utility.extractColumns(cancer_train,Utility.cancer_Y_fields));
        int[] ks = {3,5,7,9,11};
        FileWriter fw = new FileWriter("tak4.txt");
        for(int i : ks){
            Classifier5.k = i;
            Classifier5.predict(Utility.extractColumns(cancer_test,Utility.cancer_X_fields));
            Classifier5.calculate_accuracy(Utility.extractColumns(cancer_test,Utility.cancer_Y_fields));
            fw.write("cancer " + metric + " k= " +i+ " " + Classifier5.getAccuracy()+"\n");
        }
        fw.close();

    }
}
