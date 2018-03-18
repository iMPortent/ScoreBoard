package com.example.c4q.scorboardboard.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.c4q.scorboardboard.model.Objective;
import com.example.c4q.scorboardboard.R;

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
        TextView playerOneName, playerOneScore, playerTwoName, playerTwoScore, objective;
        Button playerOneAdd, playerOneSubtract, playerTwoAdd, playerTwoSubtract;
        Objective cObjective;

        public ObjectiveHolder(View itemView) {
            super(itemView);
            playerOneName = itemView.findViewById(R.id.text_player_one);
            playerTwoName = itemView.findViewById(R.id.text_player_two);
            objective = itemView.findViewById(R.id.text_objective);

            playerOneScore = itemView.findViewById(R.id.text_player_one_score);
            playerTwoScore = itemView.findViewById(R.id.text_player_two_score);

            playerOneAdd = itemView.findViewById(R.id.add_player_one);
            playerOneSubtract = itemView.findViewById(R.id.subtract_player_one);

            playerTwoAdd = itemView.findViewById(R.id.add_player_two);
            playerTwoSubtract = itemView.findViewById(R.id.subtract_player_two);

        }

        public void bind(Objective cObjective){
            this.cObjective = cObjective;
            playerOneName.setText(cObjective.getPlayerOne().getName());
            playerTwoName.setText(cObjective.getPlayerTwo().getName());
            objective.setText(cObjective.getObjective());

            playerOneScore.setText(String.valueOf(cObjective.getPlayerOne().getTotalPoints()));
            playerTwoScore.setText(String.valueOf(cObjective.getPlayerTwo().getTotalPoints()));
            playerOneAdd.setOnClickListener(new PointIncrementListener(cObjective,ObjectiveAdapter.this));
            playerOneSubtract.setOnClickListener(new PointIncrementListener(cObjective, ObjectiveAdapter.this));
            playerTwoAdd.setOnClickListener(new PointIncrementListener(cObjective, ObjectiveAdapter.this));
            playerTwoSubtract.setOnClickListener(new PointIncrementListener(cObjective, ObjectiveAdapter.this));
        }
    }
}
