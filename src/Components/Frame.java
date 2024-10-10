package Components;

import Controllers.KeyController;

import javax.swing.*;

public class Frame extends JFrame implements Runnable {
    public Panel panel;
    private Thread gameThread;
    private final int FPS = 120;
   public Frame(){
       panel = new Panel();
       this.setTitle("Street Fighter 2: Java Edition");
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.add(panel);
       this.pack();
       this.setLocationRelativeTo(null);
       this.setResizable(false);
       this.addKeyListener(new KeyController(panel));
       this.setVisible(true);
       startGame();
    }

    public void startGame(){
       gameThread = new Thread(this);
       gameThread.start();
    }

    @Override
    public void run() {
       double timePerFrame = (double) 1000000000 / FPS;
       long lastFrame = System.nanoTime();

       while (gameThread != null) {
           long now = System.nanoTime();
           if(now - lastFrame >= timePerFrame){
               panel.repaint();
               lastFrame = now;
           }
       }
    }
}
