package br.com.aramosdev.infoglobo.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.aramosdev.infoglobo.R;
import br.com.aramosdev.infoglobo.banner.BannerView;
import br.com.aramosdev.infoglobo.core.BaseActivity;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.newsdetail.NewsDetailActivity;
import br.com.aramosdev.infoglobo.newslist.NewsAdapter;
import br.com.aramosdev.infoglobo.newslist.NewsItemView;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mListNews;
    private BannerView mBanner;
    private HomeContract.Interaction mPresenter;
    protected NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mListNews = (RecyclerView) findViewById(R.id.list_news);
        mListNews.setHasFixedSize(true);
        mListNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mBanner = (BannerView) findViewById(R.id.view_banner);
        mPresenter = new HomePresenter(mApi, this);
        mAdapter = new NewsAdapter(this);

        mPresenter.getNews();

        mListNews.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadHome();
            }
        });
    }

    @Override
    public void fillBanner(final ContentNews contentNews) {
        mBanner.bind(BannerView.BANNER_HOME, contentNews).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewsDetail(contentNews);
            }
        });
    }

    @Override
    public void fillNewsList(final List<ContentNews> contentNewses) {
        mAdapter.clearItems();
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewsDetail(((NewsItemView)view).getCurrentContentNews());
            }
        });
        mAdapter.setItems((ArrayList) contentNewses);
    }

    @Override
    public void tryAgain() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.DialogTheme);
        builder.setTitle(R.string.ops_title);
        builder.setCancelable(false);
        builder.setMessage(R.string.error_message);

        builder.setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mPresenter.getNews();
            }
        });
        builder.setNegativeButton(R.string.cancel, null);

        builder.show();
    }

    @Override
    public void showLoading() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void startNewsDetail(ContentNews contentNews) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.CONTENT_NEWS_EXTRA, contentNews);
        startActivity(intent);
    }

    private void loadHome() {
        mBanner.setVisibility(View.GONE);
        mPresenter.getNews();
    }
}
