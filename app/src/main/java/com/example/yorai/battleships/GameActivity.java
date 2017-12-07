package com.example.yorai.battleships;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.yorai.battleships.Logic.AdapterBoard;
import com.example.yorai.battleships.Logic.Battleship;
import com.example.yorai.battleships.Logic.Cell;
import com.example.yorai.battleships.Logic.GameLogic;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener {
    private int gameLevel;
    private GameLogic gameLogic;
    private GridView gridViewBoard;
    private int numColumns;
    private AdapterBoard adapterBoard1, adapterBoard2;
    private Battleship[] ships;

    float dX;
    float dY;
    int lastAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extractDataFromBundle();
        gameLogic = GameLogic.getInstance();

        //got too tired to worry about design patterns


        GridView battleship1 = (GridView)findViewById(R.id.battleship1);
        battleship1.setOnTouchListener(this);
        GridView battleship2 = (GridView)findViewById(R.id.battleship2);
        battleship2.setOnTouchListener(this);
        GridView battleship3 = (GridView)findViewById(R.id.battleship3);
        battleship3.setOnTouchListener(this);
        GridView battleship4 = (GridView)findViewById(R.id.battleship4);
        battleship4.setOnTouchListener(this);
        GridView battleship5 = (GridView)findViewById(R.id.battleship5);
        battleship5.setOnTouchListener(this);
        GridView battleship6 = (GridView)findViewById(R.id.battleship6);
        battleship6.setOnTouchListener(this);
        GridView battleship7 = (GridView)findViewById(R.id.battleship7);
        battleship7.setOnTouchListener(this);
        GridView battleship8 = (GridView)findViewById(R.id.battleship8);
        battleship8.setOnTouchListener(this);
        GridView battleship9 = (GridView)findViewById(R.id.battleship9);
        battleship9.setOnTouchListener(this);
        GridView battleship10 = (GridView)findViewById(R.id.battleship10);
        battleship10.setOnTouchListener(this);

        ships = new Battleship[10];
        switch (gameLevel){
            case 0:
                ships[0] = new Battleship(this,3,battleship1);
                ships[1] = new Battleship(this,2,battleship2);
                ships[2] = new Battleship(this,2,battleship3);
                ships[3] = new Battleship(this,1,battleship4);
                ships[4] = new Battleship(this,1,battleship5);
                ships[5] = new Battleship(this,1,battleship6);
                ships[6] = new Battleship(this,1,battleship7);
                ships[7] = new Battleship(this,1,battleship8);
                ships[8] = new Battleship(this,1,battleship9);
                ships[9] = new Battleship(this,1,battleship10);
                break;
            case 1:
                ships[0] = new Battleship(this,4,battleship1);
                ships[1] = new Battleship(this,3,battleship2);
                ships[2] = new Battleship(this,3,battleship3);
                ships[3] = new Battleship(this,2,battleship4);
                ships[4] = new Battleship(this,2,battleship5);
                ships[5] = new Battleship(this,2,battleship6);
                ships[6] = new Battleship(this,1,battleship7);
                ships[7] = new Battleship(this,1,battleship8);
                ships[8] = new Battleship(this,1,battleship9);
                ships[9] = new Battleship(this,1,battleship10);
                break;
            case 2:
                ships[0] = new Battleship(this,4,battleship1);
                ships[1] = new Battleship(this,4,battleship2);
                ships[2] = new Battleship(this,3,battleship3);
                ships[3] = new Battleship(this,3,battleship4);
                ships[4] = new Battleship(this,2,battleship5);
                ships[5] = new Battleship(this,2,battleship6);
                ships[6] = new Battleship(this,2,battleship7);
                ships[7] = new Battleship(this,2,battleship8);
                ships[8] = new Battleship(this,1,battleship9);
                ships[9] = new Battleship(this,1,battleship10);
                break;
        }

        battleship1.setAdapter(ships[0]);
        battleship2.setAdapter(ships[1]);
        battleship3.setAdapter(ships[2]);
        battleship4.setAdapter(ships[3]);
        battleship5.setAdapter(ships[4]);
        battleship6.setAdapter(ships[5]);
        battleship7.setAdapter(ships[6]);
        battleship8.setAdapter(ships[7]);
        battleship9.setAdapter(ships[8]);
        battleship10.setAdapter(ships[9]);
//not showing grids

        setFields();
        enableGame();
    }

    private void enableGame() {
        gameLogic.setFields(this, numColumns,gridViewBoard, adapterBoard1, adapterBoard2);
    }

    private void setFields() {
        numColumns = getResources().getInteger(R.integer.num_cells_board_side);
        gridViewBoard = (GridView) findViewById(R.id.gridViewBoard);
        adapterBoard1 = new AdapterBoard(this, new ArrayList<Cell>(),gameLogic.getPlayer1());
        adapterBoard2 = new AdapterBoard(this, new ArrayList<Cell>(),gameLogic.getPlayer2());
    }

    private void extractDataFromBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Menu.BUNDLE_KEY);
        gameLevel = bundle.getInt(Menu.GAME_KEY);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;
                break;

            case MotionEvent.ACTION_MOVE:
                view.setY(event.getRawY() + dY);
                view.setX(event.getRawX() + dX);
                lastAction = MotionEvent.ACTION_MOVE;
                break;

            case MotionEvent.ACTION_UP:
                if (lastAction == MotionEvent.ACTION_DOWN)
                    Toast.makeText(GameActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                break;

            default:
                return false;
        }
        return true;
    }
}
