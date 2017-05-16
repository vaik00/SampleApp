package example.com.vkwall.model;

import example.com.vkwall.model.api.VKApiInterface;
import example.com.vkwall.model.api.VKApiModule;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class ModelImpl implements Model {
    private final Observable.Transformer schedulersTransformer;
    private VKApiInterface vkApiInterface = VKApiModule.getService();

    public ModelImpl() {
        schedulersTransformer = o -> ((Observable) o).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResponseBody> getVKPhotoFeed(String accessToken, int count, int offset) {
        return vkApiInterface
                .getVKPhotoFeed("photo", accessToken, count, offset, 1, "5.12")
                .compose(applySchedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }
}
