package com.example.yorai.battleships.Logic;

public class Player {
    Battleship[] remainingBattleships;
    AdapterBoard field;

    public Player() {
    }

    public Battleship[] getRemainingBattleships() {
        return remainingBattleships;
    }

    public void setRemainingBattleships(Battleship[] remainingBattleships) {
        this.remainingBattleships = remainingBattleships;
    }

    public AdapterBoard getField() {
        return field;
    }

    public void setField(AdapterBoard field) {
        this.field = field;
    }
}
