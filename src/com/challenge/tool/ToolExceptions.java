package com.challenge.tool;

public class ToolExceptions extends Exception {
    ToolExceptions(String message){
        super(message);
    }

    ToolExceptions(){

    }

    public void RentalDaysException(int days) throws ToolExceptions {
        if (days < 1){
            String msg = "Rental days must be greater than 0";
            ToolExceptions rentalDayException = new ToolExceptions(msg);
            throw  rentalDayException;
        }
    }

    public void DiscountPercentageException(int percent) throws ToolExceptions {
        if (percent < 0 || percent > 100){
            String msg = "Discount percentage is not valid.";
            ToolExceptions e = new ToolExceptions(msg);
            throw e;
        }
    }

}
