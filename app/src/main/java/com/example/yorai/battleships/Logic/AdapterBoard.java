package com.example.yorai.battleships.Logic;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;


import com.example.yorai.battleships.R;

import java.util.List;

public class AdapterBoard extends ArrayAdapter<Cell> {
    private LayoutInflater inflater;
    private Player owner;

    public AdapterBoard(Context context, List<Cell> objects, Player owner) {
        super(context, -1, objects);
        inflater = LayoutInflater.from(context);
        this.owner = owner;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_cell, parent, false);
        Cell cell = getItem(position);

        Button button = (Button) view.findViewById(R.id.button_board_cell);

        if (cell.getState() == Cell.CellState.HIT)
            button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorHit));
        else if (cell.getState() == Cell.CellState.MISS)
            button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorMissed));

        else if (cell.getState() == Cell.CellState.VACANT)
            button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorVacant));
        else
            button.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorOccupied));

        return view;
    }

    public void addCells(int numCells) {
        for (int i = 0; i < numCells; i++)
            this.add(new Cell());
    }
}

