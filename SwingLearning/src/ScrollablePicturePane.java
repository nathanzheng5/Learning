import javax.swing.*;
import java.awt.*;

public class ScrollablePicturePane extends JPanel implements Scrollable {

    ImageIcon imageIcon;

    public ScrollablePicturePane(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;

        setAutoscrolls(true);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(new JLabel(imageIcon));
//        add(new JLabel(imageIcon));
    }

    public void addImageIcon() {
        add(new JLabel(imageIcon));
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 1;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 1;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
