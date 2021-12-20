import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static int countIncrease(List<Integer> input){
        int counter = 0;
        for (int i = 0; i < input.size()-1; i++) {
            if (input.get(i) < input.get(i + 1)) {
                counter++;
            }
        }
        return counter;
    }

    public static int generateNewList(List<Integer> input){
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < input.size()-2; i++) {
            int sum = input.get(i) + input.get(i+1) + input.get(i+2);
            newList.add(sum);
        }
        return countIncrease(newList);
    }

}
