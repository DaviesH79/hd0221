package com.challenge.tool;

/**
 * The ToolRentalAgreement class creates the rental agreement object for the view
 */
public class ToolRentalAgreement extends ToolRentalCalculations {
    private int rentalDays;
    private String checkoutDate;
    private String dueDate;
    private int preDiscountCharge;
    private int discountPercent;
    private int discountAmount;
    private int finalCharge;

    public ToolRentalAgreement() {
        super();
    }

    public void showRentalAgreement(Tool tool, ToolRentalAgreement agreement) {
        System.out.println("Tool Code: " + tool.getToolCode());
        System.out.println("Tool Type: " + tool.getToolType());
        System.out.println("Tool Brand: " + tool.getBrand());
        System.out.println("Rental Days: " + this.getRentalDays());
        System.out.println("Check Out Date: " + this.getCheckoutDate());
        System.out.println("Due Date: " + this.getDueDate());
        System.out.println("Daily Rental Charge: " + tool.getDailyCharge());
        System.out.println("Charge Days: " + this.getChargeDays());
        System.out.println("Pre-discount Charge: $" + this.getPreDiscountCharge());
        System.out.println("Discount Percent: " + this.getDiscountPercent() + "%");
        System.out.println("Discount Amount: $" + this.getDiscountAmount());
        System.out.println("Final Charge: $" + this.getFinalCharge());
    }

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

    public int getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(int preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(int finalCharge) {
        this.finalCharge = finalCharge;
    }

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement) {
        Tool toolToRent = tool;
        showRentalAgreement(tool, agreement);
    }

}
