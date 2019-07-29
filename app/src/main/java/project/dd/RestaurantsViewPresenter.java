package project.dd;

import project.dd.network.MainActivityContract;
import project.dd.network.NetworkService;
import project.dd.network.Restaurant;
import retrofit2.Response;

import java.util.List;

public class RestaurantsViewPresenter implements MainActivityContract.Presenter, MainActivityContract.GetRestaurantsCallback
{
    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    RestaurantsViewPresenter(MainActivityContract.View view, NetworkService networkService) {
        mView = view;
        mModel = new RestaurantsModel(networkService);
        mView.setupUI();
        getRestaurants();
    }

    @Override
    public void getRestaurants()
    {
        mModel.getRestaurants(this);
    }

    @Override
    public void onSuccess(Response<List<Restaurant>> response)
    {
        mView.displayRestaurants(response.body());
    }

    @Override
    public void onError(Response<List<Restaurant>> response)
    {
        mView.displayRestaurants(response.body());
    }
}
