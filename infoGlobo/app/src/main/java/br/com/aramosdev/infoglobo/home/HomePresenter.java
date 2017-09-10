package br.com.aramosdev.infoglobo.home;

import java.util.List;

import br.com.aramosdev.infoglobo.core.BasePresenter;
import br.com.aramosdev.infoglobo.model.api.RestClient;
import br.com.aramosdev.infoglobo.model.news.News;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class HomePresenter extends BasePresenter<List<News>, HomeContract.View> implements HomeContract.Interaction {

    public HomePresenter(RestClient api, HomeContract.View view) {
        super(api, view);
    }

    @Override
    public void getNews() {
        execute(mApi.getServices().getNews());
    }

    @Override
    public void handleResponse(List<News> response) {

        for (News news : response) {
//            news.
        }



    }

    @Override
    public void handleResponseError(List<News> response) {

    }
}
