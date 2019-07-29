package project.dd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import project.dd.network.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageLoader mImageLoader;

        ViewHolder(View itemView, ImageLoader imageLoader)
        {
            super(itemView);
            mImageLoader = imageLoader;
        }

        void bind(Restaurant restaurant) {
            ImageView imageView = itemView.findViewById(R.id.coverimage);
            mImageLoader.loadImageInto(restaurant.getCoverImageUrl(), imageView);
            TextView nameTextView = itemView.findViewById(R.id.name);
            nameTextView.setText(restaurant.getName());

            TextView descriptionView = itemView.findViewById(R.id.desc);
            descriptionView.setText(restaurant.getDescription());

            TextView statusView = itemView.findViewById(R.id.status);
            statusView.setText(restaurant.getStatus());
        }
    }

    private final List<Restaurant> items = new ArrayList<>();
    private final ImageLoader mImageLoader;

    RestaurantsAdapter(@NonNull final ImageLoader imageLoader) {
        mImageLoader = imageLoader;
    }

    @NonNull
    @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(view, mImageLoader);
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public void update(List<Restaurant> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }
}