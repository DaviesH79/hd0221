package com.challenge.tool;

/**
 * The ToolRentalAgreement class creates the rental agreement object for the view
 */
public class ToolRentalAgreement extends ToolRentalCalculations {
    private int rentalDays;
    private String checkoutDate;
    private String dueDate;
    private Double preDiscountCharge;
    private int discountPercent;
    private Double discountAmount;
    private Double finalCharge;

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
        System.out.println("Daily Rental Charge: $" + tool.getDailyCharge());
        System.out.println("Charge Days: " + this.getChargeDays());
        System.out.println("Pre-discount Charge: $" + this.getPreDiscountCharge());
        //System.out.println("Pre-discount Charge: $" + String.format("%.2f", this.getPreDiscountCharge()));
        System.out.println("Discount Percent: " + this.getDiscountPercent() + "%");
        System.out.println("Discount Amount: $" + String.format("%.2f",this.getDiscountAmount()));
        System.out.println("Final Charge: $" + String.format("%.2f", this.getFinalCharge()));
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

    public Double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(Double preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(Double finalCharge) {
        this.finalCharge = finalCharge;
    }

    public void createRentalAgreement(Tool tool, ToolRentalAgreement agreement) {
        Tool toolToRent = tool;
        showRentalAgreement(tool, agreement);
    }

}
