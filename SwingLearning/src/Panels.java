import javax.swing.*;

/**
 * TODO: CLASS JAVA DOC HERE
 */
public class Panels {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(800, 600);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));

        JLabel label1 = new JLabel("label 1");
        JLabel label2 = new JLabel("label 2");

//        JPanel subPanel = createSubPanel();

        mainPanel.add(createSubPanel(label1, label2));
        mainPanel.add(new JSeparator(SwingConstants.VERTICAL));
        mainPanel.add(createSubPanel(label1, label2));

        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel createSubPanel(JLabel label1, JLabel label2) {
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));
        subPanel.add(label1);
        subPanel.add(label2);
        return subPanel;
    }


}
