package com.example.c4q.scorboardboard.controller;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.c4q.scorboardboard.Objective;
import com.example.c4q.scorboardboard.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 3/7/18.
 */

public class ObjectiveAdapter extends Adapter<ObjectiveAdapter.ObjectiveHolder> {

    List<Objective>objectiveList;

    public ObjectiveAdapter(List<Objective>objectiveList){
        this.objectiveList = objectiveList;
    }

    @Override
    public ObjectiveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_views, parent,false);
        return new ObjectiveHolder(view);
    }

    @Override
    public void onBindViewHolder(ObjectiveHolder holder, int position) {
        holder.bind(objectiveList.get(position));
    }

    @Override
    public int getItemCount() {
        return objectiveList.size();
    }

    public void updateData(){
        notifyDataSetChanged();
    }

    protected class ObjectiveHolder extends RecyclerView.ViewHolder {
        TextView playerOneName, playerTwoName, objective;


        public ObjectiveHolder(View itemView) {
            super(itemView);
            playerOneName = itemView.findViewById(R.id.text_player_one);
            playerTwoName = itemView.findViewById(R.id.text_player_two);
            objective = itemView.findViewById(R.id.text_objective);

        }

        public void bind(Objective cObjective){
            playerOneName.setText(cObjective.getPlayerOne());
            playerTwoName.setText(cObjective.getPlayerTwo());
            objective.setText(cObjective.getObjective());
        }
    }
}
