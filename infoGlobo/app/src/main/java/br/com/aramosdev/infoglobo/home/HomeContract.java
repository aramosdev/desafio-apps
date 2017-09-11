package br.com.aramosdev.infoglobo.home;

import java.util.List;

import br.com.aramosdev.infoglobo.core.BaseContract;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.model.news.News;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public interface HomeContract {
    interface View extends BaseContract.BaseView{
        void tryAgain();
        void fillBanner(ContentNews contentNews);
        void fillNewsList(List<ContentNews> contentNewses);
    }

    interface Interaction extends BaseContract.BaseInteraction<List<News>> {
        void getNews();
    }
}
