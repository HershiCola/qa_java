import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Lion;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionClassTest {


    private final String lionSex;
    private final boolean expectedAnswer;

    public LionClassTest (String lionSex, boolean expectedAnswer ) {
        this.lionSex = lionSex;
        this.expectedAnswer = expectedAnswer;
    }

    Feline feline = new Feline();
    Lion lion;

    {   //вынужденная обработка, так как сам конструктор класса может выбросить исключение
        try {
            lion = new Lion ("Самка", feline);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getKittensMethodWithNoArgumentWorks(){
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodMethodWorks() throws Exception {
        List<String> actualFoodList = lion.getFood();
        List<String> expectedFoodList = List.
                of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoodList,actualFoodList);

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

        Lion lionForParametersTest = new Lion(lionSex, feline);
        assertEquals(expectedAnswer, lionForParametersTest.doesHaveMane());
    }

    @Test
    public void lionConstructorThrowsExceptionWithMessage() {
        try {
            Lion exceptionLion = new Lion("Not sex", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }
//    @Mock
//    Lion lion;
//
//
//    @Test
//    public void getKittensMethodWorks(){
//        lion.getKittens();
//        Mockito.verify(lion, Mockito.times(1)).getKittens();
//    }
//
//    @Test
//    public void getFoodMethodWorks () throws Exception {
//        lion.getFood();
//        Mockito.verify(lion, Mockito.times(1)).getFood();
//
//    }

}
