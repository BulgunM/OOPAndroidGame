package com.mygdx.game.GameOOP.Magican;

import com.mygdx.game.GameOOP.Shooter.Shooter;
import com.mygdx.game.GameOOP.Units.Unit;

import java.util.ArrayList;

public abstract class Magican extends Shooter { // колдун
    protected float maxMana, currentMana;

    public Magican(String name, float maxHp, float luck, int speed, int attack,
            int distance, int maxCountBullet, float accuracy, float armor, float maxMana, ArrayList<Unit> team, int x, int y) {
        super(name, maxHp, luck, speed, attack, distance, maxCountBullet, accuracy, armor, team, x, y);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    void heal() {
    }

    void fire(){}

    void freeze() {
    }

    void addMana() {
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " mana:" + currentMana + "/" + maxMana;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (this.currentHp > 0 && currentMana > 0) {
            for (Unit unit : team) {
                if (!unit.die() && unit.currentHp < unit.maxHp) {
                    unit.getDamage(-attack);
                    this.currentMana--;
                    return;
                }
            }
        }
    }
}
