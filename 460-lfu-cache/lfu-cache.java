import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Integer> cache;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        updateFrequency(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (cache.containsKey(key)) {
            cache.put(key, value);
            updateFrequency(key);
            return;
        }

        if (cache.size() >= capacity) {
            int evictKey = freqToKeys.get(minFrequency).iterator().next();
            freqToKeys.get(minFrequency).remove(evictKey);
            if (freqToKeys.get(minFrequency).isEmpty()) {
                freqToKeys.remove(minFrequency);
            }
            cache.remove(evictKey);
            keyToFreq.remove(evictKey);
        }

        cache.put(key, value);
        keyToFreq.put(key, 1);
        minFrequency = 1;
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }

    private void updateFrequency(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFrequency == freq) {
                minFrequency++;
            }
        }
        
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }
}
