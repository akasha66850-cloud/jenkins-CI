import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateFinderTest {

    @Test
    void findsEachDuplicateOnce() {
        assertEquals(List.of(2,4),
                DuplicateFinder.findDuplicates(new int[]{4, 2, 7, 2, 4, 9,
                        4, 1}));
    }

    @Test
    void countsOccurrences() {
        assertEquals(Map.of(4, 3L, 2, 2L),
                DuplicateFinder.countDuplicates(new int[]{4, 2, 7, 2, 4, 9
                        , 4, 1}));
    }

    @Test
    void returnsEmptyWhenNoDuplicates() {
        assertTrue(DuplicateFinder.findDuplicates(new int[]{1, 2, 3}).isEmpty());
    }

    @Test
    void handlesEmptyAndSingleElement() {
        assertTrue(DuplicateFinder.findDuplicates(new int[]{}).isEmpty());
        assertFalse(DuplicateFinder.hasDuplicates(new int[]{5}));
    }

    @Test
    void rejectsNull() {
        assertThrows(NullPointerException.class,
                () -> DuplicateFinder.findDuplicates(null));
    }
}
