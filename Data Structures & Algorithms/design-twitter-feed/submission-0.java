class Twitter {

    private static int timeStamp = 0;

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        Tweet newTweet = new Tweet(tweetId, timeStamp);

        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, newTweet);
        } else {
            newTweet.next = tweetMap.get(userId);
            tweetMap.put(userId, newTweet);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        // Max heap based on time
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Ensure user follows themselves
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followee : followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                maxHeap.offer(tweetMap.get(followee));
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            Tweet curr = maxHeap.poll();
            res.add(curr.id);

            if (curr.next != null) {
                maxHeap.offer(curr.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
