package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineClassParameterizedTest { //отдельный параметризованный тест

        private final int kittensCount;
        private final int expectedKittensCount;

        public FelineClassParameterizedTest (int kittensCount, int expectedKittensCount) {
            this.kittensCount = kittensCount;
            this.expectedKittensCount = expectedKittensCount;
        }
        Feline feline = new Feline();

        @Parameterized.Parameters
        public static Object[][] getSumData() {
            return new Object[][] {
                    { 13, 13},
                    { 2, 2},
                    {0, 0},
            };
        }
        @Test
        public void getKittensMethodWithArgumentsWorks() {
            int actual = feline.getKittens(kittensCount);
            assertEquals(expectedKittensCount, actual);
        }
}
