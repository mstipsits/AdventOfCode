import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestUtils {

    public static List<String> readFileIntoList(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> lines = Collections.emptyList();
        try {
            ClassLoader classLoader = TestUtils.class.getClassLoader();
            File file = new File(fileName);
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Problem reading file " + fileName + " " + e.getMessage());
        }
        return lines;
    }

    public static List<Integer> readFileIntoListInteger(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> lines = Collections.emptyList();
        List<Integer> numbers = Collections.emptyList();

        try {
            ClassLoader classLoader = TestUtils.class.getClassLoader();
            File file = new File(fileName);
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
            numbers = convertStringListToIntList(
                    lines,
                    Integer::parseInt);
        } catch (IOException e) {
            System.err.println("Problem reading file " + fileName + " " + e.getMessage());
        }
        return numbers;
    }

    public static List<Long> readFileIntoListLong(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> lines = Collections.emptyList();
        List<Long> numbers = Collections.emptyList();

        try {
            ClassLoader classLoader = TestUtils.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
            numbers = convertStringListToIntList(
                    lines,
                    Long::parseLong);
        } catch (IOException e) {
            System.err.println("Problem reading file " + fileName + " " + e.getMessage());
        }
        return numbers;
    }

    public static <T, U> List<U>
    convertStringListToIntList(List<T> listOfString,
                               Function<T, U> function)
    {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}