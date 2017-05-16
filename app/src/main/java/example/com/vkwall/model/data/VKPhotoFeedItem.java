package example.com.vkwall.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class VKPhotoFeedItem {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("album_id")
    @Expose
    public Integer albumId;
    @SerializedName("owner_id")
    @Expose
    public Integer ownerId;
    @SerializedName("photo_75")
    @Expose
    public String photo75;
    @SerializedName("photo_130")
    @Expose
    public String photo130;
    @SerializedName("photo_604")
    @Expose
    public String photo604;
    @SerializedName("photo_807")
    @Expose
    public String photo807;
    @SerializedName("photo_1280")
    @Expose
    public String photo1280;
    @SerializedName("photo_2560")
    @Expose
    public String photo2560;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("date")
    @Expose
    public Integer date;
    @SerializedName("access_key")
    @Expose
    public String accessKey;
    @SerializedName("likes")
    @Expose
    public VKPhotoFeedLikes likes;
    @SerializedName("comments")
    @Expose
    public VKPhotoFeedComments comments;
    @SerializedName("can_comment")
    @Expose
    public Integer canComment;
    @SerializedName("can_repost")
    @Expose
    public Integer canRepost;
}
