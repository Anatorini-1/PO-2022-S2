package com.company;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
class KNeighborsClassifierTest {

    @Test
    void testConstructor(){
        KNeighborsClassifier k =new KNeighborsClassifier(2,"euclidean");
        assertEquals("com.company.Euclidean",k.getMetric().getClass().getName());
        assertEquals(2,k.getK());
    }

    @org.junit.jupiter.api.Test
    void fit() {
        KNeighborsClassifier k =new KNeighborsClassifier(2,"euclidean");
        String[][] train_X = {{"field1","field2"},{"0.67","2.30"},{"4.2","9.6"}};
        String[][] train_Y = {{"label"},{"1"},{"0"}};
        k.fit(train_X,train_Y);
        NDimensionalPoint[] points = k.getTrainData();
        for(int i=0;i< points.length;i++){
            assertEquals(points[i].label, train_Y[i+1][0]);
            assertArrayEquals(points[i].coordinates, train_X[i+1]);
        }

    }

    @org.junit.jupiter.api.Test
    void predict() {
        KNeighborsClassifier k =new KNeighborsClassifier(1,"euclidean");
        String[][] train_X = {{"field1","field2"},{"0.67","2.30"},{"4.2","9.6"}};
        String[][] train_Y = {{"label"},{"1"},{"0"}};
        k.fit(train_X,train_Y);
        String[][] testSamples = {{"field1","field2"},{"0.67","2.30"},{"4.2","9.6"}};
        k.predict(testSamples);
        assertEquals("1",k.getPredictions()[0]);
        assertEquals("0",k.getPredictions()[1]);
    }

    @org.junit.jupiter.api.Test
    void calculate_accuracy() {
        KNeighborsClassifier k =new KNeighborsClassifier(1,"euclidean");
        String[][] train_X = {{"field1","field2"},{"0.67","2.30"},{"4.2","9.6"}};
        String[][] train_Y = {{"label"},{"1"},{"0"}};
        k.fit(train_X,train_Y);
        String[][] testSamples = {{"field1","field2"},{"0.67","2.30"},{"4.2","9.6"}};
        String[][] testLables = {{"label"},{"1"},{"0"}};
        k.predict(testSamples);
        k.calculate_accuracy(testLables);
        assertEquals(1.0f,k.getAccuracy());
    }

    @org.junit.jupiter.api.Test
    void save_to_file() {
    }
}