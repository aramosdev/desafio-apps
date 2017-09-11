package br.com.aramosdev.infoglobo.newslist;

import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.util.TextUtils;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class NewsPresenter implements NewsContract.Interaction {

    private NewsContract.View mView;

    public NewsPresenter(NewsContract.View view) {
        mView = view;
    }

    @Override
    public void handleNews(ContentNews contentNews) {
        if (contentNews == null) return;

        if (!TextUtils.isEmptyOrNull(contentNews.getImages())
                && contentNews.getImages().get(0) != null
                && contentNews.getSection() != null
                && !TextUtils.isNullOrEmpty(contentNews.getImages().get(0).getUrl())
                && !TextUtils.isNullOrEmpty(contentNews.getTitle())) {

            mView.showContentNews(contentNews.getImages().get(0).getUrl(), contentNews.getTitle(),
                    contentNews.getSection().getName());
        }
    }
}
