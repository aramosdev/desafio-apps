package br.com.aramosdev.infoglobo.newslist;

import br.com.aramosdev.infoglobo.model.news.ContentNews;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public interface NewsContract {

    interface View {
        void showContentNews(String url, String title, String type);
    }

    interface Interaction {
        void handleNews(ContentNews contentNews);
    }
}
