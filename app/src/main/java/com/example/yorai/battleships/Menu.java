package com.example.yorai.battleships;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    final static String BUNDLE_KEY = "GameBundle";
    final static String GAME_KEY = "GameLevel";
    final static int EASY =0;
    final static int NORMAL =1;
    final static int HARD =2;

    Button easy;
    Button normal;
    Button hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        easy = (Button) findViewById(R.id.easy);
        easy.setOnClickListener(this);
        normal = (Button) findViewById(R.id.normal);
        normal.setOnClickListener(this);
        hard = (Button) findViewById(R.id.hard);
        hard.setOnClickListener(this);
    }

    public void startGameActivity(int difficulty) {
        Intent GameActivity = new Intent(this, GameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(GAME_KEY, difficulty);
        GameActivity.putExtra(BUNDLE_KEY , bundle);
        startActivity(GameActivity);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.easy:
                startGameActivity(EASY);
                break;

            case R.id.normal:
                startGameActivity(NORMAL);
                break;

            case R.id.hard:
                startGameActivity(HARD);
                break;
        }
    }
}
