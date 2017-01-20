import lesson_3.max.Max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест определения наибольшего числа.
 */
public class MaxTest {

    @Test
    public void getMaxTest() {
        Max max = new Max();
        int result = max.max(2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void getMaxThreeValuesTest() {
        Max max = new Max();
        int result = max.max(2, 3, 6);
        assertThat(result, is(6));
    }
}
