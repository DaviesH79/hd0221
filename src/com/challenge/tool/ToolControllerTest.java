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
    ToolAgreementValidator validator = new ToolAgreementValidator();

    Tool ladder = new Tool("LADW", "Ladder", "Werner", 1.99f, true,
            true, false);
    Tool chainsaw = new Tool("CHNS", "Chainsaw", "Stihl", 1.49f, true,
            false, true);
    Tool jakr = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99f, true,
            false, false);
    Tool jakd = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99f, true,
            false, false);

    @Test
    void test1() {
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

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(2, agreement.getChargeDays());
    }

    @Test
    void test3() throws ParseException, ToolExceptions {
        this.tool = chainsaw;
        agreement.setCheckoutDate("07/02/15");
        agreement.setRentalDays(5);
        agreement.setDiscountPercent(25);

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(3, agreement.getChargeDays());
    }

    @Test
    void test4() throws ParseException, ToolExceptions {
        this.tool = jakd;
        agreement.setCheckoutDate("09/03/15");
        agreement.setRentalDays(6);
        agreement.setDiscountPercent(0);

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(3, agreement.getChargeDays());
    }

    @Test
    void test5() throws ParseException, ToolExceptions {
        this.tool = jakr;
        agreement.setCheckoutDate("07/02/15");
        agreement.setRentalDays(9);
        agreement.setDiscountPercent(0);

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(5, agreement.getChargeDays());
    }

    @Test
    void test6() throws ParseException, ToolExceptions {
        this.tool = jakr;
        agreement.setCheckoutDate("07/02/20");
        agreement.setRentalDays(4);
        agreement.setDiscountPercent(50);

        controller.performValidations(agreement);
        controller.createRentalAgreement(tool, agreement);
        Assert.assertEquals(1, agreement.getChargeDays());
    }
}