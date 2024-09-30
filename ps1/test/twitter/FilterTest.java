
package twitter;
import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilterTest {

    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "This is a tweet.", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "Another tweet here.", d2);
    private static final Tweet tweet3 = new Tweet(3, "alyssa", "Tweeting again!", d1);

    @Test
    public void testWrittenBy() {
        List<Tweet> result = Filter.writtenBy(Arrays.asList(tweet1, tweet2, tweet3), "alyssa");
        assertEquals("expected two tweets by alyssa", 2, result.size());
        assertTrue("should contain tweet1", result.contains(tweet1));
        assertTrue("should contain tweet3", result.contains(tweet3));
    }

    @Test
    public void testInTimespan() {
        Timespan timespan = new Timespan(d1, d2);
        List<Tweet> result = Filter.inTimespan(Arrays.asList(tweet1, tweet2), timespan);
        assertEquals("expected two tweets in timespan", 2, result.size());
    }

    @Test
    public void testInTimespanNoTweets() {
        Timespan timespan = new Timespan(d1, d2);
        Tweet tweetOutside = new Tweet(4, "user", "This tweet is outside the timespan.", Instant.parse("2016-02-17T12:00:00Z"));
        List<Tweet> result = Filter.inTimespan(Arrays.asList(tweetOutside), timespan);
        assertTrue("expected no tweets in timespan", result.isEmpty());
    }



    @Test
    public void testContainingNoMatches() {
        List<String> words = Arrays.asList("noMatch");
        List<Tweet> result = Filter.containing(Arrays.asList(tweet1, tweet2), words);
        assertTrue("expected no tweets containing the words", result.isEmpty());
    }
}
