import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord.toLowerCase());
        }

        String[] words = paragraph.split("[ !?',;.]");
        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        String wordWithMaxCount = "";
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            String realWord = word.toLowerCase();
            if (bannedSet.contains(realWord)) {
                continue;
            }
            Integer oldCount = countMap.get(realWord);
            int newCount = oldCount != null ? oldCount + 1 : 1;
            countMap.put(realWord, newCount);
            if (newCount > maxCount) {
                maxCount = newCount;
                wordWithMaxCount = word;
            }
        }

        return wordWithMaxCount.toLowerCase();
    }
}

