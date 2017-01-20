import lesson_2.task_3.Calculate;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Тесты калькулятора
 */
public class CalculateTest {
    
	@Test
    public void getSumTest() {
        Calculate calculate = new Calculate();
        calculate.getSum(3, 4);
        assertThat(calculate.getResult(),is (7.0));
    }
	
    @Test
    public void getSubTest() {
        Calculate calculate = new Calculate();
        calculate.getSub(3, 4);
        assertThat(calculate.getResult(),is (-1.0));
    }
    
	@Test
    public void getDivTest() {
        Calculate calculate = new Calculate();
        calculate.getDiv(8, 4);
        assertThat(calculate.getResult(),is (2.0));
    }
    
	@Test
    public void getMulTest() {
        Calculate calculate = new Calculate();
        calculate.getMul(3, 4);
        assertThat(calculate.getResult(),is (12.0));
    }
}
