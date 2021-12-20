import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void testCalculatePosition() {
        List<String> inputList = TestUtils.readFileIntoList("C:\\Users\\Michael Stipsits\\AdvenToCode\\src\\test\\resources\\day2.txt");
        int actual = Day2.calculatePosition(inputList);
        assertEquals(1936494, actual);
    }
}