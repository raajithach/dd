package project.dd;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import project.dd.network.MainActivityContract;
import project.dd.network.NetworkService;
import project.dd.network.Restaurant;

import java.util.List;

/**
 * Main activity.
 */
public class MainActivity extends AppCompatActivity implements MainActivityContract.View
{
    private MainActivityContract.Presenter mPresenter;
    private RestaurantsAdapter mRestaurantsAdapter;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageLoader = new ImageLoader(getApplicationContext());
        mPresenter = new RestaurantsViewPresenter(this, new NetworkService());
    }

    @Override
    public void setupUI()
    {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

        DividerItemDecoration itemDecor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecor);

        mRestaurantsAdapter = new RestaurantsAdapter(mImageLoader);
        recyclerView.setAdapter(mRestaurantsAdapter);
    }

    @Override
    public void displayRestaurants(List<Restaurant> restaurants)
    {
        mRestaurantsAdapter.update(restaurants);
    }
}
