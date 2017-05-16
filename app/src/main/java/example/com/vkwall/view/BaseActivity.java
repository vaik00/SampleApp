package example.com.vkwall.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.com.vkwall.presenter.BasePresenter;

/**
 * Created by vaik00 on 16.05.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract BasePresenter getPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    protected abstract int getLayoutId();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }
}
