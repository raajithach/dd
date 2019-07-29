package project.dd;

import android.util.Log;
import androidx.annotation.NonNull;
import project.dd.network.MainActivityContract;
import project.dd.network.NetworkApi;
import project.dd.network.NetworkService;
import project.dd.network.Restaurant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * Class that performs fetching of data.
 */
public class RestaurantsModel implements MainActivityContract.Model
{
    private static final String TAG = RestaurantsModel.class.getSimpleName();
    private static final double LAT = 37.422740;
    private static final double LONG = -122.139956;
    private static final int OFFSET = 0;
    private static final int LIMIT = 50;

    private NetworkService mNetworkService;

    RestaurantsModel(@NonNull final NetworkService networkService) {
        mNetworkService = networkService;
    }

    @Override
    public void getRestaurants(final MainActivityContract.GetRestaurantsCallback callback)
    {
        final NetworkApi networkApi = mNetworkService.getApi();
        networkApi.fetchRestaurants(LAT, LONG, OFFSET,  LIMIT).enqueue(new Callback<List<Restaurant>>()
        {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response)
            {
                if (response.isSuccessful())
                {
                    callback.onSuccess(response);
                }
                else
                {
                    Log.e(TAG, "error in response " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t)
            {
                Log.e(TAG, "error in response ", t);
                callback.onError(null);
            }
        });
    }
}
