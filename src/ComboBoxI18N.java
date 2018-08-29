import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;

/**
 * Created by nzheng on 25-Jan-2018.
 */
public class ComboBoxI18N {

    enum Animal {
        Tiger("A tiger"),
        Snake("A snake"),
        Dragon("A dragon");

        private final String name;
        Animal(String name) {
            this.name = name;
        }

//        @Override
//        public String toString() {
//            return name;
//        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);

        JComboBox<Animal> comboBox = new JComboBox<>(new DefaultComboBoxModel<>(Animal.values()));
        comboBox.setRenderer(new AnimalListCellRenderer());
        panel.add(comboBox);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    static class AnimalListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Animal) {
                value = ((Animal) value).name;
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }
}
