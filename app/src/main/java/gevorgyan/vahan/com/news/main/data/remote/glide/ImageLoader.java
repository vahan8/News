package gevorgyan.vahan.com.news.main.data.remote.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public final class ImageLoader {

    private ImageLoader() {
    }

    public static void load(Context context, ImageView imageView, String url) {
        load(Glide.with(context), imageView, url);
    }

    private static void load(RequestManager requestManager, ImageView imageView, String url) {
        requestManager
                .load(url)
                .into(imageView);
    }

}
