package br.com.aramosdev.infoglobo.newslist;

import android.content.Context;
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

public class NewsItemView extends LinearLayout implements ViewWrapper.Binder<ContentNews>,
        NewsContract.View {

    private ImageView mImage;
    private TextView mEditoria;
    private TextView mTitle;
    private View mLine;
    private NewsContract.Interaction mPresenter;
    private ContentNews mCurrentContentNews;

    public NewsItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_news_item, this, true);

        mImage = (ImageView) findViewById(R.id.news_image);
        mEditoria = (TextView) findViewById(R.id.news_editoria);
        mTitle = (TextView) findViewById(R.id.news_title);
        mLine = findViewById(R.id.line_news);

        mPresenter = new NewsPresenter(this);
    }

    @Override
    public void bind(ContentNews data, int position) {
        mCurrentContentNews = data;
        mPresenter.handleNews(data);
    }

    @Override
    public void showContentNews(String url, String title, String type) {
        ImageUtil.loadImageInto(url, mImage, getContext());
        mEditoria.setText(type);
        mTitle.setText(title);

        mImage.setVisibility(VISIBLE);
        mEditoria.setVisibility(VISIBLE);
        mTitle.setVisibility(VISIBLE);
        mLine.setVisibility(VISIBLE);
    }

    public ContentNews getCurrentContentNews() {
        return mCurrentContentNews;
    }
}
