package utils;
public class FPS_COUNTER {
    private int frames = 0;
    private long lastCheck = 0;

    public  void countFPS(){
         frames++;
         long current =  System.currentTimeMillis();
         if(current - lastCheck >= 1000){
             lastCheck = current;
             System.out.println("FPS: "+frames);
             frames = 0;
         }
    }
}
