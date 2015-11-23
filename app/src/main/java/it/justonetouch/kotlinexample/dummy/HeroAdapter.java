package it.justonetouch.kotlinexample.dummy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import it.justonetouch.kotlinexample.R;

/**
 * {@link RecyclerView.Adapter} that can display a {@link HeroItem} and makes a call to the
 * specified {@link HeroOnClickListener}.
 */
public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private final List<HeroItem> mValues;
    private final HeroOnClickListener mListener;

    public HeroAdapter(List<HeroItem> items, HeroOnClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = mValues.get(position);
        holder.idView.setText(mValues.get(position).id);
        holder.contentView.setText(mValues.get(position).content);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickHero(holder.item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView idView;
        public final TextView contentView;
        public HeroItem item;

        public ViewHolder(View view) {
            super(view);
            idView = (TextView) view.findViewById(R.id.id);
            contentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
