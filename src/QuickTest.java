import GUI.ICSEBug;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by nzheng on 28-Nov-2017.
 */
public class QuickTest {

    static final NumberFormat englishFormatter = NumberFormat.getInstance(Locale.CANADA);
    static final NumberFormat germanFormatter = NumberFormat.getInstance(Locale.GERMAN);
    static final NumberFormat frenchFormatter = NumberFormat.getInstance(Locale.FRANCE);

    public static void main(String[] args) {
        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do nothing
            }
        };

        ICSEBug bug = new ICSEBug();

        System.out.println(action.getClass().getName());
        System.out.println(bug.getClass().getName());

    }

    private static void printParseResult(String string) {
        System.out.print("Parsing " + string);
        try {
            System.out.print(" English = " + englishFormatter.parse(string).doubleValue());
        } catch (ParseException e) {
            System.out.print(" Failed to parse " + string + " in English");
        }

        try {
            System.out.print(" German = " + germanFormatter.parse(string).doubleValue());
        } catch (ParseException e) {
            System.out.print("Failed to parse " + string + " in German");
        }

        try {
            System.out.print(" French = " + frenchFormatter.parse(string).doubleValue());
        } catch (ParseException e) {
            System.out.print("Failed to parse " + string + " in French");
        }

        System.out.println();
    }
}
