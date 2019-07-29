package project.dd;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.squareup.picasso.Picasso;

/**
 * Image loader.
 */
public class ImageLoader
{
    private final Picasso mPicasso;

    ImageLoader(@NonNull final Context context) {
        mPicasso = Picasso.with(context);
    }

    public void loadImageInto(@NonNull String imageUrl, @NonNull final ImageView imageView) {
        mPicasso.load(imageUrl).into(imageView);
    }
}
