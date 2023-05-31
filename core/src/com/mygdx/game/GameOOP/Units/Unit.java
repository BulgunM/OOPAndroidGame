package com.mygdx.game.GameOOP.Units;

import com.mygdx.game.GameOOP.GameInterface;

import java.util.ArrayList;

public abstract class Unit implements GameInterface {
    public String name;
    public float maxHp;
    public float currentHp;
    protected float luck;
    protected float armor;
    protected int attack;
    public int speed;
    protected ArrayList<Unit> team;
    public Coordinate coordinate;

    public Unit(String name, float maxHp, float luck, int speed, int attack, float armor, ArrayList<Unit> team, int x, int y){
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.luck = luck;
        this.speed =speed;
        this.attack = attack;
        this.armor = armor;
        this.team = team;
        this.coordinate = new Coordinate(x, y);
    }

    protected void attack(Unit target){
        target.getDamage(attack);
    }
    void await(){
    }
    void defend(){
    }

    public boolean die(){
        if (currentHp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void getDamage(float damage){
        this.currentHp -= damage;
        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
    }

    @Override
    public String getInfo() {
        return "[" + name + " " + toString() + "] hp:" +
                currentHp + "/" + maxHp + " luck:" + luck
                + " speed:" + speed + " attack:" + attack
                + " armor:" + armor;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (die()) {
            return;
        }
        Unit target = findNearUnit(enemy);
        if (target.coordinate.distance(this.coordinate) < 2) {
            attack(target);
        }else {
            move(target);
        }
    }

    public Unit findNearUnit(ArrayList<Unit> team){
        Unit nearUnit = null;
        float minDist = Float.MAX_VALUE;
        for (Unit unit : team) {
            if(unit.die())continue;
            float dist = unit.coordinate.distance(this.coordinate);
            if (minDist > dist) {
                nearUnit = unit;
                minDist = dist;
            }
        }
        return nearUnit;
    }

    protected void move(Unit target){
        int dx = target.coordinate.distanceXY(this.coordinate)[0];
        int dy = target.coordinate.distanceXY(this.coordinate)[1];
        if (Math.abs(dx) < Math.abs(dy)){
            moveY(dx, dy, true);
        }else {
            moveX(dx, dy, true);
        }
    }

    private void moveX(int dx, int dy, boolean flag){
        if (dx > 0) {
            if (isEmptyPosition(this.coordinate.x-1, this.coordinate.y)) {
                this.coordinate.x--;
            }else if(flag){
                moveY(dx,dy, false);
            }
        }else {
            if (isEmptyPosition(this.coordinate.x+1, this.coordinate.y)) {
                this.coordinate.x++;
            }else if(flag){
                moveY(dx,dy, false);
            }
        }
    }
    private void moveY(int dx, int dy, boolean flag){
        if (dy > 0) {
            if (isEmptyPosition(this.coordinate.x, this.coordinate.y-1)) {
                this.coordinate.y--;
            }else if(flag){
                moveX(dx,dy, false);
            }
        }else {
            if (isEmptyPosition(this.coordinate.x, this.coordinate.y+1)) {
                this.coordinate.y++;
            }else if(flag){
                moveX(dx,dy, false);
            }
        }
    }

    protected boolean isEmptyPosition(int x, int y){
        for (Unit unit: team) {
            if (unit.coordinate.x == x && unit.coordinate.y == y) {
                if (!unit.die()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getCoords() {
        return new int[] {coordinate.x, coordinate.y};
    }

    public float getHp() {
        return currentHp;
    }
}


