package DataStructure;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author czj
 * @date   2019-06-26 20:49
 */
public class 设计推特_hard {

}
class Twitter {
	int timestamp = 0;
	Map<Integer, List<int[]>> tweets; //tweets[i] 表示 用户 i 的所有 tweet
	Map<Integer, Set<Integer>> followers; //followers[i] 表示 用户 i 的所有follower
    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<int[]> ls = tweets.get(userId);
        if(ls==null) {
        	ls = new ArrayList<>();
        }
        timestamp++;
        ls.add(new int[] {timestamp,tweetId});
        tweets.put(userId, ls);
        follow(userId, userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> rtn = new ArrayList<>();
    	Set<Integer> followerNum = followers.get(userId);
    	List<int[]> tmp = new ArrayList<>();
    	if(followerNum != null) {
    		for(int n:followerNum) {
        		List<int[]> ls = tweets.get(n);
        		if(ls != null) {
        			tmp.addAll(ls);
        		}
        	}
    	}
    	
    	Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] n1, int[] n2){
                return n2[0] - n1[0];
            }
        });
    	
    	for(int[] a:tmp) {
    		q.add(a);
    	}
    	
    	for(int i=0; i<10 && !q.isEmpty(); i++) {
    		int[] p = q.poll();
    		rtn.add(p[1]);
    	}
    	return rtn;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	Set<Integer> s = followers.get(followerId);
    	if(s==null) {
    		s = new HashSet<>();
    	}
    	s.add(followeeId);
    	followers.put(followerId, s);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	Set<Integer> s = followers.get(followerId);
    	if(s==null || !s.contains(followeeId) || followerId==followeeId)
    		return;
    	s.remove(followeeId);
    	followers.put(followerId,s);
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
