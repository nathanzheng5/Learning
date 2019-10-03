import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class QuickTest {

    public static void main(String[] args) throws ParseException {
        System.out.println(MessageFormat.format("{0,number,#.#}", 1.0));
        System.out.println(new DecimalFormat("#.###").format(-0.5123));

    }



}
