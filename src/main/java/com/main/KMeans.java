package com.main;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by qizilbash on 1/28/16.
 */



public class KMeans {


    private int numberOfClusters;
    private int numberOfIterations;
    private List<Point> points = new ArrayList<Point>();
    private List<Cluster> clusters = new ArrayList<Cluster>();
    private List<Integer> shuffleList = new ArrayList<Integer>();

    public KMeans(int numberOfIterations, int numberOfClusters, List<Point> points) {

        this.numberOfIterations = numberOfIterations;
        this.numberOfClusters = numberOfClusters;
        this.points = points;
        this.clusters = new ArrayList<Cluster>();


        for (int i = 0; i < points.size(); i++)
            shuffleList.add(i);

        java.util.Collections.shuffle(shuffleList);

        for (int i = 0; i < numberOfClusters; i++)
            clusters.add(new Cluster(i, points.get(shuffleList.get(i))));

    }


    public void goStep() {

        //reassign
        for (Point point : points) {
            double temp = Double.MAX_VALUE;
            for (Cluster cluster : clusters) {
                if (point.distance(cluster.getCentroid()) < temp) {
                    point.setCluster(cluster.getID());
                    temp = point.distance(clusters.get(point.getCluster()).getCentroid());
                }

            }
        }

        //recalculate centroids
        clearClusters();

        for (Point point : points) {
            clusters.get(point.getCluster()).getCentroid().add(point);
            clusters.get(point.getCluster()).addChildren();
        }

        for (Cluster cluster : clusters)
            cluster.getCentroid().divide(cluster.getChildren());

    }

    private void clearClusters() {
        for (Cluster cluster : clusters) {
            cluster.setCentroid(Point.getZero());
            cluster.setChildren(0);
        }
    }


}