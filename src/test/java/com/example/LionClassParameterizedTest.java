package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) //отдельный параметризованный тест
public class LionClassParameterizedTest {

    private final String lionSex;
    private final boolean expectedAnswer;

    public LionClassParameterizedTest (String lionSex, boolean expectedAnswer ) {
        this.lionSex = lionSex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeMethodWorks() throws Exception {
        Feline feline = new Feline();
        Lion lionForParametersTest = new Lion(lionSex, feline);
        assertEquals(expectedAnswer, lionForParametersTest.doesHaveMane());
    }
}
