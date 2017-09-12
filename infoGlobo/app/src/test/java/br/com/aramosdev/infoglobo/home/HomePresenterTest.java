package br.com.aramosdev.infoglobo.home;

import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.aramosdev.infoglobo.base.UnitTestUtil;
import br.com.aramosdev.infoglobo.base.BaseUnitTest;
import br.com.aramosdev.infoglobo.core.BaseContract;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.model.news.News;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class HomePresenterTest extends BaseUnitTest<List<News>> {

    @Mock
    private HomeContract.View mView;

    private HomeContract.Interaction mPresenter;
    private ArrayList<News> mResponse;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void testGetNewsResponseEmpty() throws Exception {
        setupMockedResponse(new ArrayList<News>(0));
        mPresenter.getNews();

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).tryAgain();
        verify(mView, never()).fillNewsList((List<ContentNews>) any());
    }

    @Test
    public void testGetNewsResponseNull() throws Exception {
        setupMockedResponse(null);
        mPresenter.getNews();

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).tryAgain();
        verify(mView, never()).fillNewsList((List<ContentNews>) any());
    }

    @Test
    public void testGetNewsContentNewsesNull() throws Exception {
        ArrayList<News> response = new ArrayList<>();
        News news = new News();
        news.setContentNewses(null);
        response.add(news);

        setupMockedResponse(response);
        mPresenter.getNews();

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).tryAgain();
        verify(mView, never()).fillNewsList((List<ContentNews>) any());
    }

    @Test
    public void testGetNewsContentNewsesEmpty() throws Exception {
        ArrayList<News> response = new ArrayList<>();
        News news = new News();
        news.setContentNewses(new ArrayList<ContentNews>());
        response.add(news);

        setupMockedResponse(response);
        mPresenter.getNews();

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).tryAgain();
        verify(mView, never()).fillNewsList((List<ContentNews>) any());
    }

    @Test
    public void testGetNewsSuccess() throws Exception {
        mPresenter.getNews();

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).fillNewsList(eq(mResponse.get(0).getContentNewses()));
        verify(mView, never()).tryAgain();
    }

    @Override
    protected BaseContract.BaseInteraction<List<News>> getPresenter() {
        mPresenter = new HomePresenter(mApi, mView);
        return mPresenter;
    }

    @Override
    protected List<News> getFullResponse() {
        Type type = getPresenter().genericType();
        mResponse = UnitTestUtil.getInstance().readFile(type, "news.json");
        return mResponse;
    }
}
