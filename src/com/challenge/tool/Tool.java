package com.challenge.tool;

/**
 * The Tool class describes the Tool object
 */
public class Tool {
    private String toolType;
    private String brand;
    private String toolCode;
    private Float dailyCharge;
    private Boolean weekdayCharge;
    private Boolean weekendCharge;
    private Boolean holidayCharge;

    // Default constructor
    public Tool(){}

    // Constructor that sets all Tool attributes
    public Tool(String code, String type, String brand, float dailyCharge,
                boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.toolCode = code;
        this.toolType = type;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    /**
     * @return String toolType
     */
    public String getToolType() {
        return toolType;
    }

    /**
     * @param toolType String
     */
    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    /**
     * Get the brand
     * @return String
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set the brand
     * @param brand String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get the toolCode
     * @return String
     */
    public String getToolCode() {
        return toolCode;
    }

    /**
     * Set the toolCode
     * @param toolCode String
     */
    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public Float getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(Float dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public Boolean getWeekdayCharge() {
        return weekdayCharge;
    }

    public void setWeekdayCharge(Boolean weekdayCharge) {
        this.weekdayCharge = weekdayCharge;
    }

    public Boolean getWeekendCharge() {
        return weekendCharge;
    }

    public void setWeekendCharge(Boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    public Boolean getHolidayCharge() {
        return holidayCharge;
    }

    public void setHolidayCharge(Boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }
}
