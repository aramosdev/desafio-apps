package br.com.aramosdev.infoglobo.newslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import java.util.List;

import br.com.aramosdev.infoglobo.core.BaseActivity;
import br.com.aramosdev.infoglobo.core.BaseRecyclerAdapter;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class NewsAdapter extends BaseRecyclerAdapter {

    private final static int FADE_DURATION = 1000; // in milliseconds
    private View.OnClickListener mOnClickListener;


    public NewsAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    protected NewsItemView onCreateItemView(ViewGroup parent, int viewType) {
        NewsItemView view = new NewsItemView(mActivity);
        view.setOnClickListener(mOnClickListener);
        return view;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        super.onBindViewHolder(holder, position, payloads);
        setAnimation(holder.itemView, position);
    }


    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    private void setAnimation(View viewToAnimate, int position) {
        viewToAnimate.clearAnimation();
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        viewToAnimate.startAnimation(anim);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}