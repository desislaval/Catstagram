package com.example.android.catstagram;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FactsViewHolder extends RecyclerView.ViewHolder {
    TextView factTextView;

    public FactsViewHolder(@NonNull View itemView) {
        super(itemView);
        factTextView = itemView.findViewById(R.id.facts_txt);

    }
}
