package com.example;

import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LionClassTest {


    @Mock
    Feline mockFeline;

    @Test
    public void getKittensMethodWithNoArgumentWorks() {

        Feline feline = new Feline();
        {   //вынужденная обработка, так как сам конструктор класса может выбросить исключение
            try {
                Lion lion = new Lion("Самка", feline);
                //если здесь использовать мок feline, тест проходит, но в консоль валятся NullPointerException
                //поэтому оставил реальный feline
                assertEquals(1, lion.getKittens());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getFoodMethodWorks()  {

        Feline feline = new Feline();
        {   //вынужденная обработка, так как сам конструктор класса может выбросить исключение
            try {
                Lion lion = new Lion("Самка", feline);
                //если здесь использовать мок feline, тест проходит, но в консоль валятся NullPointerException
                //поэтому оставил реальный feline
                List<String> actualFoodList = lion.getFood();
                List<String> expectedFoodList = List.
                        of("Животные", "Птицы", "Рыба");
                assertEquals(expectedFoodList, actualFoodList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //отдельный тест ветки, которую нельзя поместить в единую параметризацию
    //для тестирования ветки с выбрасыванием исключения использую метод, разобранный на вебинаре с преподавателями

    @Test(expected = Exception.class)
    public void lionConstructorThrowsExceptionWithMessage() throws Exception {
        //можно использовать мок, так как поле hasMane класса Lion не зависит от объекта feline
        Lion exceptionLion = new Lion("Not lion sex", mockFeline);
    }
}

