package com.challenge.tool;

/**
 * The ToolRentalAgreement class creates the rental agreement object for the view
 */
public class ToolRentalAgreement extends Tool{
    private int rentalDays;
    private String checkoutDate;
    private String dueDate;
    private int chargeDays;
    private Float preDiscountCharge;
    private Float discountPercent;
    private Float discountAmount;
    private Float finalCharge;

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public Float getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(Float preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public Float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Float getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(Float finalCharge) {
        this.finalCharge = finalCharge;
    }
}
