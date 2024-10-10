package Components;

import Fighters.Fighter;
import Fighters.K;
import Fighters.Terry;
import utils.Constant;

import java.util.Random;

public class InputHandler {
    private Fighter fighter;
    public InputHandler(Fighter fighter){
        this.fighter = fighter;
    }
    public void handleInputs(int input){
        if (fighter.state== Fighter.STATE.HURT) return;
        switch (input) {
            case 87 -> {
                if (!fighter.attacking){
                    fighter.isJumping = true;
                    fighter.state = Fighter.STATE.JUMP;
                }
            }
            case 83 -> {
                if (!fighter.isJumping && !fighter.attacking ) fighter.state = Fighter.STATE.CROUCH;
            }
            case 68 -> {
                if(!fighter.attacking ){
                    if (fighter.isJumping) {
                        fighter.state = Fighter.STATE.JUMP_FORWARD;
                    } else fighter.state = Fighter.STATE.WALK_FORWARD;
                }
            }
            case 65 -> {
                if(!fighter.attacking ){
                    if (fighter.isJumping) {
                        fighter.state = Fighter.STATE.JUMP_BACKWARD;
                    }
                    else fighter.state = Fighter.STATE.WALK_BACKWARD;
                }
            }
            case 53 -> {
                if (!fighter.isJumping && !fighter.attacking ){
                    fighter.attacking = true;
                    fighter.state = Fighter.STATE.PUNCH_A;
                }
            }
            case 54 -> {
                if(!fighter.isJumping && !fighter.attacking ){
                    fighter.attacking = true;
                    fighter.state = Fighter.STATE.PUNCH_B;
                }
            }
            case 84 -> {
                if(!fighter.isJumping && !fighter.attacking ) {
                    fighter.attacking = true;
                    fighter.state = Fighter.STATE.KICK_A;
                }
            }
            case 89 -> {
                if(!fighter.isJumping && !fighter.attacking ) {
                    fighter.attacking = true;
                    fighter.state = Fighter.STATE.KICK_B;
                }
            }
        }
    }

    Random rand = new Random();
    int i = 0, tick = 0;
    public void handleComputerMove(){

        tick++;
        if (tick >= 1000/ Constant.FPS){
            tick = 0;

            int distance = (int) Math.abs(fighter.x - fighter.enemy.x);
            int computerMove = Constant.FIGHTER_CONTROLS_1.get(rand.nextInt(0,Constant.FIGHTER_CONTROLS_1.size()));
            int walk = fighter.direction>0? 68: 65;
            computerMove = distance >= 180? walk: computerMove;

            handleInputs(computerMove);
        }
    }
}
