package com.nagot.lastfm.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class ImageLoaderUtil {

    public static void loadImage(Context context, String imageUrl, int placeHolderResourceID,
                                 ImageView imageView) {

        WeakReference<Context> weakReference = new WeakReference<>(context);
        Glide.with(weakReference.get()).load(imageUrl).asBitmap()
                .placeholder(placeHolderResourceID).into(imageView);

    }
}
