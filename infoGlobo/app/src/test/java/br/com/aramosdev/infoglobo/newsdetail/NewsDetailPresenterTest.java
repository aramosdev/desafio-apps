package br.com.aramosdev.infoglobo.newsdetail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.aramosdev.infoglobo.UnitTestUtil;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.util.DateUtils;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Alberto.Ramos on 11/09/17.
 */

public class NewsDetailPresenterTest {

    @Mock
    private NewsDetailContract.View mView;

    private NewsDetailContract.Interaction mPresenter;
    private ContentNews mResponse;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mPresenter = new NewsDetailPresenter(mView);
        mResponse = UnitTestUtil.getInstance().readFile(ContentNews.class, "content_news.json");
    }

    @Test
    public void testHandleContentNewsNull() throws Exception {
        mPresenter.handleContentNews(null);
        verify(mView, never()).showSectionText(anyString());
        verify(mView, never()).showTitle(anyString());
        verify(mView, never()).showSubtitle(anyString());
        verify(mView, never()).showByAuthor(anyString());
        verify(mView, never()).showPublished(anyString());
        verify(mView, never()).showBanner((ContentNews) any());
        verify(mView, never()).showText(anyString());
    }

    @Test
    public void testHandleContentNewsSectionNull() throws Exception {
        mResponse.setSection(null);
        mPresenter.handleContentNews(mResponse);
        verify(mView, never()).showSectionText(anyString());
        verify(mView).showTitle(eq(mResponse.getTitle()));
        verify(mView).showSubtitle(eq(mResponse.getSubtitle()));
        verify(mView).showByAuthor(eq(mResponse.getAuthors()[0]));
        verify(mView).showPublished(eq(DateUtils.formatDateTimeTimezone(mResponse.getPublished())));
        verify(mView).showBanner(eq(mResponse));
        verify(mView).showText(eq(mResponse.getText()));
    }

    @Test
    public void testHandleContentNewsAuthorNull() throws Exception {
        mResponse.setAuthors(null);
        mPresenter.handleContentNews(mResponse);
        verify(mView).showSectionText(eq(mResponse.getSection().getName()));
        verify(mView).showTitle(eq(mResponse.getTitle()));
        verify(mView).showSubtitle(eq(mResponse.getSubtitle()));
        verify(mView, never()).showByAuthor(anyString());
        verify(mView).showPublished(eq(DateUtils.formatDateTimeTimezone(mResponse.getPublished())));
        verify(mView).showBanner(eq(mResponse));
        verify(mView).showText(eq(mResponse.getText()));
    }

    @Test
    public void testHandleContentNewsSuccess() throws Exception {
        mPresenter.handleContentNews(mResponse);
        verify(mView).showSectionText(eq(mResponse.getSection().getName()));
        verify(mView).showTitle(eq(mResponse.getTitle()));
        verify(mView).showSubtitle(eq(mResponse.getSubtitle()));
        verify(mView).showByAuthor(eq(mResponse.getAuthors()[0]));
        verify(mView).showPublished(eq(DateUtils.formatDateTimeTimezone(mResponse.getPublished())));
        verify(mView).showBanner(eq(mResponse));
        verify(mView).showText(eq(mResponse.getText()));
    }
}
