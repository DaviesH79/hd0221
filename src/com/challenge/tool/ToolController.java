package com.challenge.tool;

import java.text.ParseException;
import java.util.HashMap;

/**
 * Controller class to handle requests
 */
public class ToolController {

    private ToolRentalAgreement agreementModel;

    // default constructor
    public ToolController(){}

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
    // Retrieve toolCode from User Input and create and return the tool
    public static Tool retrieveToolData(String toolCode) throws ToolExceptions {
        // No DB, using a hashmap instead
        HashMap map = createToolObjects();

        // make sure tool exists in map otherwise throw exception
        try {
            if (!map.containsKey(toolCode)) {
                ToolExceptions e = new ToolExceptions();
                e.ToolExistsException();
            }
        } catch (ToolExceptions msg){
           System.out.println(msg);
           System.out.println("Please enter a valid tool and brand.");
           System.exit(1);
        }
        Tool getTool = (Tool)map.get(toolCode);
        return getTool;
    }

    // No database here so setting up Tool objects manually
    // create hashmap to store Tool objects.
    private static HashMap createToolObjects(){
        HashMap<String, Tool> toolMap = new HashMap<String, Tool>();

        Tool ladder = new Tool("LADW", "Ladder", "Werner", 1.99, true,
                true, false);
        Tool chainsaw = new Tool("CHNS", "Chainsaw", "Stihl", 1.49, true,
                false, true);
        Tool jackhammer1 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99,
                true, false, false);
        Tool jackhammer2 = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99, true,
                false, false);

        // add tools to map
        toolMap.put(ladder.getToolCode(), ladder);
        toolMap.put(chainsaw.getToolCode(), chainsaw);
        toolMap.put(jackhammer1.getToolCode(), jackhammer1);
        toolMap.put(jackhammer2.getToolCode(), jackhammer2);
        return toolMap;
    }
}
