package example.com.vkwall.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class VKPhotoFeedLikes {
    @SerializedName("user_likes")
    @Expose
    public Integer userLikes;
    @SerializedName("count")
    @Expose
    public Integer count;
}
