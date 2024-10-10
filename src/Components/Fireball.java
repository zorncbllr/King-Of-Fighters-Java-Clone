package Components;

import Fighters.Fighter;
import utils.Constant;

public class Fireball {
    public int i, tick=0, distance, fireY;
    Fighter fighter;
    Panel panel;
    int[][] frames;
    public Fireball(Fighter fighter, Panel panel, int y){
        this.fighter = fighter;
        this.frames = fighter.fireball;
        this.distance = fighter.x;
        this.fireY = y;
        this.i = 0;
        this.panel = panel;
    }

    public void update() {
        this.distance += fighter.direction * 5;

        if (fighter.hitting() || Math.abs(fighter.x - distance)>panel.getWidth()){
            fighter.hitBox.setBounds(0,0,0,0);
            fighter.fireballList.remove(this);
        }
        tick++;
        if (tick>=1000/ Constant.FPS){
            tick = 0;
            i++;
        }
        if (i >= frames.length) i = 0;
    }
}
