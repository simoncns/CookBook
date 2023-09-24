package gui;

import java.awt.Color;


import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Image;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;

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
import javax.swing.JTextField;

import enums.Ingredients;
import languageconversion.Language;
import tools.CalorieCount;
import tools.Conversions;
import tools.Mass;
import tools.Measurements;
import tools.Volume;

/**
 * Calorie Calculator GUI that takes in ingredients, amounts, and units. and outputs the amount of.
 * calories
 * 
 * @author Max Adams
 * @version S1
 *
 */
public class CalorieCalculator extends JFrame
{

  private static final long serialVersionUID = 1L;

  /**
   * CalorieCalculator constructor for making the GUI.
   */
  public CalorieCalculator()
  {
    ResourceBundle bundle = Language.getLanguageBundle();
    setTitle(bundle.getString("CalorieCalculator.title"));
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(700, 200);
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
    ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("baseline_calculate_black_24dp.png"));
    //ImageIcon icon1 = new ImageIcon("resources/baseline_calculate_black_24dp.png");
    Image img1 = icon1.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon1 = new ImageIcon(img1);
    JButton button1 = new JButton(newIcon1);

    // Create the second button
    ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("baseline_restart_alt_black_24dp.png"));
    //ImageIcon icon2 = new ImageIcon("resources/baseline_restart_alt_black_24dp.png");
    Image img2 = icon2.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon2 = new ImageIcon(img2);
    JButton button2 = new JButton(newIcon2);

    // Add the buttons to the icon panel
    iconPanel.add(button1);
    iconPanel.add(button2);

    // Add the icon panel to the top panel
    topPanel.add(iconPanel);

    // Add the top panel to the main panel
    mainPanel.add(topPanel);

    // Middle panel with combo boxes
    JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    middlePanel.setOpaque(false);
    middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    JLabel label1 = new JLabel(bundle.getString("CalorieCalculator.label1"));
    label1.setForeground(Color.WHITE);
    JComboBox<Ingredients> comboBox1 = new JComboBox<>(Ingredients.values());
    JLabel label2 = new JLabel(bundle.getString("CalorieCalculator.label2"));
    label2.setForeground(Color.WHITE);
    JTextField comboBox2 = new JTextField(10);
    JLabel label3 = new JLabel(bundle.getString("CalorieCalculator.label3"));
    label3.setForeground(Color.WHITE);
    JComboBox<Measurements> comboBox3 = new JComboBox<>(Measurements.values());

    for (JComboBox<?> comboBox : new JComboBox<?>[] {comboBox1, comboBox3})
    {
      comboBox.setPreferredSize(new Dimension(90, comboBox.getPreferredSize().height));
    }

    middlePanel.add(label1);
    middlePanel.add(comboBox1);
    middlePanel.add(Box.createHorizontalStrut(20));
    middlePanel.add(label2);
    middlePanel.add(comboBox2);
    middlePanel.add(Box.createHorizontalStrut(20));
    middlePanel.add(label3);
    middlePanel.add(comboBox3);

    // Bottom panel with text fields
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.setOpaque(false);
    bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 200, 0));
    JLabel label4 = new JLabel(bundle.getString("CalorieCalculator.label4"));
    label4.setForeground(Color.WHITE);
    JTextField textField4 = new JTextField(10);
    bottomPanel.add(label4);
    bottomPanel.add(textField4);

    button1.addActionListener(e -> {

      Mass sti = Mass.fromString(comboBox3.getSelectedItem().toString());
      String end = "0";
      Volume vl = Volume.fromString(comboBox3.getSelectedItem().toString());
      Ingredients bi = Ingredients.fromCode(comboBox1.getSelectedItem().toString());

      try
      {
        Double d = Double.parseDouble(comboBox2.getText());
      }
      catch (NumberFormatException ie)
      {
        comboBox2.setText(bundle.getString("CalorieCalculator.Invalid"));
        JOptionPane.showMessageDialog(null, bundle.getString("CalorieCalculator.Invalid2"),
            bundle.getString("CalorieCalculator.Error"), JOptionPane.ERROR_MESSAGE);
        textField4.setText("");
        return;
      }
      Double d = Double.parseDouble(comboBox2.getText());
      Double helper = 0.0;
      String hi = "";

      Mass grams = Mass.GRAMS;
      if (d != null)
      {
        if (sti != null)
        {
          hi = Conversions.cepll(d, sti, grams);
          // System.out.print(hi);
          helper = CalorieCount.calorieCount(bi, Double.parseDouble(hi));
          // System.out.print(helper);
        }
        else
        {
          hi = Conversions.cepll(d, vl, grams, bi);
          helper = CalorieCount.calorieCount(bi, Double.parseDouble(hi));

        }

        end = String.format("%.2f", helper);
      }
      textField4.setText(end);

    });

    button2.addActionListener(e -> {
      textField4.setText("");
      comboBox2.setText("");
    });
    
    textField4.setEditable(false);

    // Panel to add padding
    JPanel paddingPanel = new JPanel();
    paddingPanel.setOpaque(false);
    paddingPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

    // Add all panels to main panel
    mainPanel.add(middlePanel);
    mainPanel.add(Box.createVerticalStrut(10));
    mainPanel.add(bottomPanel);
    mainPanel.add(paddingPanel);

    // update layout of middle and bottom panels
    JPanel middleBottomPanel = new JPanel();
    middleBottomPanel.setOpaque(false);
    middleBottomPanel.setLayout(new BoxLayout(middleBottomPanel, BoxLayout.Y_AXIS));
    middleBottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    middleBottomPanel.add(middlePanel);
    middleBottomPanel.add(Box.createVerticalStrut(10)); // add vertical spacing
    middleBottomPanel.add(bottomPanel);

    // add middle and bottom panels to main panel
    mainPanel.add(middleBottomPanel);

    // Panel to add padding
    mainPanel.add(Box.createVerticalGlue()); // add vertical spacing

    // Set content pane
    setContentPane(mainPanel);
  }
}
