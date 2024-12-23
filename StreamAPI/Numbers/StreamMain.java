package StreamAPI.Numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
        public static void main(String[] args) {
                List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
                intList.stream()
                .filter(value -> value>0)
                .filter(value -> value%2==0)
                .sorted(Comparator.naturalOrder())
                .forEach(value -> System.out.print(value + " "));
        }
}
