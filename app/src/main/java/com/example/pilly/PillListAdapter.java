package com.example.pilly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class PillListAdapter extends RecyclerView.Adapter<PillListAdapter.ViewHolder> {
    private List<Pill> pills;

    public PillListAdapter(List<Pill> pillList) {
        pills = pillList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pill_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getPillNameTextView().setText(pills.get(position).getName());
        holder.getPillDoseTextView().setText(pills.get(position).getDose());
        holder.getPillTimeTextView().setText(pills.get(position).getTimeToBeTaken());
    }

    @Override
    public int getItemCount() {
        return pills.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView pillNameTextView;
        private final TextView pillTimeTextView;
        private final TextView pillDoseTextView;
        public ViewHolder(View view) {
            super(view);
            pillNameTextView = view.findViewById(R.id.pill_name);
            pillTimeTextView = view.findViewById(R.id.timeToTakePill_TextView);
            pillDoseTextView = view.findViewById(R.id.dosage_textview);
        }
        public TextView getPillNameTextView() {
            return pillNameTextView;
        }

        public TextView getPillDoseTextView() {
            return pillDoseTextView;
        }

        public TextView getPillTimeTextView() {
            return pillTimeTextView;
        }
    }
}
