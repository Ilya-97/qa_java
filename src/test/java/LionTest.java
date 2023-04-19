import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final String animalKind;
    private final boolean isManeResult;
    @Mock
    Feline feline;

    public LionTest(String sex, String animalKind, boolean isManeResult) {
        this.sex = sex;
        this.animalKind = animalKind;
        this.isManeResult = isManeResult;
    }

    @Parameterized.Parameters(name = "Пол животного, тип млекопитающего, признак наличия гривы. Тестовые данные: {0} {1} {2}")
    public static Object[][] testParams() {
        return new Object[][]{
                {"Самец", "Хищник", true},
                {"Самка", "Травоядное", false},
                {"Непонятно", "Травоядное", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void lionManeGenderMatchingTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(lion.doesHaveMane(), isManeResult);
    }

    @Test
    public void testLionFoodType() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Collections.singletonList(animalKind));
        assertEquals((lion.getFood()), Collections.singletonList(animalKind));
    }

    @Test
    public void getKittensMethodTestLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(lion.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(1, actual);
    }
}
