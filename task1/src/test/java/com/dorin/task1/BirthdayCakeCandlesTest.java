package com.dorin.task1;

import org.junit.Assert;
import org.junit.Test;

public class BirthdayCakeCandlesTest {

    @Test
    public void birthdayCakeCandlesSuccessTestCases1() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        Assert.assertEquals(2, birthdayCakeCandles.birthdayCakeCandles(
                new int[]{4, 4, 3, 1}
        ));
    }

    @Test
    public void birthdayCakeCandlesSuccessTestCases2() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        Assert.assertEquals(2, birthdayCakeCandles.birthdayCakeCandles(
                new int[]{3, 2, 1, 3}
        ));
    }

    @Test
    public void birthdayCakeCandlesSuccessTestCases3() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        Assert.assertEquals(2, birthdayCakeCandles.birthdayCakeCandles(
                new int[]{3, 2, 1, 3, 3, 3, 3, 7, 1, 7}
        ));
    }

    @Test
    public void birthdayCakeCandlesIlegalArgumentExceptionCase() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        try {
            birthdayCakeCandles.birthdayCakeCandles(
                    new int[]{}
            );

            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            birthdayCakeCandles.birthdayCakeCandles(
                    null
            );

            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }
    }

}