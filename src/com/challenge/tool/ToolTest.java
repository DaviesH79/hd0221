package com.challenge.tool;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ToolTest {

    Tool tool = new Tool();
    ToolRentalAgreement agreement = new ToolRentalAgreement();
    ToolController controller = new ToolController(agreement);

    Tool ladder = new Tool("LADW", "Ladder", "Werner", 1.99, true,
            true, false);
    Tool chainsaw = new Tool("CHNS", "Chainsaw", "Stihl", 1.49, true,
            false, true);
    Tool jakr = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, true,
            false, false);
    Tool jakd = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99, true,
            false, false);

    @Test
    void testDiscountException() {
        this.tool = jakr;
        assertThrows(ToolExceptions.class, ()->{
            ToolAgreementValidator validator = new ToolAgreementValidator();
            validator.DiscountPercentageException(102);
        });
    }

    @Test
    void test2() throws ParseException, ToolExceptions {
        this.tool = ladder;

        agreement.setCheckoutDate("07/02/20");
        agreement.setRentalDays(3);
        agreement.setDiscountPercent(10);

        controller.performValidations(tool, agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(2, agreement.getChargeDays());
        Assert.assertEquals(3.98, agreement.getPreDiscountCharge(), 0.00);
        Assert.assertEquals(0.40, agreement.getDiscountAmount(), 0.00);
        Assert.assertEquals(3.58, agreement.getFinalCharge(), 0.00);
    }

    @Test
    void test3() throws ParseException, ToolExceptions {
        this.tool = chainsaw;
        agreement.setCheckoutDate("07/02/15");
        agreement.setRentalDays(5);
        agreement.setDiscountPercent(25);

        controller.performValidations(tool, agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(3, agreement.getChargeDays());
        Assert.assertEquals(4.47, agreement.getPreDiscountCharge(), 0.00);
        Assert.assertEquals(1.12, agreement.getDiscountAmount(), 0.00);
        Assert.assertEquals(3.35, agreement.getFinalCharge(), 0.00);
    }

    @Test
    void test4() throws ParseException, ToolExceptions {
        this.tool = jakd;
        agreement.setCheckoutDate("09/03/15");
        agreement.setRentalDays(6);
        agreement.setDiscountPercent(0);

        controller.performValidations(tool, agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(3, agreement.getChargeDays());
        Assert.assertEquals(8.97, agreement.getPreDiscountCharge(), 0.00);
        Assert.assertEquals(0, agreement.getDiscountAmount(), 0.00);
        Assert.assertEquals(8.97, agreement.getFinalCharge(), 0.00);
    }

    @Test
    void test5() throws ParseException, ToolExceptions {
        this.tool = jakr;
        agreement.setCheckoutDate("07/02/15");
        agreement.setRentalDays(9);
        agreement.setDiscountPercent(0);

        controller.performValidations(tool, agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(5, agreement.getChargeDays());
        Assert.assertEquals(14.95, agreement.getPreDiscountCharge(), 0.00);
        Assert.assertEquals(0, agreement.getDiscountAmount(), 0.00);
        Assert.assertEquals(14.95, agreement.getFinalCharge(), 0.00);
    }

    @Test
    void test6() throws ParseException, ToolExceptions {
        this.tool = jakr;
        agreement.setCheckoutDate("07/02/20");
        agreement.setRentalDays(4);
        agreement.setDiscountPercent(50);

        controller.performValidations(tool, agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(1, agreement.getChargeDays());
        Assert.assertEquals(2.99, agreement.getPreDiscountCharge(), 0.00);
        Assert.assertEquals(1.50, agreement.getDiscountAmount(), 0.00);
        Assert.assertEquals(1.49, agreement.getFinalCharge(), 0.00);
    }

    @Test
    void testRentalException() {
        assertThrows(ToolExceptions.class, ()->{
            ToolAgreementValidator validator = new ToolAgreementValidator();
            validator.RentalDaysException(0);
        });
    }
}