package Components;

import Fighters.Fighter;
import utils.Constant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Backdrop {
    private Panel panel;
    private float scale;
    private Fighter[] fighters;
    int backdropX, tick = 0, imageX = 14, imageY = 1, vx = 10, height, width;
    public BufferedImage backdrop;

    public Backdrop(String path, Panel panel){
        this.panel = panel;
        this.fighters = panel.fighter;
        this.scale = Constant.BACKDROP_SCALE;
        InputStream is = getClass().getResourceAsStream(path);
        try {
            assert is != null;
            backdrop = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.backdropX = - 640;
    }

    public void drawBackdrop(Graphics2D g2d){
        tick++;
        if (tick>=1000/ Constant.FPS){
            tick = 0;
            imageY += 245 + 4;
        }
        if (imageY >= 1993) imageY = 1;

        height =  (int) (245 * scale);
        width =  (int) (752 * scale);

        handleCamera(g2d);

        g2d.drawImage(
             backdrop.getSubimage(
                     imageX, imageY, 752, 245
             ),
                backdropX, panel.getHeight() - height, width,
               height , null
        );
    }

    public void handleCamera(Graphics2D g2d){

        for (Fighter ftr: fighters){
            ftr.camera = panel.getWidth() - Math.abs(backdropX);
        }

        int off_set = 10;
        boolean scroll_left = (fighters[0].fighterX <= 120 || fighters[1].fighterX <= 120);
        boolean scroll_right = fighters[0].fighterX >= (panel.getWidth()-120) || fighters[1].fighterX >= (panel.getWidth()-120);
        boolean at_scroll_end = Math.abs(backdropX) > (width - panel.getWidth() - off_set);
        boolean at_scroll_start = backdropX > -off_set;

        if (scroll_left && !at_scroll_start) {
            backdropX += Constant.vx;
        }

        if (scroll_right && !at_scroll_end) {
            backdropX -= Constant.vx;
        }

    }
}
