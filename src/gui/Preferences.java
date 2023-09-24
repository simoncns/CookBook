package gui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import languageconversion.Language;

/**
 * Preferences GUI that allows the user to select their own loading preferences. calories
 * 
 * @author Max Adams
 * @version S2
 *
 */
public class Preferences extends JFrame
{

  private static final long serialVersionUID = 1L;
  private HashMap<String, String> userPreferences = new HashMap<>();

  /**
   * Preferences constructor for making the GUI.
   */
  public Preferences()
  {

    ResourceBundle bundle = Language.getLanguageBundle();

    setTitle(bundle.getString("Preferences.title"));
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(400, 650);
    setLocationRelativeTo(null);
    setVisible(true);

    // Create main panel with gradient green background
    JPanel mainPanel = new GradientPanel();

    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topPanel.setOpaque(false);

    JPanel iconPanel = new JPanel();
    iconPanel.setOpaque(false);

    // Create the first button
    ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("save_icon.png"));
    //ImageIcon icon1 = new ImageIcon("resources/save_icon.png");
    Image img1 = icon1.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon1 = new ImageIcon(img1);
    JButton button1 = new JButton(newIcon1);

    // Add the buttons to the icon panel
    iconPanel.add(button1);

    // Add the icon panel to the top panel
    topPanel.add(iconPanel);

    // Add the top panel to the main panel
    mainPanel.add(topPanel);

    // Read user preferences from file, if it exists
    File file = new File("userPreferences.cfg");
    if (file.exists())
    {
      try (Scanner scanner = new Scanner(file))
      {
        while (scanner.hasNextLine())
        {
          String line = scanner.nextLine();
          String[] parts = line.split("=");
          if (parts.length == 2)
          {
            String label = parts[0];
            String shortcut = parts[1];
            userPreferences.put(label, shortcut);
          }
        }
      }
      catch (FileNotFoundException e)
      {
        // handle exception
      }
    }

    // Create the modifier and key JComboBoxes for each label
    JComboBox<String>[] modifierComboBoxes = new JComboBox[12];
    JComboBox<String>[] keyComboBoxes = new JComboBox[12];

    // Create an array of default keyboard shortcuts for each label
    String[] defaultShortcuts = {"CTRL+X", "CTRL+R", "CTRL+M", "ALT+R", "ALT+M", "CTRL+S", "CTRL+P",
        "CTRL+C", "CTRL+U", "ALT+P", "ALT+S", "ALT+U"};

    JLabel[] labels = {new JLabel(bundle.getString("Preferences.ExitLabel")),
        new JLabel(bundle.getString("Preferences.RecipeLabel")),
        new JLabel(bundle.getString("Preferences.MealLabel")),
        new JLabel(bundle.getString("Preferences.RecipesLabel")),
        new JLabel(bundle.getString("Preferences.MealsLabel")),
        new JLabel(bundle.getString("Preferences.ShoppingListLabel")),
        new JLabel(bundle.getString("Preferences.ProcessLabel")),
        new JLabel(bundle.getString("Preferences.CalorieCalculatorLabel")),
        new JLabel(bundle.getString("Preferences.UnitsConverterLabel")),
        new JLabel(bundle.getString("Preferences.PreferencesLabel")),
        new JLabel(bundle.getString("Preferences.ShortcutsLabel")),
        new JLabel(bundle.getString("Preferences.UserGuideLabel"))};

    // Set the foreground color of each label to white
    for (JLabel label : labels)
    {
      label.setForeground(Color.WHITE);
    }

    // Middle panel with combo boxes
    JPanel middlePanel = new JPanel(new GridLayout(14, 3, 10, 10));
    middlePanel.setOpaque(false);
    middlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Loop through the labels and add them to the panel along with JComboBoxes
    for (int i = 0; i < labels.length; i++)
    {
      JLabel label = labels[i];
      middlePanel.add(label);
      JComboBox<String> modifierComboBox = new JComboBox<>(new String[] {"CTRL", "ALT"});
      JComboBox<String> keyComboBox = new JComboBox<>(new String[] {"A", "B", "C", "D", "E", "F",
          "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
          "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
      String shortcut = userPreferences.get(label.getText());
      if (shortcut != null && shortcut.matches("^(CTRL|ALT)\\+[A-Z1-9]$"))
      {
        // If the user-defined shortcut is valid, use it
        modifierComboBox.setSelectedItem(shortcut.substring(0, 4));
        keyComboBox.setSelectedItem(shortcut.substring(4));
      }
      else
      {
        // Otherwise, use the default shortcut
        modifierComboBox.setSelectedItem(defaultShortcuts[i].substring(0, 4));
        keyComboBox.setSelectedItem(defaultShortcuts[i].substring(5));
      }
      modifierComboBoxes[i] = modifierComboBox;
      keyComboBoxes[i] = keyComboBox;
      middlePanel.add(modifierComboBox);
      middlePanel.add(keyComboBox);
    }

    button1.addActionListener(e -> {
      // Update the user preferences HashMap with the values from the JComboBoxes
      for (int i = 0; i < labels.length; i++)
      {
        String label = labels[i].getText();
        String modifier = (String) modifierComboBoxes[i].getSelectedItem();
        String key = (String) keyComboBoxes[i].getSelectedItem();
        if (modifier != null && key != null)
        {
          userPreferences.put(label, modifier + key);
        }
      }

      // Write the updated user preferences to a file
      try
      {
        FileWriter writer = new FileWriter("userPreferences.cfg");
        for (String label : userPreferences.keySet())
        {
          writer.write(label + "=" + userPreferences.get(label) + "\n");
        }
        writer.close();
        JOptionPane.showMessageDialog(null, (bundle.getString("Preferences.Save")));
      }
      catch (IOException ex)
      {
        JOptionPane.showMessageDialog(null, (bundle.getString("Preferences.Error")));
      }

    });

    // Panel to add padding
    JPanel paddingPanel = new JPanel();
    paddingPanel.setOpaque(false);
    paddingPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

    // Add all panels to main panel
    mainPanel.add(middlePanel);
    mainPanel.add(Box.createVerticalStrut(10));
    mainPanel.add(paddingPanel);

    // update layout of middle and bottom panels
    JPanel middleBottomPanel = new JPanel();
    middleBottomPanel.setOpaque(false);
    middleBottomPanel.setLayout(new BoxLayout(middleBottomPanel, BoxLayout.Y_AXIS));
    middleBottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    middleBottomPanel.add(middlePanel);
    middleBottomPanel.add(Box.createVerticalStrut(10)); // add vertical spacing

    // add middle and bottom panels to main panel
    mainPanel.add(middleBottomPanel);

    // Panel to add padding
    mainPanel.add(Box.createVerticalGlue()); // add vertical spacing

    // Set content pane
    setContentPane(mainPanel);

  }

  /**
   * Method for handling the various keyboard shortcuts.
   * 
   * @param event
   */
  @SuppressWarnings("unused")
  private void handleKeyboardShortcut(final KeyEvent event)
  {
    String shortcut = KeyEvent.getKeyText(event.getKeyCode());
    for (HashMap.Entry<String, String> entry : userPreferences.entrySet())
    {
      if (entry.getValue().equals(shortcut))
      {
        String label = entry.getKey();
        // Do something with the label
        break;
      }
    }
  }

}
