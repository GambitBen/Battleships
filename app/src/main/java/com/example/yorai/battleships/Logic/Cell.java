package com.example.yorai.battleships.Logic;

public class Cell {
    private CellState state;

    public Cell() {
        state = CellState.VACANT;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public enum CellState {
        VACANT, OCCUPIED, HIT, MISS
    }
}
