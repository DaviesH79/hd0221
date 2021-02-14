package com.challenge.tool;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * ToolCheckout class receives user input and passes this data to the
 * Tool Controller
 */
public class ToolCheckoutDemo {

    public static void main(String[] args) throws ParseException, ToolExceptions {

        Scanner checkout = new Scanner(System.in);
        System.out.println("Please enter tool code.");
        String toolCode = checkout.nextLine();
        System.out.println("Please enter rental checkout date (mm/dd/yyyy).");
        String checkoutDate = checkout.nextLine();
        System.out.println("Please enter number of days to rent.");
        String rentDays = checkout.nextLine();
        rentDays = (rentDays == null || rentDays.length() == 0) ? "0" : rentDays;
        System.out.println("Discount percentage is applicable.");
        String discount = checkout.nextLine();
        discount = (discount == null || discount.length() == 0) ? "0" : discount;


        // create the rental agreement object to populate
        ToolRentalAgreement agreement = new ToolRentalAgreement();
        agreement.setCheckoutDate(checkoutDate);
        agreement.setRentalDays(Integer.parseInt(rentDays));
        agreement.setDiscountPercent(Integer.parseInt(discount));

        // Send all data to controller
        ToolController controller = new ToolController(agreement);

        // fetch the tool data based on the tool code
        Tool toolToRent = controller.retrieveToolData(toolCode);

        // run validator
        controller.performValidations(toolToRent, agreement);

        // Create the rental agreement and show in console
        controller.createRentalAgreement(toolToRent, agreement);
    }

}
