package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.presidentialjump.Settings.Saves;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Francis on 2017-05-18.
 */
public class TwitterHandler {

    private static final String CONSUMER_KEY = "5sYR7oenEAsbxvl1m2j4AI2vS";
    private static final String CONSUMER_SECRET = "Uvf2zXE0NOAwBDoiTBjNJ6T88i6UYIdBxcLTmyaRTs8jT5MtVH";
    private static final String ACCESS_KEY = "371848491-e4FtFntbfaT9WSzs7MJQD3H1sjTwY02IYrQW3NHG";
    private static final String ACCESS_SECRET = "VspSNeSi5pMFvsk47I3G8nyWhdnqhQSoRe5fysfBbNGz3";


    private static ConfigurationBuilder cb;
    private static Twitter twitter;
    private static boolean areTweetsLoaded, looped;
    private static String twitterUser;
    private static final int TWEETS_PER_USER = 50;
    private static String[] tweets;
    private static int tweetPosition;

    public static String TRUMP = "realDonaldTrump";

    private static final String noTweetsFoundMessage = "Sorry, no tweets!";

    public static void configureTwitter() {
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMER_KEY).setOAuthConsumerSecret(CONSUMER_SECRET).setOAuthAccessToken(ACCESS_KEY).setOAuthAccessTokenSecret(ACCESS_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        areTweetsLoaded = false;
        looped = false;
        twitterUser = TRUMP; // will need to check for character soon
        tweets = new String[TWEETS_PER_USER];
        tweetPosition = 0;
    }

    private static void resetVariables() {
        areTweetsLoaded = false;
        looped = false;
        twitterUser = TRUMP;
        tweets = new String[TWEETS_PER_USER];
        tweetPosition = 0;
    }

    public static void loadTweets() {
        if (!areTweetsLoaded) {
            if (tweets == null || tweets[0] != null || (tweets[0] != null && !tweets[0].isEmpty())) {
                tweets = new String[TWEETS_PER_USER];
            }
            try {
                Paging paging = new Paging(1, TWEETS_PER_USER);
                List<Status> statuses = twitter.getUserTimeline(twitterUser, paging);
                Iterator iterator = statuses.iterator();
                for (int i = 0; i < tweets.length; i++) {
                    if (iterator.hasNext()) {
                        tweets[i] = ((Status)iterator.next()).getText();
                    } else {
                        if (i != 0) {
                            String[] tempTweets = new String[i];
                            for (int r = 0; r < tempTweets.length; r++) {
                                tempTweets[r] = tweets[r];
                                tweets = tempTweets;
                            }

                            break;
                        } else {
                            tweets = new String[] {noTweetsFoundMessage};
                        }
                    }
                }

                if (!tweets[0].equals(noTweetsFoundMessage)) { // Check if any tweets were found
                    // There are tweets
                    String[] existingTweets = Saves.getTweets(twitterUser);
                    if (existingTweets.length == 0) { // no previously saved tweets
                        Saves.saveTweets(twitterUser, tweets);
                    } else { // check if there are any new tweets
                        if (!tweets[0].equals(existingTweets[0])) { // If new tweets, save
                            Saves.saveTweets(twitterUser, tweets);
                        } // if not do nothing, tweets already set
                    }
                }
                areTweetsLoaded = true; // are tweets loaded only set true here so if error occurs, when gameScreen is reloaded it will try to get the tweets again
            } catch (TwitterException e) { // if there was an error check if tweets for user were previously saved
                System.out.println("Error fetching tweets: " + e.getMessage());
                String[] existingTweets = Saves.getTweets(twitterUser);
                if (existingTweets.length > 0) {
                    tweets = existingTweets;
                } else {
                    tweets = new String[]{"There was an issue getting " + twitterUser + "s tweets, check your internet connection!"};
                }
            }
        }

        // validate that no tweet is null or empty or just spaces
        List tempTweets = new ArrayList();

        for (int i=0; i<tweets.length; i++) {
            if (tweets[i] != null && !tweets[i].isEmpty() && tweets[i].trim().length() > 0) { // tweet is not null, empty or composed of only white spaces
                tempTweets.add(tweets[i]);
            }
        }

        tweets = new String[tempTweets.size()];
        Iterator iterator = tempTweets.iterator();
        int tweetCounter = 0;
        while(iterator.hasNext()) {
            tweets[tweetCounter] = ((String)iterator.next());
            tweetCounter++;
        }

        // tweets are populated with no null strings, so can be freely used with the text class
    }

    public static void setTwitterUser(String tU) {
        twitterUser = tU;
        resetVariables();
    }

    public static String getTweet() {
        String tweetToReturn = tweets[tweetPosition];

        tweetPosition++;
        if (tweetPosition >= tweets.length) {
            tweetPosition = 0;
            if (!looped) {
                looped = true;
            }
        }

        return tweetToReturn;
    }

    public static boolean hasLooped() {
        return looped;
    }

    public static boolean areTweetsLoaded() {
        return areTweetsLoaded;
    }
}
