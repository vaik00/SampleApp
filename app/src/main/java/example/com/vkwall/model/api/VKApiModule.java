package example.com.vkwall.model.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class VKApiModule {
    private static VKApiInterface service;
    private static final String BASE_URL = "https://api.vk.com/method/";

    private VKApiModule() {
    }

    public static VKApiInterface getService() {
        if (service == null) {
            OkHttpClient client = new OkHttpClient.Builder().build();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(VKApiInterface.class);
            return service;
        } else {
            return service;
        }
    }
}
