package Locale.package1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

/**
 * Created by NZheng on 09-Mar-2018.
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle text = ResourceBundle.getBundle("package2/text");
        System.out.println(text.getString("hello"));

    }
}
