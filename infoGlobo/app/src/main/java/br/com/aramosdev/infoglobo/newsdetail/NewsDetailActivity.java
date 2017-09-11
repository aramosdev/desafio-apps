package br.com.aramosdev.infoglobo.newsdetail;

import android.os.Bundle;
import android.widget.TextView;

import br.com.aramosdev.infoglobo.R;
import br.com.aramosdev.infoglobo.banner.BannerView;
import br.com.aramosdev.infoglobo.core.BaseActivity;
import br.com.aramosdev.infoglobo.model.news.ContentNews;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class NewsDetailActivity extends BaseActivity implements NewsDetailContract.View{

    public static final String CONTENT_NEWS_EXTRA = "contentNews";

    private TextView mTitle;
    private TextView mSubtitle;
    private TextView mByAuthor;
    private TextView mDate;
    private TextView mText;
    private BannerView mBannerView;
    private ContentNews mContentNews;
    private NewsDetailContract.Interaction mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        init();
    }

    private void init() {
        if(getIntent().getExtras() != null) {
            mContentNews = (ContentNews) getIntent().getExtras().getSerializable(CONTENT_NEWS_EXTRA);
            mTitle = (TextView) findViewById(R.id.news_title);
            mSubtitle = (TextView) findViewById(R.id.news_subtitle);
            mByAuthor = (TextView) findViewById(R.id.news_author);
            mDate = (TextView) findViewById(R.id.news_date);
            mText = (TextView) findViewById(R.id.news_text);
            mBannerView = (BannerView) findViewById(R.id.banner_view);
            mPresenter = new NewsDetailPresenter(this);

            mPresenter.handleContentNews(mContentNews);
            setReturnButton();
        }
    }

    @Override
    public void showSectionText(String sectionName) {
        setActionBarTitle(sectionName);
    }

    @Override
    public void showTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void showSubtitle(String subtitle) {
        mSubtitle.setText(subtitle);
    }

    @Override
    public void showByAuthor(String author) {
        mByAuthor.setText(author);
    }

    @Override
    public void showPublished(String dateTimeTimezone) {
        mDate.setText(dateTimeTimezone);
    }

    @Override
    public void showBanner(ContentNews contentNews) {
        mBannerView.detail(contentNews);
    }

    @Override
    public void showText(String text) {
        mText.setText(text);
    }
}
