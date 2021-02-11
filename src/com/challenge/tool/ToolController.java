package com.challenge.tool;

import java.text.ParseException;

/**
 * Controller class to handle requests
 */
public class ToolController {
    private Tool toolModel;
    private ToolRentalAgreement agreementModel;
    private ToolView checkoutView;
    private ToolRentalCalculations calculations;

    public ToolController(Tool toolModel, ToolRentalAgreement agreementModel,
                          ToolView checkoutView){
        this.toolModel = toolModel;
        this.agreementModel = agreementModel;
        this.checkoutView = checkoutView;
    }

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement) throws ParseException {
        agreementModel.calculateDueDate(agreement);
        agreementModel.calculateChargeDays(agreement, tool);
        agreementModel.createRentalAgreement(tool, agreement);
    }
}
