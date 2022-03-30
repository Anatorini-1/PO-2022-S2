package com.company;


/*
* Euclidean.distance() calculates the distance between 2 points using
* the rules of euclidean geometry, where the distance between 2 points
* is defined as a square root of the sum of differences in coordinates
* squared.
*
*
* @params
*   String[] a,b
*       Array of coordinates representing one of the points
*       Stored as String[] instead of Double[] because
*       DataReader.read() returns String arrays, and
*       it was easier to cast types here than anywhere else
*       All elements of these arrays should be valid representations
*       of Double type numbers and the size of both arrays should be equal
*
* @return
*       The distance between given points as a number of type double
*       Returns Infinity if the input data is invalid in some way
*
* */

import java.text.ParseException;

public class Euclidean extends MetricsProvider{
    @Override
    public double distance(String[] a, String[] b) {
            if(a.length != b.length) try {
                throw new Exception("Can not calculate distance between objects with different number of coordinates");
            } catch (Exception e) {
                e.printStackTrace();
                return Double.POSITIVE_INFINITY;
            }
            float sumOfSquares = 0;
            try{
                for(int i=0;i<a.length;i++)
                    sumOfSquares += Math.pow(Double.parseDouble(a[i]) - Double.parseDouble(b[i]),2);
                return Math.sqrt(sumOfSquares);
            }
            catch (NumberFormatException p){
                p.printStackTrace();
                return Double.POSITIVE_INFINITY;
            }


        }
}
