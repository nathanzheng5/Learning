package GUI;

/**
 * Created by NZheng on 01-Mar-2018.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ICSEBug {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ICSEBug::go);
    }

    static void go() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        final JDialog dialog = new JDialog(frame);

        dialog.getContentPane().add(new JTextField(20), "Center");

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.setVisible(false));
        dialog.getContentPane().add(closeButton, "South");

        dialog.getRootPane().setDefaultButton(closeButton);

        dialog.setModal(true);
        dialog.setSize(300, 300);
        frame.setAlwaysOnTop(true);
        dialog.setVisible(true);
//        frame.setAlwaysOnTop(false);
    }

}


