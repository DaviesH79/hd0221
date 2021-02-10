package com.challenge.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ToolCheckout class receives user input and passes this data to the
 * Tool Controller
 */
public class ToolCheckoutDemo {

    public static void main(String[] args){


        Scanner checkout = new Scanner(System.in);
        System.out.println("Please select tool.");
        System.out.println("Please enter rental checkout.");
        System.out.println("Please enter rental return.");

        String toolCode;
        Integer rentalDayCount;
        Float discountPercent;
        String checkOutDate;

        checkOutDate = "02/14/21";

        // fetch the tool data based on the tool code
        Tool toolToRent = retrieveToolData("LADW");

        // create the view to display the Rental Agreement on console
        ToolView view = new ToolView();

        // create the rental agreement to populate
        //ToolRentalAgreement agreement = new ToolRentalAgreement();
        ToolRentalAgreement agreement = getRentalUserInput();

        // Send all data to controller
        ToolController controller = new ToolController(toolToRent, agreement, view);

        // Create the rental agreement and show in console
        controller.createRentalAgreement(toolToRent, agreement);
        controller.updateView();
    }

    // Retrieve toolCode from User Input and create the tool model
    private static Tool retrieveToolData(String toolCode){
        HashMap map = createToolObjects();
        Tool getTool = (Tool)map.get(toolCode);
        return getTool;
    }

    // No database here so setting up Tool objects manually
    // create hashmap to store Tool objects.
    private static HashMap createToolObjects(){
        HashMap<String, Tool> toolMap = new HashMap<String, Tool>();

        Tool ladder = new Tool("LADW", "Ladder", "Werner", 1.99f, true,
                true, false);
        Tool chainsaw = new Tool("CHNS", "Chainsaw", "Stihl", 1.49f, true,
                false, true);
        Tool jackhammer1 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99f,
                true, false, false);
        Tool jackhammer2 = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99f, true,
                false, false);
        System.out.println(ladder.getToolCode());
        toolMap.put(ladder.getToolCode(), ladder);
        toolMap.put(chainsaw.getToolCode(), chainsaw);
        toolMap.put(jackhammer1.getToolCode(), jackhammer1);
        toolMap.put(jackhammer2.getToolCode(), jackhammer2);
        return toolMap;
    }

    // create all required rental data
    private static ToolRentalAgreement getRentalUserInput(){
        ToolRentalAgreement agreement = new ToolRentalAgreement();
        agreement.setRentalDays(5);
        agreement.setCheckoutDate("02/14/21");
        agreement.setDiscountPercent(20f);
        return agreement;
    }
}
