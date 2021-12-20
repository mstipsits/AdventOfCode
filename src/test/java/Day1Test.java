import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @org.junit.jupiter.api.Test
    void testCountIncrease() {
        List<Integer> myList = TestUtils.readFileIntoListInteger("C:\\Users\\Michael Stipsits\\AdvenToCode\\src\\test\\resources\\day1.txt");
        int actual = Day1.countIncrease(myList);
        assertEquals(1709, actual);
    }

    @org.junit.jupiter.api.Test
    void testCountIncrease2() {
        List<Integer> myList = TestUtils.readFileIntoListInteger("C:\\Users\\Michael Stipsits\\AdvenToCode\\src\\test\\resources\\day1.txt");
        int actual = Day1.generateNewList(myList);
        assertEquals(1761, actual);
    }
}