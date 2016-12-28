/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinningPhilosophers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author SONTD
 */
public class Main_DontUse extends JFrame implements ActionListener {

    private JPanel pBg, pFooter;
    private JButton btGo;
    private BufferedImage bg;

    public Main_DontUse(String title) throws IOException {
        super(title);
        initGUI();
    }

    private void initGUI() throws IOException {

        bg = ImageIO.read(new File("image//BGF2.png"));
        pBg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, null);
            }
        };

        pFooter = new JPanel(new FlowLayout());
        pFooter.setBackground(Color.decode("#9D7C51"));
        btGo = new JButton("Go", new ImageIcon("image//run.png"));
        pFooter.add(btGo);

        btGo.addActionListener(this);

        add(pBg);
        add(pFooter, BorderLayout.SOUTH);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
/*
    public static void main(String[] args) {
        try {
            Main app = new Main("Đồ Án Cơ Sở Ngành Mạng - Dining Pholosophers Simulator");
            // app.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Simulator is ready, click Start...\n");
        new App(null);
        requestMinimize();
    }

    void requestMinimize() {
        this.setVisible(false);
    }

    void requestMaximize() {
        this.setVisible(true);
    }
}
