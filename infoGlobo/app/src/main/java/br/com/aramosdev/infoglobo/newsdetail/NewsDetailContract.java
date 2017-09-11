package br.com.aramosdev.infoglobo.newsdetail;

import br.com.aramosdev.infoglobo.model.news.ContentNews;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public interface NewsDetailContract {
    interface View {
        void showTitle(String title);
        void showSubtitle(String subtitle);
        void showByAuthor(String author);
        void showPublished(String dateTimeTimezone);
        void showBanner(ContentNews contentNews);
        void showText(String text);
        void showSectionText(String sectionName);
    }
    interface Interaction {
        void handleContentNews(ContentNews contentNews);
    }
}
