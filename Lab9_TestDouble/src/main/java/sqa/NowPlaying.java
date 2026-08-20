package sqa;

import java.util.List;
import java.util.stream.Collectors;

public class NowPlaying {
    private MovieService movieService;

    public NowPlaying(MovieService movieService){
        this.movieService = movieService;
    }

    public List<String> getNowPlaying(String location, String date){
        List<String> movies = movieService.getMovies(location, date);
        return movies.stream()
            .filter(movie -> movie.contains("VIP"))
            .collect(Collectors.toList());
    }
}
