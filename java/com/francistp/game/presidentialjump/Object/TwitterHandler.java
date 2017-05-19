package com.francistp.game.presidentialjump.Object;

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
    private static final int AMOUNT_OF_TWEET = 25;
    private static String[] tweets;
    private static int tweetPosition;

    public static String TRUMP = "realDonaldTrump";

    public static void configureTwitter() {
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMER_KEY).setOAuthConsumerSecret(CONSUMER_SECRET).setOAuthAccessToken(ACCESS_KEY).setOAuthAccessTokenSecret(ACCESS_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        areTweetsLoaded = false;
        looped = false;
        twitterUser = TRUMP; // will need to check for character soon
        tweets = new String[AMOUNT_OF_TWEET];
        tweetPosition = 0;
    }

    private static void resetVariables() {
        areTweetsLoaded = false;
        looped = false;
        twitterUser = "realDonaldTrump";
        tweets = new String[AMOUNT_OF_TWEET];
        tweetPosition = 0;
    }

    public static void loadTweets() {
        if (!areTweetsLoaded) {
            try {
                Paging paging = new Paging(1, AMOUNT_OF_TWEET);
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
                            tweets = new String[] {"Sorry, no tweets!"};
                        }
                    }
                }
            } catch (TwitterException e) {
                System.out.println("Error fetching tweets: " + e.getMessage());
                tweets = new String[]{"There was an issue getting " + twitterUser + "s tweets, check your internet connection!"};
            }
            areTweetsLoaded = true;
        }

        System.out.println("LOADING TWEETS: ");
        for (String tweet : tweets) {
            System.out.println(tweet);
        }
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
