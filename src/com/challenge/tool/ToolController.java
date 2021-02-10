package com.challenge.tool;

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

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement){
        agreementModel.createRentalAgreement(tool, agreement);
    }

    public void updateView(){
        agreementModel.showRentalAgreement();
    }


}
