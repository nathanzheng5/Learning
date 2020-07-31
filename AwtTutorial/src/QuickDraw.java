import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class QuickDraw {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JComponent canvas = new Canvas();

        frame.setContentPane(canvas);
        frame.setSize(800, 600);

        frame.setVisible(true);
    }

    static class Canvas extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(new Line2D.Double(0, 0, 100, 100));
        }
    }
}
