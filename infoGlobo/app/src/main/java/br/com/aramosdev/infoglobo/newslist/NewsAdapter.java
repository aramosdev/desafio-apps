package br.com.aramosdev.infoglobo.newslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import java.util.List;

import br.com.aramosdev.infoglobo.banner.BannerView;
import br.com.aramosdev.infoglobo.core.BaseActivity;
import br.com.aramosdev.infoglobo.core.BaseRecyclerAdapter;
import br.com.aramosdev.infoglobo.model.news.ContentNews;

/**
 * Created by Alberto.Ramos on 10/09/17.
 */

public class NewsAdapter extends BaseRecyclerAdapter {

    private static final int TYPE_BANNER_VIEW = 1212;
    private static final int TYPE_DEFAULT_VIEW = 1512;

    private final static int FADE_DURATION = 1000; // in milliseconds
    private OnItemClick mOnItemClick;


    public NewsAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    protected View onCreateItemView(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_BANNER_VIEW:
                view = new BannerView(mActivity).home((ContentNews) mItems.get(0));
                break;
            default:
                view = new NewsItemView(mActivity);
        }
        return view;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position, List payloads) {
        super.onBindViewHolder(holder, position, payloads);

        switch (holder.getItemViewType()) {
            case TYPE_BANNER_VIEW:
                ((BannerView)holder.itemView).home((ContentNews) mItems.get(position));
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClick != null) mOnItemClick.onItemClicked((ContentNews) mItems.get(position));
            }
        });

        setAnimation(holder.itemView);
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return TYPE_BANNER_VIEW;
        else return TYPE_DEFAULT_VIEW;
    }

    private void setAnimation(View viewToAnimate) {
        viewToAnimate.clearAnimation();
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        viewToAnimate.startAnimation(anim);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.mOnItemClick = onItemClick;
    }

    public interface OnItemClick {
        void onItemClicked(ContentNews contentNews);
    }
}