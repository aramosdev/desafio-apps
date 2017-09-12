package br.com.aramosdev.infoglobo.banner;

import java.util.List;

import br.com.aramosdev.infoglobo.model.news.Image;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public interface BannerContract {
    interface View {
        void showBannerHome(String url, String title);
        void showBannerDetail(String url, String description);
    }

    interface Interaction {
        void handleBannerHome(List<Image> images, String title);
        void handleBannerDetail(List<Image> images);
    }
}
