import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jianbojia on 12/20/16.
 */
public class SolarSystem extends Frame {

    double x, x1 = 200, x2 = 200, x3 = 200, x4 = 200, x5 = 200, x6 = 200, x7 = 200, x8 = 200;
    double y, y1 = 200, y2 = 200, y3 = 200, y4 = 200, y5 = 200, y6 = 200, y7 = 200, y8 = 200;
    double t = 0, t1 = 0, t2 = 0, t3 = 0, t4 = 0, t5 = 0, t6 = 0, t7 = 0, t8 = 0;

    private Image offScreenImage = null;

    void launchFrame() {
        setSize(900, 900);
        setLocation(50, 50);
        setVisible(true);
        setTitle("Solar System Demo");
        setBackground(Color.black);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();
    }

    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(900, 900);
        }
        Graphics gOff = offScreenImage.getGraphics();
        Color oldColor = gOff.getColor();
        gOff.setColor(Color.BLACK);
        gOff.fillRect(0, 0, 900, 900);
        gOff.setColor(oldColor);
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);

    }

    Image sun = Toolkit.getDefaultToolkit().getImage("images/sun.jpg");
    Image mercury = Toolkit.getDefaultToolkit().getImage("images/Mercury.jpg");
    Image venus = Toolkit.getDefaultToolkit().getImage("images/Venus.jpg");
    Image earth = Toolkit.getDefaultToolkit().getImage("images/Earth.jpg");
    Image mars = Toolkit.getDefaultToolkit().getImage("images/Mars.jpg");
    Image jupiter = Toolkit.getDefaultToolkit().getImage("images/Jupiter.jpg");
    Image saturn = Toolkit.getDefaultToolkit().getImage("images/Saturn.jpg");
    Image uranus = Toolkit.getDefaultToolkit().getImage("images/Uranus.jpg");
    Image neptune = Toolkit.getDefaultToolkit().getImage("images/Neptune.jpg");
    Image moon = Toolkit.getDefaultToolkit().getImage("images/moon.jpg");


    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawImage(sun, 435, 435, null);
        g.drawOval(401, 415, 88, 60);
        g.drawOval(375, 395, 140, 100);
        g.drawOval(335, 365, 220, 160);
        g.drawOval(285, 335, 320, 220);
        g.drawOval(155, 275, 580, 340);
        g.drawOval(120, 245, 650, 400);
        g.drawOval(80, 210, 730, 470);
        g.drawOval(10, 165, 870, 560);

        t1 = t1 + Math.PI / 8.8;
        t2 = t2 + Math.PI / 22.5;
        t3 = t3 + Math.PI / 36.5;
        t = t + Math.PI / 0.1;
        t4 = t4 + Math.PI / 68.7;
        t5 = t5 + Math.PI / 432.9;
        t6 = t6 + Math.PI / 1076.8;
        t7 = t7 + Math.PI / 3066.0;
        t8 = t8 + Math.PI / 6015.2;

        g.drawImage(mercury, (int) x1, (int) y1, null);
        x1 = 440 + 44 * Math.cos(t1);
        y1 = 440 + 30 * Math.sin(t1);
        g.drawImage(venus, (int) x2, (int) y2, null);
        x2 = 440 + 70 * Math.cos(t2);
        y2 = 440 + 50 * Math.sin(t2);
        g.drawImage(earth, (int) x3, (int) y3, null);
        x3 = 440 + 110 * Math.cos(t3);
        y3 = 440 + 80 * Math.sin(t3);
        g.drawImage(moon, (int) x, (int) y, null);
        x = x3 + 15 * Math.cos(t1);
        y = y3 + 15 * Math.sin(t1);
        g.drawImage(mars, (int) x4, (int) y4, null);
        x4 = 440 + 160 * Math.cos(t4);
        y4 = 440 + 110 * Math.sin(t4);
        g.drawImage(jupiter, (int) x5, (int) y5, null);
        x5 = 435 + 290 * Math.cos(t5);
        y5 = 435 + 170 * Math.sin(t5);
        g.drawImage(saturn, (int) x6, (int) y6, null);
        x6 = 428 + 325 * Math.cos(t6);
        y6 = 428 + 200 * Math.sin(t6);
        g.drawImage(uranus, (int) x7, (int) y7, null);
        x7 = 435 + 365 * Math.cos(t7);
        y7 = 435 + 235 * Math.sin(t7);
        g.drawImage(neptune, (int) x8, (int) y8, null);
        x8 = 435 + 435 * Math.cos(t8);
        y8 = 435 + 280 * Math.sin(t8);
    }

    private class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        new SolarSystem().launchFrame();
    }
}
