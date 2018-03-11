package com.example.c4q.scorboardboard.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.scorboardboard.Objective;
import com.example.c4q.scorboardboard.R;
import com.example.c4q.scorboardboard.controller.ObjectiveAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.c4q.scorboardboard.views.activities.ObjectiveActivity.objectives;
import static com.example.c4q.scorboardboard.views.activities.ObjectiveActivity.adapter;

/**
 * Created by c4q on 3/11/18.
 */

public class ObjectiveList extends Fragment {

    private RecyclerView objectiveList;
//    private List<Objective> objectives;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

//        objectives = new ArrayList<>();
        adapter = new ObjectiveAdapter(objectives);
        objectiveList = view.findViewById(R.id.recycler_pbjectives);

        objectiveList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        objectiveList.setAdapter(adapter);

        return view;
    }
}
