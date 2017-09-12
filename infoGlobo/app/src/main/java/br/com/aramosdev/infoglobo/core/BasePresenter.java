package br.com.aramosdev.infoglobo.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import br.com.aramosdev.infoglobo.model.api.ApiSubscriber;
import br.com.aramosdev.infoglobo.model.api.RestClient;
import io.reactivex.Flowable;

public abstract class BasePresenter<T, V extends BaseContract.BaseView>
        implements BaseContract.BaseInteraction<T> {

    protected RestClient mApi;
    private ApiSubscriber mRequest;
    protected V mView;

    public BasePresenter(RestClient api, V view) {
        mApi = api;
        mView = view;
    }

    public void execute(Flowable<T> observable) {
        mRequest = mApi.buildRequest(observable, this);
        mRequest.execute();
    }

    public void execute(Flowable<T> observable, BaseContract.BaseInteraction<T> interaction) {
        mRequest = mApi.buildRequest(observable, interaction);
        mRequest.execute();
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public Type genericType(){
        ParameterizedType parameterizedType = (ParameterizedType) getClass()
                .getGenericSuperclass();

        return parameterizedType.getActualTypeArguments()[0];
    }

}
