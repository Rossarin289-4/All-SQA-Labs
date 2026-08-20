package sqa;
import java.util.List;

public interface MovieService {
    List<String> getMovies(String location, String date);
}
