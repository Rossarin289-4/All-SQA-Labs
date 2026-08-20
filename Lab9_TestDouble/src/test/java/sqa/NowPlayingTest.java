package sqa;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;


public class NowPlayingTest {
    @Test
    void shouldReturnOnlyVIPMovies(){
        MovieService stub = new MovieServiceStub();
        NowPlaying nowPlaying = new NowPlaying(stub);

        List<String> result = nowPlaying.getNowPlaying("KKU Cinema", "2026-08-20");
        
        assertEquals(2, result.size());

        assertTrue(result.contains("Spider-Man: Brand New Day - VIP"));
        assertTrue(result.contains("Zootopia 3 - VIP"));

        assertFalse(result.contains("The Odyssey - Regular"));
        assertFalse(result.contains("Inside Out 2 - Regular"));
        
    }
}
