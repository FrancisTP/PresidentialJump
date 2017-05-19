package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Francis on 2017-05-18.
 */
public class TwitterBoardController {

    private List<TwitterBoard> twitterBoards;
    private int interval, intervalCounter;

    public TwitterBoardController() {
        twitterBoards = new ArrayList<TwitterBoard>();
        interval = 600;
        intervalCounter = 0;

        if (!TwitterHandler.areTweetsLoaded()) {
            TwitterHandler.loadTweets();
        }
    }

    public void update(float deltaTime) {
        if (intervalCounter < interval) {
            intervalCounter++;
        } else {
            Text tweetText = new Text(TwitterHandler.getTweet(), 7, "white", "left", (480-TwitterBoard.width)/2, 800, TwitterBoard.width, true);
            while(tweetText.getY() - tweetText.getBackgroundHeight() < 810) {
                tweetText.addY(10);
            }

            float tbY = tweetText.getY() - (tweetText.getHeight()/2);
            twitterBoards.add(new TwitterBoard(tweetText, tbY));

            intervalCounter = 0;
        }

        List<Integer> positionsToRemove = new ArrayList<Integer>();
        int positionCounter = 0;
        for (TwitterBoard twitterBoard : twitterBoards) {
            if (twitterBoard.destroy()) {
                positionsToRemove.add(new Integer(positionCounter));
            } else {
                twitterBoard.update(deltaTime, -1.5f);
            }
            positionCounter++;
        }

        ListIterator iterator = positionsToRemove.listIterator();
        while(iterator.hasPrevious()) {
            twitterBoards.remove(iterator.previous());
            System.out.println("REMOVING TWEETER BOARD");
        }
    }

    public void render(SpriteBatcher batcher) {
        Iterator iterator = twitterBoards.iterator();
        while (iterator.hasNext()) {
            ((TwitterBoard)iterator.next()).render(batcher);
        }
    }
}
