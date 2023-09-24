package gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import data.Recipe;
import languageconversion.Language;

/**
 * Shortcuts GUI for display the default shortcuts the user can use.
 * 
 * @author Max Adams
 * @version S2
 */
public class Shortcuts extends JFrame
{
  private static final long serialVersionUID = 1L;

  /**
   * Shortcuts Constructor for making the GUI.
   */
  public Shortcuts()
  {
    ResourceBundle bundle = Language.getLanguageBundle();

    setTitle(bundle.getString("Shortcuts.title"));
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(600, 400);
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
    ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("close_icon.png"));
    //ImageIcon icon1 = new ImageIcon("resources/close_icon.png");
    Image img1 = icon1.getImage();
    Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon1 = new ImageIcon(newImg1);
    JButton closeButton = new JButton(newIcon1);
    // printButton.setContentAreaFilled(false); // remove the button's default background color
    // printButton.setBorderPainted(false); // remove the button's border

    iconPanel.add(closeButton);
    topPanel.add(iconPanel); // add icon panel to top panel
    mainPanel.add(topPanel);

    // Bottom Panel with print section
    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.setOpaque(false);
    TitledBorder border = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE, 1, true), bundle.getString("Shortcuts.Label1"));
    border.setTitleColor(Color.WHITE); // set title color to white
    bottomPanel.setBorder(border);
    JTextArea textArea = new JTextArea(10, 20);
    textArea
        .setText("Exit: CTRL + X\nRecipe: CTRL + R\nMeal: CTRL + M\nAdd Ingredients: CTRL + A\n"
               + "Recipes: ALT + R\nMeals: ALT + M\nShopping List: CTRL + S\n"
               + "Process: CTRL + P\nCalorie Calculator: CTRL + C\nUnit Converter: CTRL + U\n"
               + "Preferences: ALT + P\nShortcuts: ALT + S\nNutrition: CTRL + N\n"
               + "About: ALT + A\nUser Guide: CTRL + U\n");
    textArea.setLineWrap(true);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    bottomPanel.add(scrollPane);
    mainPanel.add(bottomPanel);

    // add empty border to main panel
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    setContentPane(mainPanel);
  }

}
