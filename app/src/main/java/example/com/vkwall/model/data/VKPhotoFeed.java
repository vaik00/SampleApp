package example.com.vkwall.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class VKPhotoFeed {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("source_id")
    @Expose
    public Integer sourceId;
    @SerializedName("date")
    @Expose
    public Integer date;
    @SerializedName("photos")
    @Expose
    public VKPhotoFeedPhotos photos;
    @SerializedName("post_id")
    @Expose
    public Integer postId;

}
