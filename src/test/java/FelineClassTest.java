import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineClassTest {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineClassTest (int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }
    Feline feline = new Feline();

    @Test
    public void eatMeatMethodWorks() throws Exception {
        List<String> actualFoodList = feline.eatMeat();
        List<String> expectedFoodList = List.
                of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoodList,actualFoodList);
    }

    @Test
    public void getFamilyMethodWorks() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensMethodWithNoArgumentWorks(){
        assertEquals(1,feline.getKittens());
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { 5, 5},
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

