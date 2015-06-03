package vtc.edu.hk.idea2.api;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import vtc.edu.hk.idea2.data.IdeaItem;

//http://square.github.io/retrofit/
//http://themakeinfo.com/2015/04/retrofit-android-tutorial/
public interface RailGirlService {
    @POST("/ideas.json")
    void createIdea(@Body IdeaItem ideaItem, Callback<IdeaItem> response);
}
