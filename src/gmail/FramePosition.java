/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author SONTD
 */
public class FramePosition {
    public static void setCenterPosition(Component component) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int hight = (screenSize.height - component.getHeight()) / 2 - 20;
        int width = (screenSize.width - component.getWidth()) / 2;
        component.setLocation(new Point(width, hight));
    }
}
