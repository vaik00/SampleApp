package example.com.vkwall.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vk.sdk.VKSdk;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.com.vkwall.R;
import example.com.vkwall.model.data.VKPhotoFeed;
import example.com.vkwall.presenter.BasePresenter;
import example.com.vkwall.presenter.PhotoFeedPresenter;
import example.com.vkwall.ui.EndlessRecyclerViewScrollListener;
import example.com.vkwall.view.adapter.PhotoFeedAdapter;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class PhotoFeedActivity extends BaseActivity implements PhotoFeedView {
    @Bind(R.id.photo_feed_recycler)
    RecyclerView photoFeedRecycler;
    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;

    private PhotoFeedPresenter mPresenter;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    private EndlessRecyclerViewScrollListener scrollListener;
    private PhotoFeedAdapter mPhotoAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark);
        photoFeedRecycler.setLayoutManager(linearLayoutManager);
        photoFeedRecycler.setNestedScrollingEnabled(false);
        mPhotoAdapter = new PhotoFeedAdapter();
        photoFeedRecycler.setAdapter(mPhotoAdapter);
        mPresenter = new PhotoFeedPresenter(this);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mPresenter.loadMore(5, totalItemsCount);
            }
        };
        photoFeedRecycler.addOnScrollListener(scrollListener);
        swipeRefreshLayout.setOnRefreshListener(this::reloadData);
        mPresenter.loadData(5, 0);
    }

    private void reloadData(){
        mPresenter.loadData(5, 0);
        scrollListener.reset(mPhotoAdapter.getItemCount(), false);
    }

    @Override
    public void onDataReceived(List<VKPhotoFeed> response) {
        mPhotoAdapter.setData(response);
    }

    @Override
    public void onLoadMore(List<VKPhotoFeed> response) {
        mPhotoAdapter.addData(response);

    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vk_photo_feed;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        VKSdk.logout();
    }
}
