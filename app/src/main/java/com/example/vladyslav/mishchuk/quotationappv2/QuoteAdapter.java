package com.example.vladyslav.mishchuk.quotationappv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.VH> {

    public interface OnItemClickListener {
        void onItemClick(Quote quote);
    }

    private final List<Quote> data;
    private final OnItemClickListener listener;

    public QuoteAdapter(List<Quote> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    public static class VH extends RecyclerView.ViewHolder {
        public final TextView tvQuote;
        public final TextView tvAuthor;

        public VH(@NonNull View itemView) {
            super(itemView);
            tvQuote = itemView.findViewById(R.id.tvQuote);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }

        public void bind(Quote quote, OnItemClickListener listener) {
            tvQuote.setText(quote.text);
            tvAuthor.setText(quote.author);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(quote);
                }
            });
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quote, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Quote q = data.get(position);
        holder.bind(q, listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
