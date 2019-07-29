package project.dd.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * API to fetch data over network.
 */
public interface NetworkApi {

    @GET("/v2/restaurant")
    Call<List<Restaurant>> fetchRestaurants(@Query("lat") double lat, @Query("lng") double lng, @Query("offset") int offset,
                                            @Query("limit") int limit);

    @GET("/v2/restaurant/{restaurant_id}")
    Call<Restaurant> fetchRestaurantById(@Path("restaurant_id") long id);
}
