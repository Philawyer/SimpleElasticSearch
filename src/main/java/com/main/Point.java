package com.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizilbash on 1/29/16.
 */

public class Point {


    private List<Integer> position = new ArrayList<Integer>();

    private int clusterID;



    public Point(List position)
    {
        this.position = position;
    }


    public List<Integer> getPosition() {
        return position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    public void setCluster(int n) {
        this.clusterID = n;
    }

    public int getCluster() {
        return this.clusterID;
    }

    public double distance(Point point) {
        return 0;
    }


    public static Point getZero() {
        return null;
    }

    public void add(Point point){

    }

    public void divide(int children) {
        this.position =null;
    }
}
