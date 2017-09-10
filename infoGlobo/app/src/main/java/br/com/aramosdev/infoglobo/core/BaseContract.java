package br.com.aramosdev.infoglobo.core;

import android.content.Context;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public interface BaseContract {

    interface BaseView {
        void showLoading();
        void hideLoading();
        Context getContext();
    }

    interface BaseInteraction<T> {
        void handleResponse(T response);
        void handleResponseError(T response);
        BaseView getView();
    }

}
