package com.example.c4q.scorboardboard.controller;

import android.view.View;
import com.example.c4q.scorboardboard.R;
import com.example.c4q.scorboardboard.model.Objective;

/**
 * Created by c4q on 3/16/18.
 */

public class PointIncrementListener implements View.OnClickListener {
    Objective objective;
    ObjectiveAdapter adapter;

    public PointIncrementListener(Objective objective,ObjectiveAdapter adapter){
        this.objective = objective;
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_player_one:
                objective.getPlayerOne().addPoint();
                adapter.updateData();
                break;

            case R.id.add_player_two:
                objective.getPlayerTwo().addPoint();
                adapter.updateData();
                break;

            case R.id.subtract_player_one:
                objective.getPlayerOne().subtractPoint();
                adapter.updateData();
                break;

            case R.id.subtract_player_two:
                objective.getPlayerTwo().subtractPoint();
                adapter.updateData();
                break;
        }
    }

}
