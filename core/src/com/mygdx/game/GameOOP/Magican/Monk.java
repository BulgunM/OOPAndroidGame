package com.mygdx.game.GameOOP.Magican;

import com.mygdx.game.GameOOP.Units.Unit;

import java.util.ArrayList;

public class Monk extends Magican { // монах
    public Monk(String name, ArrayList<Unit> team, int x, int y) {
        super(name, 20, 0.6f, 2, 2, 20, 5, 1, 10, 50, team, x, y);
    }

    @Override
    public String toString() {
        return "Монах";
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
