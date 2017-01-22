import lesson_6.CheckLine;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;


	/**
	 * Тест класса определяющего является ли строка sub подстрокой original
	 * @author smirnov
	 * @since 22.01.2017
	 */
	 
public class CheckLineTest {

	/**
	 * Тест метода преобразующего String в char[].
	 */

    @Test
    public void stringInArrayCharTest() {
        CheckLine checkLine = new CheckLine();
        String string = "abcdr";
        char[] charsArray = checkLine.stringInChar(string);
        char[] result = {'a','b','c','d','r'};
        Assert.assertThat(charsArray,is(result));
    }
	
	/**
	 * Тест метода проверяющего является ли строк sub подстрокой origin.
	 */
	 
    @Test
    public void checkSubstringTest(){
        CheckLine checkLine = new CheckLine();
        String origin = "A drop in the bucket.";
        String sub = "the";
        char[] originArray = checkLine.stringInChar(sub);
        char[] subArray = checkLine.stringInChar(sub);
        boolean result = checkLine.checkSubString(originArray,subArray);
        Assert.assertThat(true,is(result));
    }
}
