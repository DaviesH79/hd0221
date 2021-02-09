package com.challenge.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToolCheckout {

    public static void main(String[] args){
        Map map = createToolObjects();

        Scanner checkout = new Scanner(System.in);
        System.out.println("Please enter tool ");



    }

    // No database here so setting up Tool objects manually
    // create hashmap to store Tool objects.
    private static Map createToolObjects(){
        Map<String, Tool> toolMap = new HashMap<String, Tool>();

        Tool ladder = new Tool("LADW", "Ladder", "Werner", 1.99f, true,
                true, false);
        Tool chainsaw = new Tool("CHNS", "Chainsaw", "Stihl", 1.49f, true,
                false, true);
        Tool jackhammer1 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99f,
                true, false, false);
        Tool jackhammer2 = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99f, true,
                false, false);

        toolMap.put(ladder.getToolCode(), ladder);
        toolMap.put(chainsaw.getToolCode(), chainsaw);
        toolMap.put(jackhammer1.getToolCode(), jackhammer1);
        toolMap.put(jackhammer2.getToolCode(), jackhammer2);
        return toolMap;
    }
}
