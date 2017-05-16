package example.com.vkwall.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.vkwall.R;
import example.com.vkwall.model.data.VKPhotoFeed;
import example.com.vkwall.model.data.VKPhotoFeedItem;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class PhotoFeedAdapter extends RecyclerView.Adapter<PhotoFeedAdapter.PhotoFeedViewHolder> {
    private List<VKPhotoFeed> mData;

    public PhotoFeedAdapter() {
        mData = new ArrayList<>();
    }

    public void setData(List<VKPhotoFeed> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public void addData(List<VKPhotoFeed> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PhotoFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotoFeedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PhotoFeedViewHolder holder, int position) {
        VKPhotoFeed item = mData.get(position);
        Picasso.with(holder.itemView.getContext()).load(item.photos.items.get(0).photo604).fit().centerCrop().into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PhotoFeedViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.photo)
        ImageView photo;

        PhotoFeedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
