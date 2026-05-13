class Twitter {
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Integer>> tweet;
    PriorityQueue<int[]> feed;
    int time;
    public Twitter() {
        this.following = new HashMap<>();
        this.tweet = new HashMap<>();
        this.feed = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweet.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
        feed.offer(new int[]{time++, userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if((!following.containsKey(userId) || following.get(userId).size() == 0) && !tweet.containsKey(userId)) {
            return tweet.getOrDefault(userId, new ArrayList<>());
        }
        int postCount = 0;
        List<Integer> newsFeed = new ArrayList<>();
        List<int[]> latestTweets = new ArrayList<>();
        while(!feed.isEmpty() && postCount < 10) {
            int[] post = feed.poll();
            if(post[1] == userId || following.getOrDefault(userId, new HashSet<>()).contains(post[1])) {
                newsFeed.add(post[2]);
                postCount++;
            }
            latestTweets.add(post);
        }
        feed.addAll(latestTweets);
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId) || !following.get(followerId).contains(followeeId))
            return;
        following.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
