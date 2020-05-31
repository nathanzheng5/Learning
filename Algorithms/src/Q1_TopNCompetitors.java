import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q1_TopNCompetitors {
    // test id: 23280666295409

    @Test
    public void test() {
        ArrayList<String> result = topNCompetitors(0, 1, Collections.emptyList(),
                0, Collections.emptyList());
        assertTrue(result.isEmpty());

        result = topNCompetitors(2, 1, Arrays.asList("Costco", "Walmart"),
                0, Collections.emptyList());
        assertTrue(result.isEmpty());

        result = topNCompetitors(0, 1, Collections.emptyList(),
                1, Arrays.asList("If I buy from Costco, I have longer warranty",
                        "Love it! This thing sells like 8 bucks from walmart! I'm not going to Walmart again!!!"));
        assertTrue(result.isEmpty());

        // only select the top 1 competitor
        result = topNCompetitors(2, 1, Arrays.asList("Costco", "Walmart"),
                1, Arrays.asList("If I buy from Costco, I have longer warranty",
                        "Love it! This thing sells like 8 bucks from walmart! I'm not going to Walmart again!!!"));
        assertEquals(Collections.singletonList("costco"), result);

        // select the top 2 competitors. walmart gets mentioned twice in one review so it should only be counted once
        result = topNCompetitors(2, 2, Arrays.asList("Costco", "Walmart"),
                1, Arrays.asList("If I buy from Costco, I have longer warranty",
                        "Love it! This thing sells like 8 bucks from walmart! I'm not going to Walmart again!!!"));
        assertEquals(Arrays.asList("costco", "walmart"), result);

        // reverse the order of reviews - check that they are sorted alphabetically
        result = topNCompetitors(2, 2, Arrays.asList("Costco", "Walmart"),
                1, Arrays.asList("Love it! This thing sells like 8 bucks from walmart! I'm not going to Walmart again!!!",
                        "If I buy from Costco, I have longer warranty"));
        assertEquals(Arrays.asList("costco", "walmart"), result);

        // walmart appears in 2 reviews so it beats costco
        result = topNCompetitors(2, 2, Arrays.asList("Costco", "Walmart"),
                1, Arrays.asList("If I buy from Costco, I have longer warranty",
                        "Love it! This thing sells like 8 bucks from walmart! I'm not going to Walmart again!!!",
                        "didn't get this in time. Cancelled the order and went to walmart to get it"));
        assertEquals(Arrays.asList("walmart", "costco"), result);
    }

    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {
        // I don't know why numCompetitors and numReviews are supplied - can just get from list size
        // assume they are correct...
        if (numCompetitors <= 0 || topNCompetitors <= 0 || numReviews <= 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> numMentionsMap = buildNumMentionsMap(competitors, reviews);

        TopNPriorityQueue q = new TopNPriorityQueue(topNCompetitors);
        numMentionsMap.entrySet().forEach(q::offer);

        ArrayList<String> retVal = new ArrayList<>(topNCompetitors);
        while (!q.isEmpty()) {
            retVal.add(0, q.poll().getKey());
        }
        return retVal;
    }

    private static final String WORD_DELIMITER_PATTERN = "[ ,.;:]";     // or other delimiters.
    private static Map<String, Integer> buildNumMentionsMap(List<String> competitors, List<String> reviews) {
        Map<String, Integer> numMentionsMap = new HashMap<>();
        reviews.forEach(review -> {
            Set<String> reviewWords = Arrays.stream(review.split(WORD_DELIMITER_PATTERN))
                    .map(word -> word.trim().toLowerCase())
                    .collect(Collectors.toSet());
            competitors.stream()
                    .map(competitor -> competitor.trim().toLowerCase())
                    .forEach(competitor -> {
                        if (reviewWords.contains(competitor)) {
                            if (numMentionsMap.containsKey(competitor)) {
                                numMentionsMap.put(competitor, numMentionsMap.get(competitor)+1);
                            } else {
                                numMentionsMap.put(competitor, 1);
                            }
                        }
                    });
        });

        return numMentionsMap;
    }

    private static class TopNPriorityQueue extends PriorityQueue<Map.Entry<String, Integer>> {
        private final int topN;
        TopNPriorityQueue(int topN) {
            super((a, b) -> a.getValue().equals(b.getValue()) ?
                    // if the values are the same, compare the keys (names)
                    // sort alphabetically so reverse the natural string compareTo() result
                    a.getKey().compareTo(b.getKey()) * -1 :
                    // otherwise just compare the values
                    a.getValue().compareTo(b.getValue()));

            this.topN = topN;
        }

        @Override
        public boolean offer(Map.Entry<String, Integer> entry) {
            boolean retVal = super.offer(entry);
            if (size() > topN) {
                poll();
            }
            return retVal;
        }
    }
}
