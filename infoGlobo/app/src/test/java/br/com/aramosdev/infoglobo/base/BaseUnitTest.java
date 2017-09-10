package br.com.aramosdev.infoglobo.base;

import android.content.Context;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Subscriber;

import br.com.aramosdev.infoglobo.core.BaseContract;
import br.com.aramosdev.infoglobo.model.api.ApiSubscriber;
import br.com.aramosdev.infoglobo.model.api.RestClient;
import br.com.aramosdev.infoglobo.model.api.Services;
import io.reactivex.Flowable;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public abstract class BaseUnitTest<T> {

    @Mock
    ApiSubscriber mMockedSubscriber;

    @Mock
    public RestClient mApi;

    @Mock
    protected Services mServices;

    @Mock
    protected Context mContext;

    protected abstract BaseContract.BaseInteraction<T> getPresenter();

    protected abstract T getFullResponse();

    public void setup(){
        MockitoAnnotations.initMocks(this);

        doReturn(mServices).when(mApi).getServices();
        setupMockedResponse(getFullResponse());
    }

    public void setupContextMocks(BaseContract.BaseView view) {
        doReturn(mContext).when(view).getContext();
    }

    /**
     * Intercept the request and return the "response" object
     * @param response Response to return on request
     */
    protected void setupMockedResponse(T response) {
        Flowable<T> mockedFlowable;
        if (response == null) {
            mockedFlowable = new Flowable<T>() {
                @Override
                protected void subscribeActual(Subscriber<? super T> s) {
                    s.onNext(null);
                }
            };
        } else {
            mockedFlowable = Flowable.just(response);
        }

        mMockedSubscriber = new MockedSubscriber(mockedFlowable, getPresenter());

        doReturn(mMockedSubscriber).when(mApi).buildRequest((Flowable) any(), (BaseContract.BaseInteraction) any());
    }

}