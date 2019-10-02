package GUI;


import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class TestDarkNimbus {

    public static void main(String[] args) throws Exception {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().startsWith("Nimbus")) {
                System.out.println("Setting look and feel to " + info.getName());
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        UIDefaults d = UIManager.getDefaults();
        d.put("control", new ColorUIResource(54, 54, 54));
        d.put("text", new ColorUIResource(214, 214, 214));
        d.put("nimbusBlueGrey", new ColorUIResource(44, 44, 44));
        d.put("nimbusBase", new ColorUIResource(54, 54, 54));
        d.put("nimbusFocus", new Color(71, 85, 101));
        d.put("nimbusLightBackground", new ColorUIResource(54,
                54, 54));
        d.put("nimbusSelectionBackground", new
                ColorUIResource(51, 65,
                81));
        d.put("nimbusSelection", new ColorUIResource(51, 65, 81));

        final JFrame frame = new JFrame(TestDarkNimbus.class.getSimpleName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("Test Dialog Flashing");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame.getContentPane(),
                "Flash !!!!!!!!!!!!", "Flash demo",
                JOptionPane.INFORMATION_MESSAGE));
        frame.getContentPane().add(button);
        frame.pack();
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }
}
