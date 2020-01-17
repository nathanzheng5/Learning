import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * TODO: CLASS JAVA DOC HERE
 */
public class ComponentListenerTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel backPane = new JPanel();
        backPane.setBorder(BorderFactory.createLineBorder(Color.red));
        backPane.setLayout(new BoxLayout(backPane, BoxLayout.LINE_AXIS));
        backPane.add(new JLabel("hello"));

        backPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked back pane");
            }
        });
        backPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked back pane via listener 2");
            }
        });

        JPanel frontPane = new JPanel();
        frontPane.setBorder(BorderFactory.createLineBorder(Color.green));
        frontPane.setSize(200, 200);
        backPane.add(frontPane);
//        frontPane.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
////                System.out.println("clicked front pane");
//            }
//        });

        frame.setContentPane(backPane);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
