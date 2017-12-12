import be.md.CalculateCircleNumber;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CalculateCircleNumberTest {

    @Test
    public void firstCircle2To9() {
        IntStream.rangeClosed(2, 9)
                .forEach(i ->
                        assertEquals(msg(i), 1, new CalculateCircleNumber().circleFrom(i))
                );
    }

    private String msg(int i) {
        return "comparing " + i + " with " + new CalculateCircleNumber().circleFrom(i);
    }

    @Test
    public void secondCircle10To25() {
        IntStream.rangeClosed(10, 25)
                .forEach(i ->
                        assertEquals(msg(i), 2, new CalculateCircleNumber().circleFrom(i))
                );
    }

    @Test
    public void maxNumberOfCircle() {
        assertEquals(1, new CalculateCircleNumber().maxNumForCircleWithItem(1));
        assertEquals(9, new CalculateCircleNumber().maxNumForCircleWithItem(2));
        assertEquals(9, new CalculateCircleNumber().maxNumForCircleWithItem(8));
        assertEquals(9, new CalculateCircleNumber().maxNumForCircleWithItem(368078));
    }

    @Test
    public void solution() {
        int start = 368078;
        CalculateCircleNumber calculateCircleNumber = new CalculateCircleNumber();
        int maxInCircle = calculateCircleNumber.maxNumForCircleWithItem(start);
        int circle = calculateCircleNumber.circleFrom(start); //303

        System.out.println(circle);
    }
}
