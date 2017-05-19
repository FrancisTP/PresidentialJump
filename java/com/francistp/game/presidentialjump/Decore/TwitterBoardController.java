package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Text;
import com.francistp.game.presidentialjump.Menues.GameScreen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Francis on 2017-05-18.
 */
public class TwitterBoardController {

    private List<TwitterBoard> twitterBoards;
    private boolean firstBoardShown;
    private int initialWait, interval, intervalCounter;
    private final float speedMultiplier = 0.5f;

    public TwitterBoardController() {
        twitterBoards = new ArrayList<TwitterBoard>();
        firstBoardShown = false;
        initialWait = 500;
        interval = 2000;
        intervalCounter = 0;

        if (!TwitterHandler.areTweetsLoaded()) {
            TwitterHandler.loadTweets();
        }
    }

    public void update(float deltaTime) {
        if (!firstBoardShown) {
            if (intervalCounter < initialWait) {
                intervalCounter++;
            } else {
                if (!TwitterHandler.hasLooped()) {
                    Text tweetText = new Text(TwitterHandler.getTweet(), 7, "white", "left", (480 - TwitterBoard.width) / 2, 800, TwitterBoard.width, true);
                    while (tweetText.getY() - tweetText.getBackgroundHeight() < 810) {
                        tweetText.addY(10);
                    }

                    float tbY = tweetText.getY() - (tweetText.getHeight() / 2);
                    twitterBoards.add(new TwitterBoard(tweetText, tbY));
                }

                intervalCounter = 0;
                firstBoardShown = true;
            }
        } else {
            if (intervalCounter < interval) {
                intervalCounter++;
            } else {
                if (!TwitterHandler.hasLooped()) {
                    Text tweetText = new Text(TwitterHandler.getTweet(), 7, "white", "left", (480 - TwitterBoard.width) / 2, 800, TwitterBoard.width, true);
                    while (tweetText.getY() - tweetText.getBackgroundHeight() < 810) {
                        tweetText.addY(10);
                    }

                    float tbY = tweetText.getY() - (tweetText.getHeight() / 2);
                    twitterBoards.add(new TwitterBoard(tweetText, tbY));
                }

                intervalCounter = 0;
            }
        }

        // update boards
        List<Integer> positionsToRemove = new ArrayList<Integer>();
        int positionCounter = 0;
        for (TwitterBoard twitterBoard : twitterBoards) {
            if (twitterBoard.destroy()) {
                positionsToRemove.add(new Integer(positionCounter));
            } else {
                twitterBoard.update(deltaTime, GameScreen.scrollSpeed * speedMultiplier);
            }
            positionCounter++;
        }

        ListIterator iterator = positionsToRemove.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        while (iterator.hasPrevious()) {
            twitterBoards.remove(((Integer) iterator.previous()).intValue());
        }
    }

    public void render(SpriteBatcher batcher) {
        Iterator iterator = twitterBoards.iterator();
        while (iterator.hasNext()) {
            ((TwitterBoard)iterator.next()).render(batcher);
        }
    }
}
