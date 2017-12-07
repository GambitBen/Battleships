package com.example.yorai.battleships.Logic;

import android.content.Context;
import android.widget.GridView;

public class GameLogic {
    private static GameLogic instance;
    private Player player1,player2;
    private int playerTurn;
    private int timer;
    private int numColumns;
    private Context context;
    private GridView field;

    private GameLogic() {
        player1 = new Player();
        player2 = new Player();
    }

    public static GameLogic getInstance() {
        if (instance == null)
            instance = new GameLogic();
        return instance;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setFields(Context context, int numColumns,GridView gridViewBoard,AdapterBoard adapterBoard1, AdapterBoard adapterBoard2) {
        this.context = context;
        this.numColumns = numColumns;
        this.field = gridViewBoard;
        this.player1.setField(adapterBoard1);
        this.player2.setField(adapterBoard2);

        adapterBoard1.clear();
        adapterBoard2.clear();
        adapterBoard1.addCells(numColumns);
        adapterBoard2.addCells(numColumns);

        field.setAdapter(player1.getField());
    }


}
