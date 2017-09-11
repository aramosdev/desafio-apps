package br.com.aramosdev.infoglobo.newsdetail;

import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.util.DateUtils;
import br.com.aramosdev.infoglobo.util.TextUtils;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class NewsDetailPresenter implements NewsDetailContract.Interaction {

    private NewsDetailContract.View mView;

    public NewsDetailPresenter(NewsDetailContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleContentNews(ContentNews contentNews) {
        if (contentNews == null) return;

        if (contentNews.getSection() != null) {
            mView.showSectionText(contentNews.getSection().getName());
        }
        mView.showTitle(contentNews.getTitle());
        mView.showSubtitle(contentNews.getSubtitle());
        if (!TextUtils.isEmptyOrNull(contentNews.getAuthors())) {
            mView.showByAuthor(contentNews.getAuthors()[0]);
        }

        mView.showPublished(DateUtils.formatDateTimeTimezone(contentNews.getPublished()));
        mView.showBanner(contentNews);
        mView.showText(contentNews.getText());
    }
}
