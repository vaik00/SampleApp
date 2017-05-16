package example.com.vkwall.ui;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import example.com.vkwall.R;

/**
 * Created by vaik00 on 16.05.2017.
 */

public class SnackbarHelper {

    public static void showErrorSnackbar(Activity activity, String text){
        Snackbar snackbar = Snackbar
                .make(activity.findViewById(android.R.id.content), text, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(activity, R.color.red500));
        TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }
}
