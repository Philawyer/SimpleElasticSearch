package com.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qizilbash on 1/29/16.
 */
public class Cluster {



    private List<Point> points = new ArrayList<Point>();

    private Point centroid;

    private int ID;

    private int children;



    //Creates a new Cluster
    public Cluster(int ID, Point centroid) {
        this.ID = ID;
        this.points = new ArrayList<Point>();
        this.centroid = centroid;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Point getCentroid() {
        return centroid;
    }

    public void setCentroid(Point centroid) {
        this.centroid = centroid;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void addChildren(){
        this.children++;
    }
}
