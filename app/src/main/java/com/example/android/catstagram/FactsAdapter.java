package com.example.android.catstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FactsAdapter extends RecyclerView.Adapter<FactsViewHolder> {
    Context context;
    private List<Facts> factsArrayList;

    public FactsAdapter(Context context, List<Facts> factsArrayList) {
        this.context = context;
        this.factsArrayList = factsArrayList;
    }

    public void setFactsArrayList(List<Facts> factsArrayList) {
        this.factsArrayList = factsArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_facts, viewGroup, false);
        return new FactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FactsViewHolder factsViewHolder, int i) {
        factsViewHolder.factTextView.setText("Fact number " + (i + 1) + ": \n" + factsArrayList.get(i).getText());

    }

    @Override
    public int getItemCount() {
        return factsArrayList.size();
    }
}
