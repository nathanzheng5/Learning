import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class QuickTest {

    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        System.out.println(now);

        final int dayOfMonth = now.getDayOfMonth();
        System.out.println("Day of month = " + dayOfMonth);

        final LocalDate beginningOfMonth = now.withDayOfMonth(1);
        System.out.println("Beginning = " + beginningOfMonth);

        final LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());
        System.out.println("End of month = " + endOfMonth);

        final DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("Day of week " + dayOfWeek);

        TemporalField fieldHere = WeekFields.of(Locale.CANADA).dayOfWeek();
        final LocalDate beginningOfWeek = now.with(fieldHere, 1);
        System.out.println("Beginning of week " + beginningOfWeek);
        final LocalDate endOfWeek = now.with(fieldHere, 7);
        System.out.println("End of week " + endOfWeek);

        final LocalDate date = LocalDate.of(2018, 3, 30);
        final LocalDate localDate = date.minusMonths(1);
        System.out.println(localDate);

    }

}
