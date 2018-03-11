package com.example.c4q.scorboardboard.views.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.c4q.scorboardboard.Objective;
import com.example.c4q.scorboardboard.R;
import com.example.c4q.scorboardboard.DataToActivity;

/**
 * Created by c4q on 3/7/18.
 */

public class NewObjective extends Fragment {

    private EditText fieldPlayerOne, fieldPlayerTwo, fieldGoal, fieldObjective;
    private Button buttonSubmit;
    private Context context;
    private DataToActivity passData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_objective, container , false);

        context = getContext();
        fieldObjective = view.findViewById(R.id.field_objective);
        fieldGoal = view.findViewById(R.id.field_goal);
        fieldPlayerOne = view.findViewById(R.id.field_first_player);
        fieldPlayerTwo = view.findViewById(R.id.field_second_player);
        buttonSubmit = view.findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objective objective = new Objective();
                objective.setObjective(fieldObjective.getText().toString())
                        .setPlayerOne(fieldPlayerOne.getText().toString())
                        .setPlayerTwo(fieldPlayerTwo.getText().toString())
                        .setLimit(Integer.parseInt(fieldGoal.getText().toString()));

                passData.grabData(objective);
                getFragmentManager().beginTransaction().remove(NewObjective.this).commit();
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        passData = (DataToActivity) context;
    }
}
