package br.com.aramosdev.infoglobo.home;

import java.util.List;

import br.com.aramosdev.infoglobo.core.BasePresenter;
import br.com.aramosdev.infoglobo.model.api.RestClient;
import br.com.aramosdev.infoglobo.model.news.News;
import br.com.aramosdev.infoglobo.util.TextUtils;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class HomePresenter extends BasePresenter<List<News>, HomeContract.View> implements HomeContract.Interaction {

    public HomePresenter(RestClient api, HomeContract.View view) {
        super(api, view);
    }

    @Override
    public void getNews() {
        mView.showLoading();
        execute(mApi.getServices().getNews());
    }

    @Override
    public void handleResponse(List<News> response) {
        mView.hideLoading();
        if (TextUtils.isEmptyOrNull(response)) mView.tryAgain();

        for (News news : response) {
            if (TextUtils.isEmptyOrNull(news.getContentNewses())) {
                mView.tryAgain();
                return;
            }

            mView.fillBanner(news.getContentNewses().get(0));
            news.getContentNewses().remove(0);
            mView.fillNewsList(news.getContentNewses());
        }
    }

    @Override
    public void handleResponseError(List<News> response) {
        mView.hideLoading();
        mView.tryAgain();
    }
}
