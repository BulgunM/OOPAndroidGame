package com.mygdx.game.GameOOP.Shooter;

import com.mygdx.game.GameOOP.GameInterface;
import com.mygdx.game.GameOOP.Units.Peasant;
import com.mygdx.game.GameOOP.Units.Unit;

import java.util.ArrayList;

public abstract class Shooter extends Unit implements GameInterface {
    protected int distance, maxCountBullet, currentCountBullet;
    protected float accuracy;

    public Shooter(String name, float maxHp, float luck, int speed, int attack,
                      int distance, int maxCountBullet, float accuracy, float armor, ArrayList<Unit> team, int x, int y) {
        super(name, maxHp, luck, speed, attack, armor, team, x, y);
        this.distance = distance;
        this.maxCountBullet = maxCountBullet;
        this.currentCountBullet = maxCountBullet;
        this.accuracy = accuracy;
    }

    void shoot() {
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " distance:" + distance +
                " bullets:" + currentCountBullet + "/" + maxCountBullet +
                " accuracy:" + accuracy;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (die() || currentCountBullet <= 0) {
            return;
        }
        attack(findNearUnit(enemy));
        for (Unit unit : team) {
            if (unit instanceof Peasant) {
                if (!unit.die() && ((Peasant) unit).readiness) {
                    ((Peasant) unit).readiness = false;
                    return;
                }
            }
        }
        this.currentCountBullet--;
    }


}
