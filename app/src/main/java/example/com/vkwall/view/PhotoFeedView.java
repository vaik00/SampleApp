package example.com.vkwall.view;

import java.util.List;

import example.com.vkwall.model.data.VKPhotoFeed;

/**
 * Created by vaik00 on 16.05.2017.
 */

public interface PhotoFeedView {
    void onDataReceived(List<VKPhotoFeed> response);
    void onLoadMore(List<VKPhotoFeed> response);
    void showProgress();
    void hideProgress();
}
