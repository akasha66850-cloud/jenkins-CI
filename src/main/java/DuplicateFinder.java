import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateFinder {

    public static List<Integer> findDuplicates(int[] numbers) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();   // <-- preserves order

        for (int n : numbers) {
            if (!seen.add(n)) {
                duplicates.add(n);
            }
        }
        return new ArrayList<>(duplicates);
    }


    /** Returns duplicated values with how many times each occurs. */
    public static Map<Integer, Long> countDuplicates(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }


    /** Fast check whether any duplicate exists. */
    public static boolean hasDuplicates(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");
        Set<Integer> seen = new HashSet<>();
        for (int n : numbers) {
            if (!seen.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 7, 2, 4, 9, 4, 1};
        System.out.println("Duplicates: " + findDuplicates(data));
        System.out.println("Counts:     " + countDuplicates(data));
        System.out.println("Has dupes?  " + hasDuplicates(data));
    }
}
