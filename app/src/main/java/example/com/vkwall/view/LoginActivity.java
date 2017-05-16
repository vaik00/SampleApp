package example.com.vkwall.view;

import android.content.Intent;
import android.os.Bundle;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.vkwall.R;
import example.com.vkwall.presenter.BasePresenter;
import example.com.vkwall.ui.SnackbarHelper;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class LoginActivity extends BaseActivity implements LoginView {
    private static final String[] sVkScope = new String[]{
            VKScope.WALL,
            VKScope.FRIENDS,
            VKScope.OFFLINE
    };

    @OnClick(R.id.login_button)
    void onLoginClick() {
        VKSdk.login(LoginActivity.this, sVkScope);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKCallback<VKAccessToken> callback = new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                onLogin();
            }

            @Override
            public void onError(VKError error) {
                showError(error.errorMessage);
            }
        };

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onLogin() {
        startActivity(new Intent(this, PhotoFeedActivity.class));
    }

    @Override
    public void showError(String errorMessage) {
        SnackbarHelper.showErrorSnackbar(this, errorMessage);
    }
}
