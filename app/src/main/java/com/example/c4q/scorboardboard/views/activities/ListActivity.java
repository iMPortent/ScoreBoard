package com.example.c4q.scorboardboard.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.c4q.scorboardboard.Objective;
import com.example.c4q.scorboardboard.R;
import com.example.c4q.scorboardboard.controller.ObjectiveAdapter;
import com.example.c4q.scorboardboard.views.fragments.NewObjective;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class ListActivity extends AppCompatActivity implements DataToActivity {

    private RecyclerView objectiveList;
    private List<Objective> objectives;
    private ObjectiveAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        objectives = new ArrayList<>();
        adapter = new ObjectiveAdapter(objectives);
        objectiveList = findViewById(R.id.recycler_pbjectives);

        objectiveList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        objectiveList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.option_new){
          getFragmentManager().beginTransaction().replace(R.id.frame_holder, new NewObjective()).commit();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void grabData(Objective objective) {
        objectives.add(objective);
        adapter.updateData();
    }
}
