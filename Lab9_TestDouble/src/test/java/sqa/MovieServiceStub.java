package sqa;

import java.util.Arrays;
import java.util.List;

public class MovieServiceStub implements MovieService{
    
    @Override
    public List<String> getMovies(String location, String date){
        return Arrays.asList(
            "The Odyssey - Regular",
            "Spider-Man: Brand New Day - VIP",
            "Inside Out 2 - Regular",
            "Zootopia 3 - VIP"
        );
    }
}
