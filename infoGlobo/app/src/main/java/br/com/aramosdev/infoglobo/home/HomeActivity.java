package br.com.aramosdev.infoglobo.home;

import android.content.Context;
import android.os.Bundle;

import br.com.aramosdev.infoglobo.R;
import br.com.aramosdev.infoglobo.core.BaseActivity;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private HomeContract.Interaction mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        mPresenter = new HomePresenter(mApi, this);
        mPresenter.getNews();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
