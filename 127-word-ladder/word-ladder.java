import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        startSet.add(beginWord);
        endSet.add(endWord);
        
        int steps = 1;

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : startSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;
                        String nextWord = new String(chars);

                        if (endSet.contains(nextWord)) {
                            return steps + 1;
                        }

                        if (dict.contains(nextWord)) {
                            nextSet.add(nextWord);
                            dict.remove(nextWord);
                        }
                    }
                    chars[i] = old;
                }
            }
            startSet = nextSet;
            steps++;
        }

        return 0;
    }
}
