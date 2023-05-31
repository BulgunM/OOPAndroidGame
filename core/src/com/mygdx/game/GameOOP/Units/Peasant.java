package com.mygdx.game.GameOOP.Units;

import com.mygdx.game.GameOOP.Units.Unit;

import java.util.ArrayList;

public class Peasant extends Unit { // крестьянин
    public boolean readiness;
    public Peasant(String name, ArrayList<Unit> team, int x, int y) {
        super(name, 10, 0.5f, 1, 1, 0, team, x, y);
        this.readiness = true;
    }

    @Override
    public String toString() {
        return "Пизант";
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        boolean peasantAssigned = false;
        for (Unit unit : team) {
            if (unit instanceof Peasant && !unit.die() && ((Peasant) unit).readiness) {
                ((Peasant) unit).readiness = false;
                peasantAssigned = true;
                //System.out.println(unit.getInfo() + " доставляет стрелы");
                break;
            }
        }
        if (!peasantAssigned) {
            //System.out.println("Firing arrows...");
            for (int i = 0; i < attack; i++) {
                if (!enemy.isEmpty()) {
                    Unit target = enemy.get(0);
                    target.getDamage(attack);
                    if (target.die()) {
                        //System.out.println(target.getInfo() + " мертв");
                        enemy.remove(target);
                    }
                }
            }
        }
    }
}
