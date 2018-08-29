package Tools;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by nzheng on 15-Nov-2017.
 */
public class CleanCanopusLogs extends JFrame {
    private JComboBox<String> branchComboBox;
    private JButton cleanButton;
    private JPanel topPanel;

    public CleanCanopusLogs() {
        setTitle("Clean Canopus Logs");
        setContentPane(topPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Map<String, String[]> branchMaps = new LinkedHashMap<>();
        branchMaps.put("ALL", new String[]{
                "D:\\proj\\Branches\\Users\\nzheng\\Main\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Users\\nzheng\\Main\\Canopus\\build\\userPreferences",

                "D:\\proj\\Branches\\Users\\nzheng\\GC3P3\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Users\\nzheng\\GC3P3\\Canopus\\build\\userPreferences",

                "D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch2\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch2\\Canopus\\build\\userPreferences",

                "D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch3\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch3\\Canopus\\build\\userPreferences",

                "D:\\proj\\Main\\Canopus\\build\\logFiles",
                "D:\\proj\\Main\\Canopus\\build\\userPreferences"
        });

        branchMaps.put("NZ Main", new String[]{"D:\\proj\\Branches\\Users\\nzheng\\Main\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Users\\nzheng\\Main\\Canopus\\build\\userPreferences"});
        branchMaps.put("NZ GC3P3", new String[]{"D:\\proj\\Branches\\Users\\nzheng\\GC3P3\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Users\\nzheng\\GC3P3\\Canopus\\build\\userPreferences"});
        branchMaps.put("Release GC3P2", new String[]{"D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch2\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch2\\Canopus\\build\\userPreferences"});
        branchMaps.put("Release GC3P3", new String[]{"D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch3\\Canopus\\build\\logFiles",
                "D:\\proj\\Branches\\Release\\Canopus\\GC3_1.8_Patch3\\Canopus\\build\\userPreferences"});
        branchMaps.put("Main", new String[]{"D:\\proj\\Main\\Canopus\\build\\logFiles",
                "D:\\proj\\Main\\Canopus\\build\\userPreferences"});

        branchMaps.keySet().forEach(branchComboBox::addItem);

        cleanButton.addActionListener(e -> {
            String branchKey = (String) branchComboBox.getSelectedItem();
            String[] directories = branchMaps.get(branchKey);
            List<String> succeeded = new ArrayList<>();
            List<String> failed = new ArrayList<>();
            List<String> ignored = new ArrayList<>();
            for (String directory : directories) {
                File logFileDirectory = new File(directory);

                if (!logFileDirectory.exists() || !logFileDirectory.isDirectory()) {
                    ignored.add(logFileDirectory.toString());
                } else {
                    try {
                        FileUtils.deleteDirectory(logFileDirectory);
                        succeeded.add(logFileDirectory.toString());
                    } catch (IOException e1) {
                        failed.add(logFileDirectory.toString());
                    }
                }
            }

            // build summary
            StringBuilder summary = new StringBuilder();
            if (!succeeded.isEmpty()) {
                summary.append("\n\nDeleted: ");
                succeeded.forEach(dir -> summary.append("\n").append(dir));
            }
            if (!failed.isEmpty()) {
                summary.append("\n\nFailed to delete: ");
                failed.forEach(dir -> summary.append("\n").append(dir));
            }
            if (!ignored.isEmpty()) {
                summary.append("\n\nIgnored: ");
                ignored.forEach(dir -> summary.append("\n").append(dir));
            }

            JOptionPane.showMessageDialog(null, "Done! Summary: " + summary);
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new CleanCanopusLogs();
    }
}
