package com.dorin.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BirthdayCakeCandlesTest {

    @Test
    public void birthdayCakeCandlesSuccessTestCases1() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        Assertions.assertEquals(2, birthdayCakeCandles.birthdayCakeCandles(
                new int[] { 4, 4, 3, 1 }));
        ;
    }

    @Test
    public void birthdayCakeCandlesSuccessTestCases2() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        Assertions.assertEquals(2, birthdayCakeCandles.birthdayCakeCandles(
                new int[] { 3, 2, 1, 3 }));
    }

    @Test
    public void birthdayCakeCandlesSuccessTestCases3() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        Assertions.assertEquals(2, birthdayCakeCandles.birthdayCakeCandles(
                new int[] { 3, 2, 1, 3, 3, 3, 3, 7, 1, 7 }));
    }

    @Test
    public void birthdayCakeCandlesIlegalArgumentExceptionCase() {
        BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

        try {
            birthdayCakeCandles.birthdayCakeCandles(
                    new int[] {});

            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            birthdayCakeCandles.birthdayCakeCandles(
                    null);

            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }
    }

}