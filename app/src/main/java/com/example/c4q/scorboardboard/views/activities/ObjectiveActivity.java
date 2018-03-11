package com.example.c4q.scorboardboard.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.c4q.scorboardboard.DataToActivity;
import com.example.c4q.scorboardboard.Objective;
import com.example.c4q.scorboardboard.R;
import com.example.c4q.scorboardboard.controller.ObjectiveAdapter;
import com.example.c4q.scorboardboard.views.fragments.NewObjective;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class ObjectiveActivity extends AppCompatActivity implements DataToActivity {

    //TODO local storage
    //TODO save forms in all orientations
    /**
     * decide whether youd like to use a database, or ashared pref
     */

    public static List<Objective> objectives;
    public static ObjectiveAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fragment);
        objectives = new ArrayList<>();
        adapter = new ObjectiveAdapter(objectives);

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
