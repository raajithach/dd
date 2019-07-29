package project.dd.network;

import retrofit2.Response;

import java.util.List;

public interface MainActivityContract {

    /**
     * Interface to fetch data.
     */
    interface Model {
        void getRestaurants(final GetRestaurantsCallback callback);
    }

    /**
     * Interface to perform UI operations.
     */
    interface View {

        void setupUI();

        void displayRestaurants(List<Restaurant> restaurants);
    }

    /**
     * Interface to communicate updates from Model to View.
     */
    interface Presenter {
        void getRestaurants();
    }

    /**
     * Callback to be invoked on fetching restaurants.
     */
    interface GetRestaurantsCallback {
        void onSuccess(Response<List<Restaurant>> response);
        void onError(Response<List<Restaurant>> response);
    }
}
