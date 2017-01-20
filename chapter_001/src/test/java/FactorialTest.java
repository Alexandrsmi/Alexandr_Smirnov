import lesson_4.factorial.Factorial;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Тест нахождения факториала числа
 */
public class FactorialTest {
    
    @Test
    public void factorialTest(){
        Factorial factorial = new Factorial();
        long result = factorial.getFactorial(4);
        assertThat(result,is(24));
    }
}