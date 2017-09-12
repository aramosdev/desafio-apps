package br.com.aramosdev.infoglobo.newslist;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import br.com.aramosdev.infoglobo.base.UnitTestUtil;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.model.news.Image;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Alberto.Ramos on 12/09/17.
 */

public class NewsPresenterTest {

    @Mock
    private NewsContract.View mView;

    private NewsContract.Interaction mPresenter;
    private ContentNews mResponse;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mPresenter = new NewsPresenter(mView);
        mResponse = UnitTestUtil.getInstance().readFile(ContentNews.class, "content_news.json");
    }

    @Test
    public void testHandleNewsContentNewsNull() throws Exception {
        mPresenter.handleNews(null);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsImagesNull() throws Exception {
        mResponse.setImages(null);
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsImagesEmpty() throws Exception {
        mResponse.setImages(new ArrayList<Image>(0));
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsImageNull() throws Exception {
        mResponse.getImages().set(0, null);
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsSectionNull() throws Exception {
        mResponse.setSection(null);
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsImageUrlNull() throws Exception {
        mResponse.getImages().get(0).setUrl(null);
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsImageUrlEmpty() throws Exception {
        mResponse.getImages().get(0).setUrl("");
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsTitleNull() throws Exception {
        mResponse.setTitle(null);
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsTitleEmpty() throws Exception {
        mResponse.setTitle("");
        mPresenter.handleNews(mResponse);
        verify(mView, never()).showContentNews(anyString(), anyString(), anyString());
    }

    @Test
    public void testHandleNewsSuccess() throws Exception {
        mPresenter.handleNews(mResponse);
        verify(mView).showContentNews(eq(mResponse.getImages().get(0).getUrl()),
                eq(mResponse.getTitle()), eq(mResponse.getSection().getName()));
    }
}
