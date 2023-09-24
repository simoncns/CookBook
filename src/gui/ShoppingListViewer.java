package gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import data.Ingredient;
import data.Meal;
import data.Recipe;
import languageconversion.Language;
import shoppinglist.ShoppingListMeal;
import shoppinglist.ShoppingListRecipe;
import tools.FileIO;

/**
 * ShoppingListView GUI that prints the shopping list.
 * 
 * @author Max Adams and Nick Simoncelli
 * @version S1
 *
 */
public class ShoppingListViewer extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;

  private String serif = "Serif";
  private Font bodyFont = new Font(serif, Font.PLAIN, 20);
  private Font titleFont = new Font(serif, Font.BOLD, 40);

  private JTextField textField1 = new JTextField(10);
  private String textField1String;
  private JTextArea textArea = new JTextArea(10, 20);
  private String textAreaString;
  private Recipe recipe;
  private Meal meal;
  private List<String> ingredients;
  private JButton printButton;
  private JButton loadButton;
  private ShoppingListRecipe slRecipe;
  private ShoppingListMeal slMeal;
  private JPanel iconPanel;
  private final String es = "es";
  private final String newLine = "\n";
  private final String s = "%s";
  private ResourceBundle bundle = Language.getLanguageBundle();

  /**
   * ShoppingListViewer Constructor for making the GUI.
   */
  public ShoppingListViewer()
  {

    // System.out.println("Test");

    setTitle(bundle.getString("ShoppingListViewer.title"));
    //setTitle("KILowBites Shopping List Viewer");
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
    iconPanel = new JPanel(); // create new panel for icons
    iconPanel.setOpaque(false);
    ImageIcon icon1 = new ImageIcon(
        getClass().getClassLoader().getResource("baseline_print_black_24dp.png"));
    // ImageIcon icon1 = new ImageIcon("resources/baseline_print_black_24dp.png");
    Image img1 = icon1.getImage();
    Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon1 = new ImageIcon(newImg1);
    printButton = new JButton(newIcon1);
    // printButton.setActionCommand(printRecipeCommand);
    printButton.addActionListener(this);
    // printButton.setContentAreaFilled(false); // remove the button's default background color
    // printButton.setBorderPainted(false); // remove the button's border
    ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("open_icon.png"));
    // ImageIcon icon2 = new ImageIcon("resources/open_icon.png");
    Image img2 = icon2.getImage();
    Image newImg2 = img2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon2 = new ImageIcon(newImg2);
    loadButton = new JButton(newIcon2);
    // loadButton.setActionCommand(openRecipeCommand);
    loadButton.addActionListener(this);
    iconPanel.add(printButton);
    iconPanel.add(loadButton);
    topPanel.add(iconPanel); // add icon panel to top panel
    mainPanel.add(topPanel);

    // Middle Panel with text field
    JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    middlePanel.setOpaque(false);
    middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    JLabel label1 = new JLabel(bundle.getString("ShoppingListViewer.label1"));
    label1.setForeground(Color.WHITE);
    // JTextField textField1 = new JTextField(10);
    textField1.setEditable(false);
    middlePanel.add(label1);
    middlePanel.add(textField1);
    middlePanel.add(Box.createHorizontalStrut(20));
    mainPanel.add(middlePanel);

    // Bottom Panel with print section
    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.setOpaque(false);
    TitledBorder border = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE, 1, true),
        bundle.getString("ShoppingListViewer.border"));
    border.setTitleColor(Color.WHITE); // set title color to white
    bottomPanel.setBorder(border);
    // JTextArea textArea = new JTextArea(10, 20);
    // textArea.setText("toStringPrintHelp of recipe/meal ingredients then output each item");
    textArea.setLineWrap(true);
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    bottomPanel.add(scrollPane);
    mainPanel.add(bottomPanel);

    // add empty border to main panel
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    setContentPane(mainPanel);
  }

  @Override
  public void actionPerformed(final ActionEvent evt)
  {
    if (evt.getSource() == printButton)
    {
      if (recipe == null && meal == null)
      {
        JOptionPane.showMessageDialog(null, bundle.getString("ShoppingListViewer.Load"),
            bundle.getString("ShoppingListViewer.Error"), JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable()
        {
          @Override
          public int print(final Graphics g, final PageFormat pageFormat, final int pageIndex)
              throws PrinterException
          {
            if (pageIndex > 0)
              return NO_SUCH_PAGE;
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(titleFont);
            g2.setPaint(Color.black);
            g2.drawString(bundle.getString("ShoppingListViewer.border"), 180, 100);
            g2.setFont(bodyFont);
            int i = 0;
            for (String item : ingredients)
            {
              g2.drawString(item, 40, 150 + (i * 20));
              i++;
            }
            return PAGE_EXISTS;
          }
        });

        if (job.printDialog())
        {
          try
          {
            job.print();
          }
          catch (PrinterException e)
          {
            e.printStackTrace();
          }
        }
      }
    }
    if (evt.getSource() == loadButton)
    {
      JFileChooser fileChooser = new JFileChooser();
      String userHome = System.getProperty("user.home");
      fileChooser.setCurrentDirectory(new File(userHome));
      int result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION)
      {
        File file = fileChooser.getSelectedFile();
        Path path = Paths.get(file.getPath());
        String filename = file.getName();
        String extension = filename.substring(filename.length() - 3);
        if (extension.equals("mel"))
        {
          meal = FileIO.readMeal(path);
          slMeal = new ShoppingListMeal(meal.getRecipes());

          setTitle(meal.getName());
          textField1String = String.format(s, slMeal.getPeople());
          textField1.setText(textField1String);
          ingredients = slMeal.toStringPrintHelp();
          Collections.sort(ingredients);
          for (String ingredient : ingredients)
          {
            textAreaString += ingredient;
            textAreaString += newLine;
          }

          textArea.setText(slMeal.toString());

        }
        else if (extension.equals("rcp"))
        {
          recipe = FileIO.readRecipe(path);
          slRecipe = new ShoppingListRecipe(recipe);

          setTitle(recipe.getName());
          textField1String = String.format(s, recipe.getAmount());
          textField1.setText(textField1String);
          ingredients = slRecipe.toStringPrintHelp();
          Collections.sort(ingredients);
          for (String ingredient : ingredients)
          {
            textAreaString += ingredient;
            textAreaString += newLine;
          }
          textArea.setText(slRecipe.toString());

        }
        else
        {
          JOptionPane.showMessageDialog(null, bundle.getString("ShoppingListViewer.load2"),
              bundle.getString("ShoppingListViewer.LError"), JOptionPane.INFORMATION_MESSAGE);
        }
      }

    }
  }
}
