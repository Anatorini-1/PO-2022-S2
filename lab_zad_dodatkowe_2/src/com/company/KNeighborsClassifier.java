package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class KNeighborsClassifier {
    public int k = 5;
    public  MetricsProvider metric;

    // Getters
    public int getK() {
        return k;
    }
    public MetricsProvider getMetric() {
        return metric;
    }
    public NDimensionalPoint[] getTrainData() {
        return trainData;
    }
    public String[] getPredictions() {
        return predictions;
    }
    public float getAccuracy() {
        return accuracy;
    }

    // Main methods
    private NDimensionalPoint[] trainData;
    private String[] predictions;
    private float accuracy;
    public KNeighborsClassifier(int n_neighbors,String metric){
        this.k = n_neighbors;
        switch (metric){
            case "euclidean":
                this.metric = new Euclidean();
                break;
            case "manhattan":
                this.metric = new Manhattan();
                break;
            default:
                this.metric = new Euclidean();
        }
        //System.out.print("Classifier initialized with the " + this.metric.getClass().getName()+" metric\n");
    }
    public void fit(String[][] train_X, String[][] train_Y){
        try{
            if (train_X.length  < 2)
                throw new Exception("Training dat set empty");
            if(train_X.length != train_Y.length)
                throw new Exception("X and Y dat sets dont match");
            if(train_X.length-1 < k)
                throw new Exception("Data set must contain at least "+k+" entries");
            this.trainData = new NDimensionalPoint[train_X.length-1];
            for(int i=1;i< train_X.length;i++){
                this.trainData[i-1] = new NDimensionalPoint(train_X[i],train_Y[i][0]);
            }
           // System.out.println("Classifier fitted with a training set of length "+(train_X.length-1));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public void predict(String[][] test_X){
        //System.out.println("Calculating predictions using "+this.k+" nearest neighbors");
        long start = System.currentTimeMillis();
        this.predictions = new String[test_X.length-1];
        for (int i=1;i<test_X.length;i++){
            int finalI = i;
            MetricsProvider metric = this.metric;
            Comparator<NDimensionalPoint> PointSortOrder = new Comparator<NDimensionalPoint>() {
                @Override
                public int compare(NDimensionalPoint o1, NDimensionalPoint o2) {
                    double distance =metric.distance(o1.coordinates,test_X[finalI]) - metric.distance(o2.coordinates,test_X[finalI]);
                    if (distance > 0) return 1;
                    if (distance < 0) return -1;
                    return 0;
                }
            };
            Arrays.sort(trainData,PointSortOrder);
            double avg =0;
            for (int j=0;j<this.k;j++) avg += Integer.parseInt(this.trainData[j].label);
            this.predictions[i-1] = String.valueOf(Math.round(avg/this.k));
        }
       // System.out.println("Calculated "+test_X.length+" predictions in "+(System.currentTimeMillis() - start)+ " miliseconds ");
    }
    public void calculate_accuracy(String[][] test_Y){
        if(test_Y.length-1 != predictions.length){
            //System.out.println("test_Y set does not math the test_X set in size");
            return;
        }
        int correct_predictions = 0;
        for(int i=0;i<this.predictions.length;i++)
            if(this.predictions[i].equals(test_Y[i+1][0]))correct_predictions++;
        //System.out.print("Model accuracy: ");
        //System.out.printf("%.2f",(float)correct_predictions/ (float)test_Y.length*100f);
        //System.out.print("%\n");
        this.accuracy = (float)correct_predictions/ ((float)test_Y.length-1);
    }
    public void save_to_file(String filename,String label){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(label+"\n");
            fw.write("k: "+this.k+"\n");
            fw.write("metric: "+this.metric.getClass().getName()+"\n");
            fw.write("training set size: "+this.trainData.length+"\n");
            fw.write("predictions made: "+this.predictions.length+"\n");
            fw.write("accuracy: "+this.accuracy+"\n");
            fw.write("predictions: \n");
            for (var s : this.predictions) fw.write(s+"\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
