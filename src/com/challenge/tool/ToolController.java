package com.challenge.tool;

import java.text.ParseException;

/**
 * Controller class to handle requests
 */
public class ToolController {
//    private Tool toolModel;
    private ToolRentalAgreement agreementModel;

    public ToolController(Tool toolModel, ToolRentalAgreement agreementModel){
 //       this.toolModel = toolModel;
        this.agreementModel = agreementModel;
    }

    public void performValidations(ToolRentalAgreement agreement ) throws ToolExceptions {
        ToolAgreementValidator validator = new ToolAgreementValidator();
        validator.validate(agreement);
    }

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement) throws ParseException, ToolExceptions {
        agreementModel.calculateDueDate(agreement);
        agreementModel.calculateChargeDays(agreement, tool);
        agreementModel.calculatePreDiscountCharge(tool, agreement);
        agreementModel.calculateDiscountAmount(agreement);
        agreementModel.calculateFinalCharge(agreement);
        agreementModel.createRentalAgreement(tool, agreement);
    }
}
