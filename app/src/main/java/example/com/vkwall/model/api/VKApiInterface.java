package example.com.vkwall.model.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by vaik00 on 16.05.2017.
 */

public interface VKApiInterface {
@GET("newsfeed.get")
Observable<ResponseBody> getVKPhotoFeed(
        @Query("filters") String filters,
        @Query("access_token") String accessToken,
        @Query("count") int count,
        @Query("offset") int offset,
        @Query("max_photos") int maxPhotos,
        @Query("v") String version
);
}
