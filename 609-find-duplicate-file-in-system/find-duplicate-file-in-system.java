import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {
                int openIdx = parts[i].indexOf('(');
                int closeIdx = parts[i].indexOf(')');
                
                String fileName = parts[i].substring(0, openIdx);
                String content = parts[i].substring(openIdx + 1, closeIdx);
                
                String fullPath = dir + "/" + fileName;
                
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }

        return result;
    }
}
