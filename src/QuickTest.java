import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class QuickTest {

    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(800, 600);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        JPanel child = new JPanel();
        child.setBorder(BorderFactory.createLineBorder(Color.RED));
        child.setLayout(new BoxLayout(child, BoxLayout.PAGE_AXIS));
        child.add(new JLabel("hello"));
        child.add(new JLabel("world"));
        JPanel child2 = new JPanel();
        child2.setBorder(BorderFactory.createLineBorder(Color.RED));
        child2.setLayout(new BoxLayout(child2, BoxLayout.PAGE_AXIS));
        child2.add(new JLabel("hello"));
        child2.add(new JLabel("world2"));
//        scrollPane.add(child);

        frame.setContentPane(panel);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        scrollPane.getViewport().add(child);
        scrollPane.getViewport().add(child2);

//        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



}
