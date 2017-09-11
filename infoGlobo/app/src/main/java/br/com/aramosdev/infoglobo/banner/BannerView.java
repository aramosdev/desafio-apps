package br.com.aramosdev.infoglobo.banner;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.aramosdev.infoglobo.R;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.util.ImageUtil;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class BannerView extends LinearLayout implements BannerContract.View {

    @IntDef(value = {BANNER_HOME, BANNER_DETAIL})
    public @interface BannerType {}
    public static final int BANNER_HOME = 1;
    public static final int BANNER_DETAIL = 2;

    private ContentNews mCurrentContentNews;
    private ImageView mImage;
    private TextView mTitle;
    private TextView mDescription;
    private BannerContract.Interaction mPresenter;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_banner, this, true);

        mImage = (ImageView) findViewById(R.id.image_banner);
        mTitle = (TextView) findViewById(R.id.title_banner);
        mDescription = (TextView) findViewById(R.id.description_banner);
        mPresenter = new BannerPresenter(this);
    }

    public BannerView bind(@BannerType int bannerType, ContentNews contentNews) {
        mCurrentContentNews = contentNews;
        mPresenter.handleBanner(bannerType, contentNews);
        return this;
    }

    @Override
    public void showBannerHome(String url, String title) {
        ImageUtil.loadImageInto(url, mImage, getContext());
        mTitle.setText(title);
        mTitle.setVisibility(VISIBLE);
        setVisibility(View.VISIBLE);
    }

    @Override
    public void showBannerDetail(String url, String description) {
        ImageUtil.loadImageInto(url, mImage, getContext());
        mDescription.setText(description);
        mDescription.setVisibility(VISIBLE);
    }
}
