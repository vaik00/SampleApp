package example.com.vkwall.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vk.sdk.VKAccessToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import example.com.vkwall.model.data.VKPhotoFeed;
import example.com.vkwall.view.PhotoFeedView;
import okhttp3.ResponseBody;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class PhotoFeedPresenter extends BasePresenter {
    private PhotoFeedView mWallView;

    public PhotoFeedPresenter(PhotoFeedView view) {
        mWallView = view;
    }

    public void loadData(int count, int offset) {
        mWallView.showProgress();
        dataRepository.getVKPhotoFeed(VKAccessToken.currentToken().accessToken, count, offset)
                .subscribe(response -> {
                    mWallView.onDataReceived(parseVKResponse(response));
                    mWallView.hideProgress();
                }, Throwable::printStackTrace);
    }

    public void loadMore(int count, int offset) {
        mWallView.showProgress();
        dataRepository.getVKPhotoFeed(VKAccessToken.currentToken().accessToken, count, offset)
                .subscribe(response -> {
                    mWallView.onLoadMore(parseVKResponse(response));
                    mWallView.hideProgress();
                }, Throwable::printStackTrace);
    }

    private List<VKPhotoFeed> parseVKResponse(ResponseBody responseBody) {
        try {
            Gson gson = new Gson();
            String json = new JSONObject(responseBody.string())
                    .getJSONObject("response")
                    .getJSONArray("items")
                    .toString();

            return gson.fromJson(
                    json,
                    new TypeToken<List<VKPhotoFeed>>() {
                    }.getType());
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
