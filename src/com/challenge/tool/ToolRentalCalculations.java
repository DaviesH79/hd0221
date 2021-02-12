package com.challenge.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class ToolRentalCalculations {

    public int chargeDays;

    // calculated from checkout date and rental days
    public void calculateDueDate(ToolRentalAgreement agreement) throws ParseException, ToolExceptions {
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

        // format date
        Date checkOut = new SimpleDateFormat("MM/dd/yy").parse(checkOutDate);
        calendar.setTime(checkOut);

        // HOLIDAYS
        // pull year checkout date
        int year = calendar.get(Calendar.YEAR);
        Date julyFourth = new SimpleDateFormat("MM/dd/yy").parse("07/03/" + year);
        // set up Labor Day check
        LocalDate local = LocalDate.of(year, 9, 1);
        LocalDate laborDay = local.with(firstInMonth(DayOfWeek.MONDAY));

        // check if any of the days are not chargeable days
        Integer chargeDayCount = rentalDays;
        for (int i = 0; i < rentalDays; i++){
            // start charging the day AFTER checkout date
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            // convert current date to local date for comparison to LaborDay
            LocalDate currentDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // if it's a weekday and should not be charged
            if ((calendar.get(Calendar.DAY_OF_WEEK) != 7 ||
                    calendar.get(Calendar.DAY_OF_WEEK) != 1)  && !weekdayCharge){
                chargeDayCount -= 1;
            }
            // if it's a weekend and should not be charged
            else if ((calendar.get(Calendar.DAY_OF_WEEK) == 7 ||
                    calendar.get(Calendar.DAY_OF_WEEK) == 1)  && !weekendCharge){
                chargeDayCount -= 1;
            }
            // if it's a holiday and should not be charged
            if ((calendar.getTime().compareTo(julyFourth) == 0 || currentDate.compareTo(laborDay) == 0)
                    && !holidayCharge){
                chargeDayCount -= 1;
            }
        }
        this.setChargeDays(chargeDayCount);
    }

    // calculated as charge day * daily charge, resulting amount rounded half up to cents
    public void calculatePreDiscountCharge(Tool tool, ToolRentalAgreement agreement){
        Float dailyCharge = tool.getDailyCharge();
        Integer chargeDays = this.getChargeDays();
        int preDiscountCharge = Math.round(dailyCharge * chargeDays);
        agreement.setPreDiscountCharge(preDiscountCharge);
    }

    // calculated from discount percentage and pre-discount charge, resulting amount
    // rounded half up to cents
    public static void calculateDiscountAmount(ToolRentalAgreement agreement){
        int discountPercent = agreement.getDiscountPercent();
        int discountAmount = Math.round((discountPercent * agreement.getPreDiscountCharge())/100);
        agreement.setDiscountAmount(discountAmount);
    }

    // calculated as pre-discount charge minus discount amount
    public static void calculateFinalCharge(ToolRentalAgreement agreement){
        int preDiscount = agreement.getPreDiscountCharge();
        int discount = agreement.getDiscountAmount();
        int finalCharge = preDiscount - discount;
        agreement.setFinalCharge(finalCharge);
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }
}
