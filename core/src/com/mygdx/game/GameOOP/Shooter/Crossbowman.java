package com.mygdx.game.GameOOP.Shooter;

import com.mygdx.game.GameOOP.Shooter.Shooter;
import com.mygdx.game.GameOOP.Units.Unit;

import java.util.ArrayList;

public class Crossbowman extends Shooter { // арбалетчик

    public Crossbowman(String name, ArrayList<Unit> team, int x, int y) {
        super(name, 20, 0.5f, 4, 2, 2, 50, 0.5f, 10, team, x, y);
    }

    @Override
    public String toString() {
        return "Арбалетчик";
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }


}


