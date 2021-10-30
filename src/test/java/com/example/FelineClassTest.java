package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineClassTest {


    @Test
    public void eatMeatMethodWorks()  {
        Feline feline = new Feline(); //отдельный объект для изоляции теста
        try {
            List<String> actualFoodList = feline.eatMeat();
            List<String> expectedFoodList = List.
                    of("Животные", "Птицы", "Рыба");
            assertEquals(expectedFoodList,actualFoodList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getFamilyMethodWorks() {
        Feline feline = new Feline(); //отдельный объект для изоляции теста
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensMethodWithNoArgumentWorks(){
        Feline feline = new Feline(); //отдельный объект для изоляции теста
        assertEquals(1,feline.getKittens());
    }

   }

