package com.example.yorai.battleships.Logic;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.yorai.battleships.R;

import java.util.ArrayList;

public class Battleship extends ArrayAdapter<Cell> {
    private LayoutInflater inflater;
    private GridView ship;
    boolean isHorizontal;
    int size;
    boolean isAlive;

    public Battleship(Context context, int size, GridView ship) {
        super(context, -1, new ArrayList<Cell>());
        inflater = LayoutInflater.from(context);
        this.size = size;
        isHorizontal = true;
        isAlive = true;
        this.ship = ship;
        for (int i = 0; i < size; i++)
            this.add(new Cell());
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_cell, parent, false);
        Cell cell = getItem(position);

        Button button = (Button) view.findViewById(R.id.button_board_cell);

        if (cell.getState() == Cell.CellState.HIT)
            button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorHit));
        else
            button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorOccupied));

        return view;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal() {
        isHorizontal = true;
        ship.setNumColumns(size);
    }

    public void setVertical() {
        isHorizontal = false;
        ship.setNumColumns(1);
    }

    public int getSize() {
        return size;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void sink() {
        isAlive = false;
    }
}
