import java.util.*;

class Twitter {
    private static int timestamp = 0;

    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> userFollows;
    private Map<Integer, List<Tweet>> userTweets;

    public Twitter() {
        userFollows = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        List<Tweet> myTweets = userTweets.get(userId);
        if (myTweets != null) {
            int size = myTweets.size();
            for (int i = Math.max(0, size - 10); i < size; i++) {
                maxHeap.add(myTweets.get(i));
            }
        }
        
        Set<Integer> followees = userFollows.get(userId);
        if (followees != null) {
            for (int followeeId : followees) {
                if (followeeId == userId) continue;
                List<Tweet> fTweets = userTweets.get(followeeId);
                if (fTweets != null) {
                    int size = fTweets.size();
                    for (int i = Math.max(0, size - 10); i < size; i++) {
                        maxHeap.add(fTweets.get(i));
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userFollows.containsKey(followerId)) {
            userFollows.put(followerId, new HashSet<>());
        }
        userFollows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            userFollows.get(followerId).remove(followeeId);
        }
    }
}
