package com.challenge.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class ToolRentalCalculations extends Tool{

    //private Tool tool;
    //private ToolRentalAgreement agreement;
    //public String dueDate;

    public int chargeDays;
    public Float preDiscountCharge;

    // calculated from checkout date and rental days
    public void calculateDueDate(ToolRentalAgreement agreement) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        String checkOutDate = agreement.getCheckoutDate();
        Integer rentalDays = agreement.getRentalDays();

        // convert string to date and add rental days
        Date checkOut = new SimpleDateFormat("MM/dd/yy").parse(checkOutDate);
        calendar.setTime(checkOut);
        calendar.add(Calendar.DAY_OF_MONTH, rentalDays);
        Date dueDate = calendar.getTime();

        // convert dueDate back to string
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        String dueDateString = df.format(dueDate);

        agreement.setDueDate(dueDateString);
    }

    // calculate chargeable days from day AFTER checkout through and INCLUDING
    // due date, EXCLUDING "no charge" days as specified by tool type
    public void calculateChargeDays(ToolRentalAgreement agreement, Tool tool) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Calendar mondayCalendar = Calendar.getInstance();
        String checkOutDate = agreement.getCheckoutDate();
        Integer rentalDays = agreement.getRentalDays();
        Boolean weekdayCharge = tool.getWeekdayCharge();
        Boolean weekendCharge = tool.getWeekendCharge();
        Boolean holidayCharge = tool.getHolidayCharge();

        Date julyFourth = new SimpleDateFormat("MM/dd").parse("07/04");
        // set up Labor Day check
        int year = calendar.get(Calendar.YEAR);
        int month = 9;
        LocalDate local = LocalDate.of(year, month, 1);
        LocalDate laborDay = local.with(firstInMonth(DayOfWeek.MONDAY));

        // format date
        Date checkOut = new SimpleDateFormat("MM/dd/yy").parse(checkOutDate);
        calendar.setTime(checkOut);
        //calendar.add(Calendar.DAY_OF_MONTH, 1);
        //Date startChargeDate = calendar.getTime();

        // check if any of the days are not chargeable days
        Integer chargeDayCount = rentalDays;
        for (int i = 0; i < rentalDays; i++){
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            // convert current date to local date for comparison
            LocalDate laborDayDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
            System.out.println(weekdayCharge);
            // if it's a weekday and should not be charged
            if ((calendar.get(Calendar.DAY_OF_WEEK) != 7 ||
                    calendar.get(Calendar.DAY_OF_WEEK) != 1)  && !weekdayCharge){
                chargeDayCount -= 1;
                System.out.println("inside !weekdaycharge");
            }
            // if it's a weekend and should not be charged
            else if ((calendar.get(Calendar.DAY_OF_WEEK) == 7 ||
                    calendar.get(Calendar.DAY_OF_WEEK) == 1)  && !weekendCharge){
                chargeDayCount -= 1;
                System.out.println("inside !weekendcharge");
            }
            // if it's a holiday and should not be charged
            else if ((calendar.getTime() == julyFourth || laborDayDate == laborDay) && !holidayCharge){
                chargeDayCount -= 1;
                System.out.println("inside !holidaycharge");
            }
        }

        this.setChargeDays(chargeDayCount);
    }

    // calculated as charge day * daily charge, resulting amount rounded half up to cents
    public static void calculatePreDiscountCharge(Integer chargeDays, Tool tool){
        Float dailyCharge = tool.getDailyCharge();

    }

    // calculated from discount percentage and pre-discount charge, resulting amount
    // rounded half up to cents
    public static void calculateDiscountAmount(ToolRentalAgreement agreement){
        Float discountPercent = agreement.getDiscountPercent();
    }

    // calculated as pre-discount charge minus discount amount
    public static void calculateFinalCharge(){

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
}
