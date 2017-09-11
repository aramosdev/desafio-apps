package br.com.aramosdev.infoglobo.banner;

import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.util.TextUtils;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class BannerPresenter implements BannerContract.Interaction {

    private BannerContract.View mView;

    public BannerPresenter(BannerContract.View view) {
        mView = view;
    }

    @Override
    public void handleBanner(int bannerType, ContentNews contentNews) {
        if (contentNews == null) return;

        switch (bannerType) {
            case BannerView.BANNER_HOME:
                if (!TextUtils.isEmptyOrNull(contentNews.getImages())
                        && !TextUtils.isNullOrEmpty(contentNews.getTitle()) ) {
                    mView.showBannerHome(contentNews.getImages().get(0).getUrl(), contentNews.getTitle());
                }
                break;
            case BannerView.BANNER_DETAIL:
                if (!TextUtils.isEmptyOrNull(contentNews.getImages())
                        && !TextUtils.isNullOrEmpty(contentNews.getImages().get(0).getLegend()) ) {
                    mView.showBannerDetail(contentNews.getImages().get(0).getUrl(),
                            contentNews.getImages().get(0).getLegend());
                }
                break;
        }
    }
}
