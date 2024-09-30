
package twitter ;
import static org.junit.Assert.*;

import java.time.Instant;
import java.util.*;

import org.junit.Test;

public class SocialNetworkTest {

    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "Alice", "Hello @Bob", d1);
    private static final Tweet tweet2 = new Tweet(2, "Bob", "Thanks @Alice!", d2);
    private static final Tweet tweet3 = new Tweet(3, "Alice", "Goodbye @Charlie", d1);
    
 
    
    @Test
    public void testInfluencersNoFollowers() {
        Map<String, Set<String>> emptyGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(emptyGraph);
        
        assertTrue("Expected no influencers", influencers.isEmpty());
    }
    
    
    @Test
    public void testfInfluencersNoFollowers() {
        Map<String, Set<String>> emptyGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(emptyGraph);
        
        assertTrue("Expected no influencers", influencers.isEmpty());
    }
}
