package br.com.aramosdev.infoglobo.banner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import br.com.aramosdev.infoglobo.UnitTestUtil;
import br.com.aramosdev.infoglobo.model.news.ContentNews;
import br.com.aramosdev.infoglobo.model.news.Image;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Alberto.Ramos on 11/09/17.
 */

public class BannerPresenterTest {

    @Mock
    private BannerContract.View mView;

    private BannerContract.Interaction mPresenter;
    private ContentNews mResponse;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mPresenter = new BannerPresenter(mView);
        mResponse = UnitTestUtil.getInstance().readFile(ContentNews.class, "content_news.json");
    }

    @Test
    public void testHandleBannerHomeImagesNull() throws Exception {
        mPresenter.handleBannerHome(null, null);
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeImagesEmpty() throws Exception {
        mPresenter.handleBannerHome(new ArrayList<Image>(0), null);
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeImageNull() throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(null);
        mPresenter.handleBannerHome(images, null);
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeImageUrlNull() throws Exception {
        mResponse.getImages().get(0).setUrl(null);
        mPresenter.handleBannerHome(mResponse.getImages(), null);
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeImageUrlEmpty() throws Exception {
        mResponse.getImages().get(0).setUrl("");
        mPresenter.handleBannerHome(mResponse.getImages(), null);
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeTitleNull() throws Exception {
        mPresenter.handleBannerHome(mResponse.getImages(), null);
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeTitleEmpty() throws Exception {
        mPresenter.handleBannerHome(mResponse.getImages(), "");
        verify(mView, never()).showBannerHome(anyString(), anyString());
    }

    @Test
    public void testHandleBannerHomeSuccess() throws Exception {
        mPresenter.handleBannerHome(mResponse.getImages(), mResponse.getTitle());
        verify(mView).showBannerHome(eq(mResponse.getImages().get(0).getUrl()), eq(mResponse.getTitle()));
    }

    @Test
    public void testHandleBannerDetailImagesNull() throws Exception {
        mPresenter.handleBannerDetail(null);
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailImagesEmpty() throws Exception {
        mPresenter.handleBannerDetail(new ArrayList<Image>(0));
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailImageNull() throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(null);
        mPresenter.handleBannerDetail(images);
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailImageUrlNull() throws Exception {
        mResponse.getImages().get(0).setUrl(null);
        mPresenter.handleBannerDetail(mResponse.getImages());
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailImageUrlEmpty() throws Exception {
        mResponse.getImages().get(0).setUrl("");
        mPresenter.handleBannerDetail(mResponse.getImages());
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailLegendNull() throws Exception {
        mResponse.getImages().get(0).setLegend(null);
        mPresenter.handleBannerDetail(mResponse.getImages());
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailLegendEmpty() throws Exception {
        mResponse.getImages().get(0).setLegend("");
        mPresenter.handleBannerDetail(mResponse.getImages());
        verify(mView, never()).showBannerDetail(anyString(), anyString());
    }

    @Test
    public void testHandleBannerDetailSuccess() throws Exception {
        mPresenter.handleBannerDetail(mResponse.getImages());
        verify(mView).showBannerDetail(eq(mResponse.getImages().get(0).getUrl()),
                eq(mResponse.getImages().get(0).getLegend()));
    }
}
