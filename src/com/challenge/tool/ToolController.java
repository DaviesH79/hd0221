package com.challenge.tool;

import java.text.ParseException;

/**
 * Controller class to handle requests
 */
public class ToolController {
    private Tool toolModel;
    private ToolRentalAgreement agreementModel;
    //private ToolRentalCalculations calculations;

    public ToolController(Tool toolModel, ToolRentalAgreement agreementModel){
        this.toolModel = toolModel;
        this.agreementModel = agreementModel;
    }

    //public ToolController(Tool toolToRent, ToolRentalAgreement agreement) {
    //}

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement) throws ParseException {
        agreementModel.calculateDueDate(agreement);
        agreementModel.calculateChargeDays(agreement, tool);
        agreementModel.calculatePreDiscountCharge(tool, agreement);
        agreementModel.calculateDiscountAmount(agreement);
        agreementModel.calculateFinalCharge(agreement);
        agreementModel.createRentalAgreement(tool, agreement);
    }
}
