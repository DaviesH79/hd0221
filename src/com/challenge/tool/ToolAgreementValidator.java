package com.challenge.tool;

public class ToolAgreementValidator extends ToolExceptions{
    public Boolean exception;

    public void validate(ToolRentalAgreement agreement){

        int rentalDays = agreement.getRentalDays();
        int discountPercent = agreement.getDiscountPercent();

        this.validateRentalDays(rentalDays);
        this.validateDiscountPercentage(discountPercent);
    }

    public void validateRentalDays(int days){

        //validate rentalDays
        try{
            if (days < 1){
                String msg = "Rental days must be greater that 0";
                ToolExceptions rentalDayException = new ToolExceptions(msg);
                throw  rentalDayException;
            }
        } catch (ToolExceptions e) {
            this.exception = true;
            System.out.println("Please enter number of days you would like to rent the tool.");
            System.exit(0);
        }
    }

    public void validateDiscountPercentage(int percent){

        //validate Discount Percentage
        try{
            if (percent < 0 || percent > 100){
                ToolExceptions e = new ToolExceptions();
                throw e;
            }
        } catch (ToolExceptions e) {
            System.out.println("Please enter a valid discount percentage. (Between 0 and 100)");
            System.exit(0);
        }
    }
}
