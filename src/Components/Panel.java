package Components;

import Fighters.*;
import utils.Constant;
import utils.FPS_COUNTER;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Panel extends JPanel {
    FPS_COUNTER fpsCounter;
    public Fighter[] fighter;
    public Backdrop backdrop;
    public InputHandler inputHandler1, inputHandler2;
    public Graphics2D g2d;
    Panel(){
        this.fighter = new Fighter[] {
                new Terry(this, -200),
                new K(this, 480)
        };
        inputHandler2 = new InputHandler(fighter[1]);
        inputHandler1 = new InputHandler(fighter[0]);
        backdrop = new Backdrop("/Town Stage.png", this);
        fpsCounter = new FPS_COUNTER();
        this.setPreferredSize(new Dimension(1000,550));
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g2d = (Graphics2D) g;
        draw(g2d);
//        fpsCounter.countFPS();
    }
    private void draw(Graphics2D g2d){
        fighter[0].enemy = fighter[1];
        fighter[1].enemy = fighter[0];

        backdrop.drawBackdrop(g2d);
        for (Fighter ftr: fighter){
            ftr.update(g2d);
            ftr.handleFireBall(g2d);
        }

//        inputHandler1.handleComputerMove();
//       inputHandler2.handleComputerMove();
    }
}
