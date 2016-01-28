package com.main;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by qizilbash on 1/28/16.
 */
public class Main {



    public static void main(String args[]) throws IOException {





        API myAPI = new API();

        Node node     = nodeBuilder().node();
        Client client = node.client();

        int i=1;
        String text;

        File folder = new File("docs");
        for (File fileEntry : folder.listFiles()) {

            System.out.println(Integer.toString(i)+"  -->  "+fileEntry.getName());


            text = new String(Files.readAllBytes(Paths.get("docs/"+fileEntry.getName())), StandardCharsets.UTF_8);

            client.prepareIndex("qizil", "article", Integer.toString(i++)).setSource(text).get();

        }



        myAPI.getDocument(client, "qizil", "article", "1");


        myAPI.searchDocument(client, "qizil", "article", "title", "Process");

        node.close();
    }
}
