package br.com.aramosdev.infoglobo.core;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import br.com.aramosdev.infoglobo.R;
import br.com.aramosdev.infoglobo.model.api.RestClient;


/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout mMainLayout;
    protected Toolbar mToolbar;
    protected RestClient mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApi = new RestClient(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base);
        mMainLayout = (FrameLayout) findViewById(R.id.main_layout);
        LayoutInflater.from(this).inflate(layoutResID, mMainLayout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();

                InputMethodManager imm
                        = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                View view = getCurrentFocus();
                if (view != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setActionBarTitle(String title) {
        if(getSupportActionBar() == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setVisibility(View.VISIBLE);
            setSupportActionBar(mToolbar);

        }
        findViewById(R.id.toolbar_image).setVisibility(View.GONE);
        TextView titleView = (TextView) findViewById(R.id.toolbar_title);
        titleView.setVisibility(View.VISIBLE);
        titleView.setText(title);
        setTitle(null);
    }

    protected void setReturnButton(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
