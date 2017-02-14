package com.ionel.octavian.testgithub;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by octavian on 1/29/17.
 */

public class Utils {
    public static final String MY_MODEL = "MY_MODEL";
    public static final String URL = "https://api.github.com/repositories";

    public static void setImage(Context context, final ImageView iv, String photo) {
        final Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                iv.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Log.e("RVAdapter", "error loading bitmap");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        Picasso.with(context).load(photo).resize(30, 30).into(target);
    }
}
