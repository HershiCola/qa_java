package com.example;

import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatClassTest {

        @Mock
        Feline mockFeline;

    @Test //используем мок, так как сущность feline не влияет на тест метода getSound класса Cat
    public void getSoundMethodWorks() {
        Cat cat = new Cat(mockFeline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodMethodWorks()  {
        Feline feline = new Feline(); //реальный объект Feline, т.к.  тест затрагивает его реализацию
        Cat cat = new Cat(feline); //создаем отдельный объект для изоляции теста
        try { //обработка исключения, т.к. метод getFood может его выбросить
            List<String> actualFoodList = cat.getFood();
            List<String> expectedFoodList = List.
                    of("Животные", "Птицы", "Рыба");
            assertEquals(expectedFoodList,actualFoodList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
