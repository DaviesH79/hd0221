package com.challenge.tool;

public class ToolAgreementValidator extends ToolExceptions{

    public void validate(ToolRentalAgreement agreement) throws ToolExceptions {

        int rentalDays = agreement.getRentalDays();
        int discountPercent = agreement.getDiscountPercent();

        this.validateRentalDays(rentalDays);
        this.validateDiscountPercentage(discountPercent);
    }

    public void validateRentalDays(int days){

        //validate rentalDays
        try{
            ToolExceptions e = new ToolExceptions();
            e.RentalDaysException(days);
        } catch (ToolExceptions e) {
            System.out.println(e);
            System.out.println("Please enter number of days you would like to rent the tool.");
            System.exit(1);
        }
    }

    public void validateDiscountPercentage(int percent) throws ToolExceptions {
        ToolExceptions e = new ToolExceptions();
        try {
            e.DiscountPercentageException(percent);
        } catch (ToolExceptions msg){
            System.out.println(msg);
            System.out.println("Please enter a valid discount percentage. (eg. 0-100)");
            System.exit(1);
        }
    }
}
