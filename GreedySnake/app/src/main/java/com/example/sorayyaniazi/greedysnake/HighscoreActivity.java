package com.example.sorayyaniazi.greedysnake;

import java.util.List;

import Model.Score;
import Model.Score.HighScoreEntry;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HighscoreActivity extends ListActivity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.viewscore_activity);

        List<HighScoreEntry> entries = Score.getInstance().getEntries();
        String[] values = new String[entries.size()];
        for (int i = 0; i < entries.size(); i++) {
            values[i] = entries.get(i).getName() + ": "
                    + entries.get(i).getScore();
        }

        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, values));

        initButtons();
    }

    private void initButtons() {
        Button returnWithoutSaving = (Button) findViewById(R.id.returnToMenu);
        returnWithoutSaving.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MenuActivity.class));
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // String item = (String) getListAdapter().getItem(position);
        // Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }
}
