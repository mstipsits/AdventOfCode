import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static final String COMMAND_FORWARD = "forward";
    public static final String COMMAND_DOWN = "down";
    public static final String COMMAND_UP = "up";


    public static int calculatePosition(List<String> input) {
        List<String> forward = input.stream().filter(i -> i.startsWith(COMMAND_FORWARD)).collect(Collectors.toList());
        int sumForward = sum(forward, COMMAND_FORWARD);

        List<String> down = input.stream().filter(i -> i.startsWith(COMMAND_DOWN)).collect(Collectors.toList());
        int sumDown = sum(down, COMMAND_DOWN);

        List<String> up = input.stream().filter(i -> i.startsWith(COMMAND_UP)).collect(Collectors.toList());
        int sumUp = sum(up, COMMAND_UP);

        return sumForward * (sumDown - sumUp);
    }

    private static int sum(List<String> inputList, String commandToRemove) {
        int sum = 0;
        for (String element : inputList) {
            sum = sum + removeCommand(element, commandToRemove);
        }
        return sum;
    }

    private static int removeCommand(String input, String commandToRemove) {
        input = input.replace(commandToRemove, "");
        input = input.replace(" ", "");
        return Integer.parseInt(input);
    }
}
