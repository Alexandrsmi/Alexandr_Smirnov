import lesson_4.counter.Counter;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 *Тест суммы интервала 
 */
public class CounterTest {
    @Test
    public void countTest(){
       Counter counter = new Counter();
       int result = (int) counter.add(1,3);
       assertThat(result,is(2));
    }
}
