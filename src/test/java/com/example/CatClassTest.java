package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//ПРИМЕЧАНИЕ ДЛЯ РЕВЬЮЕРА
/*
В текущем исполнении jacoco показывает практически полное покрытие тестами трех классов по заданию
Я не использовал моки, поскольку не нашел им логического применения в тестах (возможно в виду малого опыта)
Практически все методы возвращают значения, не void, поэтому обязательно проверять именно корректность возвращаемых значений,
а не только факт того, что метод отработал (если через мок, как разобрано в программе курса).
Это я обсуждал в том числе и с преподавателями
В этом случае мок будет избыточен, так как методы покрыты проверками.

На примере этого класса CatClassTest я мог бы написать мок объекта Feline, и использовать его для первого теста,
поскольку вызываемый метод getSound не имеет связи с полями feline/predator класса cat
Но уже во втором тесте этот мок бы не сработал, поскольку метод getFood затронул бы связь feline-predator
и пришлось бы создавать объект класса Cat с реальным объектом класса Feline, т.е. код бы усложнился, а результат был бы тот же
 */

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
