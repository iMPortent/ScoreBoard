package com.example.c4q.scorboardboard.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.c4q.scorboardboard.model.Objective;
import com.example.c4q.scorboardboard.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by c4q on 3/13/18.
 */

public class TableFragment extends Fragment {
    TableLayout tableRecords;
    TableRow tableRow;

    //TODO put info in a database and pull it out into the table instead of creatng it here

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_fragment, container);

        tableRecords = view.findViewById(R.id.table_record);
        tableRow = (TableRow)LayoutInflater.from(view.getContext()).inflate(R.layout.table_rows, null);
        return view;
    }

    public void createRow(View view, Objective objective){
        tableRow = (TableRow)LayoutInflater.from(view.getContext()).inflate(R.layout.table_rows, null);
        ((TextView)tableRow.findViewById(R.id.record_player)).setText(objective.getPlayerOne().getName());
        ((TextView)tableRow.findViewById(R.id.record_points)).setText(objective.getPlayerOne().getTotalPoints());
        ((TextView)tableRow.findViewById(R.id.record_time_stamp)).setText(giveCurrentDate());
        ((TextView)tableRow.findViewById(R.id.record_description)).setText(objective.getObjective());

        tableRecords.addView(tableRow);
    }

    public String giveCurrentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        return sdf.format(cal.getTime());
    }
}
