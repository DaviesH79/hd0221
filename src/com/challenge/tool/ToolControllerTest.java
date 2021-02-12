package com.challenge.tool;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ToolControllerTest {

    Tool tool = new Tool();
    ToolRentalAgreement agreement = new ToolRentalAgreement();
    ToolController controller = new ToolController(tool, agreement);
    ToolExceptions exceptions = new ToolExceptions();
    @Test
    void test1() {
        tool.setToolCode("JAKR");
        tool.setToolType("Jackhammer");
        tool.setBrand("Rigid");
        tool.setDailyCharge(2.99f);
        tool.setWeekdayCharge(true);
        tool.setWeekendCharge(false);
        tool.setHolidayCharge(false);

        agreement.setCheckoutDate("09/03/15");
        agreement.setRentalDays(5);
        agreement.setDiscountPercent(101);

        controller.performValidations(agreement);

    }

    @Test
    void test2() throws ParseException, ToolExceptions {
        tool.setToolCode("LADW");
        tool.setToolType("Ladder");
        tool.setBrand("Werner");
        tool.setDailyCharge(1.99f);
        tool.setWeekdayCharge(true);
        tool.setWeekendCharge(true);
        tool.setHolidayCharge(false);

        agreement.setCheckoutDate("07/02/20");
        agreement.setRentalDays(3);
        agreement.setDiscountPercent(10);

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(2, agreement.getChargeDays());
    }

    @Test
    void test3() throws ParseException, ToolExceptions {
        tool.setToolCode("CHNS");
        tool.setToolType("Chainsaw");
        tool.setBrand("Stihl");
        tool.setDailyCharge(1.49f);
        tool.setWeekdayCharge(true);
        tool.setWeekendCharge(false);
        tool.setHolidayCharge(true);

        agreement.setCheckoutDate("07/02/15");
        agreement.setRentalDays(5);
        agreement.setDiscountPercent(25);

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(3, agreement.getChargeDays());
    }
}