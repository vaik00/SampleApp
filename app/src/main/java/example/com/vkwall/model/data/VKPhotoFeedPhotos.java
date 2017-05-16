package example.com.vkwall.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class VKPhotoFeedPhotos {
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("items")
    @Expose
    public List<VKPhotoFeedItem> items = null;
}
