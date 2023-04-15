import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class CatTest {
    private final String foodOne;
    private final String foodTwo;
    private final String foodThree;


    public CatTest(String foodOne, String foodTwo, String foodThree) {
        this.foodOne = foodOne;
        this.foodTwo = foodTwo;
        this.foodThree = foodThree;
    }

    @Parameterized.Parameters
    public static Object[][] testParams() {
        return new Object[][]{
                {"Животные", "Птицы", "Рыба"}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getCatSoundTest() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        assertEquals(expected, cat.getSound());
    }

    @Test
    public void getFoodTypeTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        ArrayList<String> presetList = new ArrayList<>();
        presetList.add(foodOne);
        presetList.add(foodTwo);
        presetList.add(foodThree);
        assertEquals(presetList, cat.getFood());
    }


}
