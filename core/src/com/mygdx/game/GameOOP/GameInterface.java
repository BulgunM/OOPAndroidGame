package com.mygdx.game.GameOOP;

import com.mygdx.game.GameOOP.Units.Unit;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<Unit> enemy);
    String getInfo();

}
