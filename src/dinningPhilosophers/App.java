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
import java.awt.event.*;
import javax.swing.*;
import main.Program;

public class App {

    JButton btPause, btStart;
    JPanel panelButton;
    JFrame f1;
    Chopstick chopstick[];
    Philosopher philosophers[];

    final String TITLE = "Đồ Án Cơ Sở Ngành Mạng - Dining Pholosophers Simulator";
    final ImageIcon ICON_START = new ImageIcon("image/run.png");
    final ImageIcon ICON_PAUSE = new ImageIcon("image/play.png");
    final ImageIcon ICON_RESUME = new ImageIcon("image/resume.png");

    boolean isRunning = false;

    /*
     @Para m Cửa sổ parent gọi cửa sổ app
     */
    public App(Program m) {

        f1 = new JFrame();
        //f1.setLayout(null);
        f1.setTitle(TITLE);

        // Khởi tạo 5 cây đũa
        initializePos();
        // Khởi tạo 5 luồng (Triết gia)
        initializePhilosopher();
        Display obj = new Display();
        obj.setBounds(0, 0, 1040, 600);

        // Luồng chính Frame cửa sổ chính
        Thread t1 = new Thread(obj);
        // t1.start();
        // Chạy 5 luồng triết gia
        Thread p1 = new Thread(philosophers[0]);
        // p1.start();
        Thread p2 = new Thread(philosophers[1]);
        // p2.start();
        Thread p3 = new Thread(philosophers[2]);
        // p3.start();
        Thread p4 = new Thread(philosophers[3]);
        // p4.start();
        Thread p5 = new Thread(philosophers[4]);
        // p5.start();
        // f1.add(obj0);
        f1.add(obj);

        //btStart = new JButton("Start...", new ImageIcon("image/pause16.png"));
        btStart = new JButton("Run", ICON_START);
        btPause = new JButton("Pause", ICON_PAUSE);
        btPause.setEnabled(false);

        // Chạy các tiến trình
        btStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                p1.start();
                p2.start();
                p3.start();
                p4.start();
                p5.start();
                isRunning = true;
                btStart.setEnabled(false);
                btPause.setEnabled(true);
            }
        });

        // Đóng băng các tiến trình đang chạy
        btPause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Nếu đóng băng
                if (isRunning) {
                    isRunning = false;
                    // Thay đổi trên giao diện
                    btPause.setText("Resume");
                    btPause.setIcon(ICON_RESUME);

                    // Dừng các thread
                    obj.requestWait();
                    philosophers[0].requestWait();
                    philosophers[1].requestWait();
                    philosophers[2].requestWait();
                    philosophers[3].requestWait();
                    philosophers[4].requestWait();

                    /*
                     obj.setStop(true);
                     philosophers[0].setStop(true);
                     philosophers[1].setStop(true);
                     philosophers[2].setStop(true);
                     philosophers[3].setStop(true);
                     philosophers[4].setStop(true);
                     */
                } else {
                    // Nếu là resume
                    isRunning = true;
                    btPause.setText("Pause");
                    btPause.setIcon(ICON_PAUSE);

                    // Chạy lại các thread
                    obj.resume();
                    philosophers[0].resume();
                    philosophers[1].resume();
                    philosophers[2].resume();
                    philosophers[3].resume();
                    philosophers[4].resume();
                    /*
                     obj.setStop(true);
                     philosophers[0].setStop(false);
                     philosophers[1].setStop(false);
                     philosophers[2].setStop(false);
                     philosophers[3].setStop(false);
                     philosophers[4].setStop(false);

                     */
                    /* 1.start();
                     p1.start();
                     p2.start();
                     p3.start();
                     p4.start();
                     p5.start();
                     */
                }
            }
        });

        // f1.add(btStart, BorderLayout.SOUTH);
        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelButton.setBackground(Color.lightGray);
        panelButton.add(btStart);
        panelButton.add(btPause);
        f1.add(panelButton, BorderLayout.SOUTH);
        // f1.setAlwaysOnTop(true);
        f1.setSize(1120, 680);
        f1.setVisible(true);
        // f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                f1.setVisible(false);
                obj.setStop(true);
                philosophers[0].setStop(true);
                philosophers[1].setStop(true);
                philosophers[2].setStop(true);
                philosophers[3].setStop(true);
                philosophers[4].setStop(true);
     
                f1.dispose();
                m.requestMaximize();
            }
        });

        f1.validate();

    }

    public void initializePos() {
        chopstick = new Chopstick[5];
        chopstick[0] = new Chopstick(0, 270, 330);
        chopstick[1] = new Chopstick(1, 200, 200);
        chopstick[2] = new Chopstick(2, 350, 120);
        chopstick[3] = new Chopstick(3, 500, 210);
        chopstick[4] = new Chopstick(4, 430, 330);
    }

    public void initializePhilosopher() {
        philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher(0, chopstick[0], chopstick[4]);
        philosophers[1] = new Philosopher(1, chopstick[1], chopstick[0]);
        philosophers[2] = new Philosopher(2, chopstick[2], chopstick[1]);
        philosophers[3] = new Philosopher(3, chopstick[3], chopstick[2]);
        philosophers[4] = new Philosopher(4, chopstick[4], chopstick[3]);
    }

    void requestMinimize() {
        f1.setVisible(false);
    }

    void requestMaximize() {
        f1.setVisible(true);
    }
    /*
     public static void main(String args[]) {
     System.out.println("Simulator is ready, click Start...\n");
     new App();
     }
     */
}
