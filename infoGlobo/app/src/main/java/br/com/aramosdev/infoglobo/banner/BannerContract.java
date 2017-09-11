package br.com.aramosdev.infoglobo.banner;

import br.com.aramosdev.infoglobo.model.news.ContentNews;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public interface BannerContract {
    interface View {
        void showBannerHome(String url, String title);
        void showBannerDetail(String url, String description);
    }

    interface Interaction {
        void handleBanner(int featureType, ContentNews contentNews);
    }
}
