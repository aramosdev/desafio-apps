package br.com.aramosdev.infoglobo.banner;

import java.util.List;

import br.com.aramosdev.infoglobo.model.news.Image;
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
    public void handleBanner(List<Image> images, String title) {
        if (TextUtils.isEmptyOrNull(images)
                || images.get(0) == null
                || TextUtils.isNullOrEmpty(images.get(0).getUrl())
                || TextUtils.isNullOrEmpty(title)) return;

        mView.showBannerHome(images.get(0).getUrl(), title);
    }

    @Override
    public void handleBanner(List<Image> images) {
        if (TextUtils.isEmptyOrNull(images)
                || images.get(0) == null
                || TextUtils.isNullOrEmpty(images.get(0).getUrl())
                || TextUtils.isNullOrEmpty(images.get(0).getLegend())) return;

        mView.showBannerDetail(images.get(0).getUrl(), images.get(0).getLegend());
    }
}
