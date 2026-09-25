import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> steps = new HashMap<>();
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        steps.put(beginWord, 0);

        boolean found = false;
        int maxStep = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            String curr = q.poll();
            int step = steps.get(curr);

            if (step >= maxStep) {
                break;
            }

            char[] chars = curr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char orig = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == orig) continue;
                    chars[i] = c;
                    String next = new String(chars);

                    if (dict.contains(next)) {
                        if (!steps.containsKey(next)) {
                            steps.put(next, step + 1);
                            q.add(next);
                            adj.computeIfAbsent(next, k -> new ArrayList<>()).add(curr);
                        } else if (steps.get(next) == step + 1) {
                            adj.computeIfAbsent(next, k -> new ArrayList<>()).add(curr);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                            maxStep = step + 1;
                        }
                    }
                }
                chars[i] = orig;
            }
        }

        if (found) {
            LinkedList<String> path = new LinkedList<>();
            path.addFirst(endWord);
            backtrack(endWord, beginWord, adj, path, res);
        }

        return res;
    }

    private void backtrack(String curr, String beginWord, Map<String, List<String>> adj, LinkedList<String> path, List<List<String>> res) {
        if (curr.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!adj.containsKey(curr)) {
            return;
        }
        for (String prev : adj.get(curr)) {
            path.addFirst(prev);
            backtrack(prev, beginWord, adj, path, res);
            path.removeFirst();
        }
    }
}


