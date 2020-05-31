import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Q2_ReorderLogLines {

    @Test
    public void test() {
        List<String> result = reorderLines(2, Arrays.asList("l1 a b c", "l2 1 2 3"));
        assertEquals(Arrays.asList("l1 a b c", "l2 1 2 3"), result);

        result = reorderLines(2, Arrays.asList("l2 1 2 3", "l1 a b c"));
        assertEquals(Arrays.asList("l1 a b c", "l2 1 2 3"), result);

        result = reorderLines(2, Arrays.asList("l2 1 2 3", "l1 a b c", "l3 abc", "l4 b A c"));
        assertEquals(Arrays.asList("l1 a b c", "l3 abc", "l4 b A c", "l2 1 2 3"), result);

        // bad id
        result = reorderLines(2, Arrays.asList("l2 1 2 3", "l1 a b c", "l3 abc", "l4 b a c", "invalid hello!"));
        assertEquals(Arrays.asList("l1 a b c", "l3 abc", "l4 b a c", "l2 1 2 3"), result);

        // empty value
        result = reorderLines(2, Arrays.asList("l2 1 2 3", "l1 a b c", "l3 abc", "l4 b a c", "l5"));
        assertEquals(Arrays.asList("l1 a b c", "l3 abc", "l4 b a c", "l2 1 2 3"), result);
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        // Again, don't know why logFileSize is supplied - can just get from list size
        // assume they are correct...
        if (logFileSize <= 0) {
            return Collections.emptyList();
        }

        // warp the raw lines into comparable objects, store them, and sort them
        List<SortableLine> sortableLines = new ArrayList<>();
        logLines.forEach(line -> {
            try {
                sortableLines.add(new SortableLine(line));
            } catch (InvalidLogLineException e) {
                System.err.println("Ignoring line '" + line + "' - " + e.getMessage());
            }
        });

        Collections.sort(sortableLines);

        // stream output
        return sortableLines.stream()
                .map(line -> line.id + " " + line.value)
                .collect(Collectors.toList());
    }

    private static final String ID_PATTERN = "^[a-z]+\\d+$";
    private static class SortableLine implements Comparable<SortableLine> {
        final String id;
        final String value;

        SortableLine(String line) throws InvalidLogLineException {
            try {
                String[] split = line.split(" ", 2);
                id = split[0].trim().toLowerCase();
                // validate ID
                if (!Pattern.compile(ID_PATTERN).matcher(id).matches()) {
                    throw new InvalidLogLineException("Invalid log id '" + id + "' - need to be alphanumerical with lower case letters");
                }

                this.value = split[1].trim();
                // validate value to be non-empty (otherwise compareTo() using charAt() throws exception)
                if (value.isEmpty()) {
                    throw new InvalidLogLineException("Empty log value");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InvalidLogLineException("Invalid log line '" + line + "' - need to have an ID and a value");
            }
        }

        public int compareTo(SortableLine that) {
            boolean thisValueStartsWithDigit = Character.isDigit(this.value.charAt(0));
            boolean thatValueStartsWithDigit = Character.isDigit(that.value.charAt(0));

            // if both start with letters, compare values using string comparison.
            // if tied, compare id
            if (!thisValueStartsWithDigit && !thatValueStartsWithDigit) {
                int result = this.value.compareTo(that.value);
                if (result != 0) {
                    return result;
                }
                return this.id.compareTo(that.id);

            } else {
                if (thisValueStartsWithDigit && !thatValueStartsWithDigit) {
                    return 1;
                } else if (!thisValueStartsWithDigit && thatValueStartsWithDigit) {
                    return -1;
                } else {
                    // return original order
                    return 0;
                }
            }
        }
    }

    // expand if needed
    private static class InvalidLogLineException extends Exception {
        public InvalidLogLineException(String msg) {
            super(msg);
        }
    }
}
