package br.com.aramosdev.infoglobo.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public abstract class BaseRecyclerAdapter<T, V extends View & ViewWrapper.Binder<T>>
        extends RecyclerView.Adapter<ViewWrapper<T, V>> {

    protected ArrayList<T> mItems = new ArrayList<>();
    protected BaseActivity mActivity;

    public BaseRecyclerAdapter(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void setItems(ArrayList<T> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }

    public ArrayList<T> getItems() {
        return mItems;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public final ViewWrapper<T, V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<>(onCreateItemView(parent, viewType));
    }

    @Override
    public void onBindViewHolder(ViewWrapper<T, V> viewHolder, int position) {
        viewHolder.getView().bind(mItems.get(position), position);
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    public void clearItems() {
        mItems = new ArrayList<>();
        notifyDataSetChanged();
    }
}
