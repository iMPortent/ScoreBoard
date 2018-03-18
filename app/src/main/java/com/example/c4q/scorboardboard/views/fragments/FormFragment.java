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
import com.example.c4q.scorboardboard.model.Objective;
import com.example.c4q.scorboardboard.R;
import com.example.c4q.scorboardboard.controller.MyObjectiveListener;

/**
 * Created by c4q on 3/7/18.
 */

public class FormFragment extends Fragment {

    private EditText fieldPlayerOne, fieldPlayerTwo, fieldGoal, fieldObjective;
    private Button buttonSubmit;
    private MyObjectiveListener passData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_objective, container , false);

        fieldObjective = view.findViewById(R.id.field_objective);
        fieldGoal = view.findViewById(R.id.field_goal);
        fieldPlayerOne = view.findViewById(R.id.field_first_player);
        fieldPlayerTwo = view.findViewById(R.id.field_second_player);
        buttonSubmit = view.findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objective objective = new Objective(
                        fieldObjective.getText().toString(),
                        fieldPlayerOne.getText().toString(),
                        fieldPlayerTwo.getText().toString(),
                        Integer.parseInt(fieldGoal.getText().toString()));

                passData.grabData(objective);
                getFragmentManager().beginTransaction().replace(R.id.objective_fragment_holder, new ListFragment()).commit();
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        passData = (MyObjectiveListener) context;
    }
}
