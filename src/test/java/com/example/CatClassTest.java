package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatClassTest {

    Feline feline = new Feline();
    Cat cat = new Cat(feline);


    @Test
    public void getSoundMethodWorks() {

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodMethodWorks() throws Exception {
        List<String> actualFoodList = cat.getFood();
        List<String> expectedFoodList = List.
                of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoodList,actualFoodList);

    }

}
