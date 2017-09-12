package br.com.aramosdev.infoglobo.banner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.aramosdev.infoglobo.R;
import br.com.aramosdev.infoglobo.core.ViewWrapper;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.util.ImageUtil;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class BannerView extends LinearLayout implements BannerContract.View,
        ViewWrapper.Binder<ContentNews> {

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

    @Override
    public void bind(ContentNews data, int position) {}

    public BannerView home(ContentNews data) {
        mPresenter.handleBannerHome(data.getImages(), data.getTitle());
        return this;
    }

    public BannerView detail(ContentNews data) {
        mPresenter.handleBannerDetail(data.getImages());
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
