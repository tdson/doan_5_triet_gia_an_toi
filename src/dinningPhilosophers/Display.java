/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinningPhilosophers;

/**
 *
 * @author SONTD
 */
import java.awt.*;
import javax.swing.*;

public class Display extends JPanel implements Runnable {

    Image bg;
    Image s0, s1, s2, s3, s4;
    Image plate[] = new Image[5];
    Toolkit t;
    Image state1, state2;
    Font font;
    Chopstick chopstick;
    Philosopher philosopher;

    boolean isStop = false;
    // flag = true -> call method wait()
    boolean flag = false;
    boolean isPause = false;
    boolean waitRequested = false;

    public Display() {
        t = Toolkit.getDefaultToolkit();
        font = new Font("Tahoma", Font.PLAIN, 20);
        bg = t.getImage("image//BG.png");
        s0 = t.getImage("image//st0.png");
        s1 = t.getImage("image//st1.png");
        s2 = t.getImage("image//st2.png");
        s3 = t.getImage("image//st3.png");
        s4 = t.getImage("image//st4.png");
        state1 = t.getImage("image//eating.png");
        state2 = t.getImage("image//thinking.png");
        plate[0] = t.getImage("image//p0.png");
        plate[1] = t.getImage("image//p2.png");
        plate[2] = t.getImage("image//p3.png");
        plate[3] = t.getImage("image//p4.png");
        plate[4] = t.getImage("image//p5.png");

        chopstick = new Chopstick();
        philosopher = new Philosopher();

    }

    public void run() {
        while (!isStop) {

            try {
                //check if the thread should wait first, if not let it do a full iteration of the loop
                if (waitRequested) {
                    synchronized (this) {
                        wait();

                        //resuming here so wait wouldn't be requested anymore
                        waitRequested = false;
                    }
                }

                //do whatever a philosopher does
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        repaint();
                    }
                });
                

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                //handle exception
            }

        }
    }

    void requestWait() {
        waitRequested = true;
    }

    void resume() {
        synchronized (this) {
            notify();
        }
    }

    public void raseFlag(boolean flag) {
        this.flag = flag;SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        } );
    }

    public void paint(Graphics g) {
        super.paint(g);
        // this.setBackground(Color.white);
        g.drawImage(bg, 0, 0, 800, 600, null);
        drawP(g);
        drawP0(g);
        drawP1(g);
        drawP2(g);
        drawP3(g);
        drawP4(g);
        draw0(g);
        draw1(g);
        draw2(g);
        draw3(g);
        draw4(g);
        drawS0(g);
        drawS1(g);
        drawS2(g);
        drawS3(g);
        drawS4(g);
    }

    public void draw0(Graphics g) {
        g.drawImage(s0, chopstick.getXpos(0), chopstick.getYpos(0), 100, 100,
                null);
    }

    public void draw1(Graphics g) {
        g.drawImage(s1, chopstick.getXpos(1), chopstick.getYpos(1), 100, 100,
                null);
    }

    public void draw2(Graphics g) {
        g.drawImage(s2, chopstick.getXpos(2), chopstick.getYpos(2), 100, 100,
                null);
    }

    public void draw3(Graphics g) {
        g.drawImage(s3, chopstick.getXpos(3), chopstick.getYpos(3), 100, 100,
                null);
    }

    public void draw4(Graphics g) {
        g.drawImage(s4, chopstick.getXpos(4), chopstick.getYpos(4), 100, 100,
                null);
    }

    public void drawP0(Graphics g) {
        g.drawImage(plate[philosopher.getS(0)], 355, 340, 100, 100, null);
    }

    public void drawP1(Graphics g) {
        g.drawImage(plate[philosopher.getS(1)], 210, 275, 100, 100, null);
    }

    public void drawP2(Graphics g) {
        g.drawImage(plate[philosopher.getS(2)], 275, 145, 100, 100, null);
    }

    public void drawP3(Graphics g) {
        g.drawImage(plate[philosopher.getS(3)], 445, 145, 100, 100, null);
    }

    public void drawP4(Graphics g) {
        g.drawImage(plate[philosopher.getS(4)], 488, 285, 100, 100, null);
    }

    public void drawP(Graphics g) {
        g.drawImage(plate[0], 355, 340, 100, 100, null);
        g.drawImage(plate[0], 210, 275, 100, 100, null);
        g.drawImage(plate[0], 275, 145, 100, 100, null);
        g.drawImage(plate[0], 445, 145, 100, 100, null);
        g.drawImage(plate[0], 488, 285, 100, 100, null);
    }

    //
    public void drawS0(Graphics g) {
        g.setFont(font);
        // getNoMeals
        g.setColor(Color.RED);
        g.drawString(
                "No Of Meals = " + Integer.toString(philosopher.getNoMeals(0)),
                920, 60);
        g.setColor(Color.BLACK);
        if (philosopher.getS(0) == 4) {
            g.drawImage(state2, 800, 0, 120, 120, null);
            g.drawString("Thinking", 920, 30);
        } else {
            g.drawImage(state1, 800, 0, 120, 120, null);
            g.drawString("Eating", 920, 30);
        }

    }

    public void drawS1(Graphics g) {
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(
                "No Of Meals = " + Integer.toString(philosopher.getNoMeals(1)),
                920, 180);
        g.setColor(Color.BLACK);
        if (philosopher.getS(1) == 4) {
            g.drawImage(state2, 800, 120, 120, 120, null);
            g.drawString("Thinking", 920, 150);
        } else {
            g.drawImage(state1, 800, 120, 120, 120, null);
            g.drawString("Eating", 920, 150);
        }
    }

    public void drawS2(Graphics g) {
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(
                "No Of Meals = " + Integer.toString(philosopher.getNoMeals(2)),
                920, 300);
        g.setColor(Color.BLACK);
        if (philosopher.getS(2) == 4) {
            g.drawImage(state2, 800, 240, 120, 120, null);
            g.drawString("Thinking", 920, 270);
        } else {
            g.drawImage(state1, 800, 240, 120, 120, null);
            g.drawString("Eating", 920, 270);
        }
    }

    public void drawS3(Graphics g) {
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(
                "No Of Meals = " + Integer.toString(philosopher.getNoMeals(3)),
                920, 420);
        g.setColor(Color.BLACK);
        if (philosopher.getS(3) == 4) {
            g.drawImage(state2, 800, 360, 120, 120, null);
            g.drawString("Thinking", 920, 390);
        } else {
            g.drawImage(state1, 800, 360, 120, 120, null);
            g.drawString("Eating", 920, 390);
        }
    }

    public void drawS4(Graphics g) {
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(
                "No Of Meals = " + Integer.toString(philosopher.getNoMeals(4)),
                920, 540);
        g.setColor(Color.BLACK);
        if (philosopher.getS(4) == 4) {
            g.drawImage(state2, 800, 480, 120, 120, null);
            g.drawString("Thinking", 920, 510);
        } else {
            g.drawImage(state1, 800, 480, 120, 120, null);
            g.drawString("Eating", 920, 510);
        }
    }

    public void drawQuote(Graphics g) {
        if (philosopher.getQuote(0) == 1) {

        }
        if (philosopher.getQuote(0) == 2) {

        }
        if (philosopher.getQuote(0) == 3) {

        }
    }

    public boolean getStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
