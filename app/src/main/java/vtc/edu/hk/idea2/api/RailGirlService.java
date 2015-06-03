package vtc.edu.hk.idea2.api;

import retrofit.http.Body;
import retrofit.http.POST;
import vtc.edu.hk.idea2.data.IdeaItem;

//http://square.github.io/retrofit/
public interface RailGirlService {
    @POST("/ideas/new")
    void createIdea(@Body IdeaItem idea);
}
