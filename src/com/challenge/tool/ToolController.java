package com.challenge.tool;

import java.text.ParseException;
import java.util.HashMap;

/**
 * Controller class to handle requests
 */
public class ToolController {
//    private Tool toolModel;
    private ToolRentalAgreement agreementModel;

    // default constructor
    public ToolController(){

    }

    public ToolController(ToolRentalAgreement agreementModel){
        this.agreementModel = agreementModel;
    }

    public void performValidations(Tool tool, ToolRentalAgreement agreement ) throws ToolExceptions {
        ToolAgreementValidator validator = new ToolAgreementValidator();
        validator.validate(tool, agreement);
    }

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement) throws ParseException, ToolExceptions {
        agreementModel.calculateDueDate(agreement);
        agreementModel.calculateChargeDays(agreement, tool);
        agreementModel.calculatePreDiscountCharge(tool, agreement);
        agreementModel.calculateDiscountAmount(agreement);
        agreementModel.calculateFinalCharge(agreement);
        agreementModel.createRentalAgreement(tool, agreement);
    }
    // Retrieve toolCode from User Input and create the tool model
    public static Tool retrieveToolData(String toolType, String toolBrand) throws ToolExceptions {
        String type = toolType.toLowerCase();
        String brand = toolBrand.toLowerCase();
        String typeBrand = type + brand;
        String toolCode = "";

        // get tool's corresponding code
        switch (typeBrand){
            case "ladderwerner": toolCode = "LADW";
                break;
            case "chainsawstihl": toolCode = "CHNS";
                break;
            case "jackhammerridgid": toolCode = "JAKR";
                break;
            case "jackhammerdewalt": toolCode = "JAKD";
                break;
            case "default": toolCode = "";
        }
        if (toolCode == ""){
            ToolExceptions e = new ToolExceptions();
            throw e;
        }
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

        // add tools to map
        toolMap.put(ladder.getToolCode(), ladder);
        toolMap.put(chainsaw.getToolCode(), chainsaw);
        toolMap.put(jackhammer1.getToolCode(), jackhammer1);
        toolMap.put(jackhammer2.getToolCode(), jackhammer2);
        return toolMap;
    }

    // create all required rental data
    // used if we are not going to hardcode user input
    // not in use at this time
    private static ToolRentalAgreement getRentalUserInput(){
        ToolRentalAgreement agreement = new ToolRentalAgreement();
        agreement.setRentalDays(5);
        agreement.setCheckoutDate("07/02/20");
        agreement.setDiscountPercent(20);
        return agreement;
    }
}
