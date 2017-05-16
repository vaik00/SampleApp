package example.com.vkwall.model;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by vaik00 on 16.05.2017.
 */

public interface Model {
Observable<ResponseBody> getVKPhotoFeed(String accessToken, int count, int offset);
}
