package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
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
import tools.Conversions;
import tools.Mass;
import tools.Measurements;
import tools.Volume;

/**
 * UnitConverter GUI that takes in units, ingredients, amounts, and prints an amount.
 * 
 * @author Max Adams
 * @version S1
 *
 */
public class UnitConverter extends JFrame
{

  private static final long serialVersionUID = 1L;

  /**
   * UnitConverter constructor for making the GUI.
   */
  public UnitConverter()
  {
    ResourceBundle bundle = Language.getLanguageBundle();

    setTitle(bundle.getString("UnitConverter.title"));
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(600, 200);
    setLocationRelativeTo(null);
    setVisible(true);

    // Create main panel with gradient green background
    JPanel mainPanel = new GradientPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    // Top panel with icons
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topPanel.setOpaque(false);

    JPanel iconPanel = new JPanel(); // create new panel for icons
    iconPanel.setOpaque(false);

    ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("baseline_calculate_black_24dp.png"));
    //ImageIcon icon1 = new ImageIcon("resources/baseline_calculate_black_24dp.png");
    Image newImg1 = icon1.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon1 = new ImageIcon(newImg1);
    JButton button1 = new JButton(newIcon1);
    // button1.setBorder(BorderFactory.createEmptyBorder()); // remove the button border
    // button1.setContentAreaFilled(false); // remove the button background
    // button1.setFocusPainted(false); // remove the button focus border
    button1.addActionListener(e -> {
      // add the action that will be performed when the button is clicked
    });

    ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("baseline_restart_alt_black_24dp.png"));
    //ImageIcon icon2 = new ImageIcon("resources/baseline_restart_alt_black_24dp.png");
    Image newImg2 = icon2.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon2 = new ImageIcon(newImg2);
    JButton button2 = new JButton(newIcon2);
    // button2.setBorder(BorderFactory.createEmptyBorder()); // remove the button border
    // button2.setContentAreaFilled(false); // remove the button background
    // button2.setFocusPainted(false); // remove the button focus border

    // button2.addActionListener(e -> {
    // convert(label1, comboBox1, comboBox2);
    //
    // });

    // Add the buttons to the icon panel
    iconPanel.add(button1);
    iconPanel.add(button2);

    topPanel.add(iconPanel); // add icon panel to top panel
    mainPanel.add(topPanel);

    // Middle panel with combo boxes
    JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    middlePanel.setOpaque(false);
    middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    JLabel label1 = new JLabel(bundle.getString("UnitConverter.label1"));
    label1.setForeground(Color.WHITE);
    JComboBox<Measurements> comboBox1 = new JComboBox<>(Measurements.values());
    JLabel label2 = new JLabel(bundle.getString("UnitConverter.label2"));
    label2.setForeground(Color.WHITE);
    JComboBox<Measurements> comboBox2 = new JComboBox<>(Measurements.values());
    JLabel label3 = new JLabel(bundle.getString("UnitConverter.label3"));
    label3.setForeground(Color.WHITE);

    JComboBox<Ingredients> comboBox3 = new JComboBox<>(Ingredients.values());

    for (JComboBox<?> comboBox : new JComboBox<?>[] {comboBox1, comboBox2, comboBox3})
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
    JLabel label4 = new JLabel(bundle.getString("UnitConverter.label4"));
    label4.setForeground(Color.WHITE);
    JTextField textField4 = new JTextField(10);
    JLabel label5 = new JLabel(bundle.getString("UnitConverter.label5"));
    label5.setForeground(Color.WHITE);
    JTextField textField5 = new JTextField(10);
    bottomPanel.add(label4);
    bottomPanel.add(textField4);
    bottomPanel.add(Box.createHorizontalStrut(20));
    bottomPanel.add(label5);
    bottomPanel.add(textField5);

    button1.addActionListener(e -> {

      Mass sti = Mass.fromString(comboBox1.getSelectedItem().toString());
      Mass fyi = Mass.fromString(comboBox2.getSelectedItem().toString());
      String end = "0";

      Ingredients bi = Ingredients.fromCode(comboBox3.getSelectedItem().toString());
      Volume vl = Volume.fromString(comboBox1.getSelectedItem().toString());
      Volume va = Volume.fromString(comboBox2.getSelectedItem().toString());

      try
      {
        Double d = Double.parseDouble(textField4.getText());
      }
      catch (NumberFormatException ie)
      {
        textField4.setText(bundle.getString("UnitConverter.Invalid"));
        JOptionPane.showMessageDialog(null, bundle.getString("UnitConverter.Invalid2"),
            bundle.getString("UnitConverter.Error"), JOptionPane.ERROR_MESSAGE);
        textField5.setText("");
        return;
      }

      if (sti != null && fyi != null)
      {
        end = Conversions.convert(Double.parseDouble(textField4.getText()), sti, fyi);

      }

      if (bi != null)
      {

        if (vl != null && fyi != null)
        {
          end = Conversions.convert(Double.parseDouble(textField4.getText()), vl, fyi, bi);
        }

        if (sti != null && va != null)
        {
          end = Conversions.convert(Double.parseDouble(textField4.getText()), sti, va, bi);
        }
      }

      if (vl != null && va != null)
      {
        end = Conversions.convert(Double.parseDouble(textField4.getText()), vl, va);
      }

      textField5.setText(end);

    });
    
    textField5.setEditable(false);
    
    button2.addActionListener(e -> {
      textField5.setText("");
      textField4.setText("");
    });

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
