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
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import data.Ingredient;
import data.Meal;
import data.Recipe;
import data.Step;
import data.Utensil;
import languageconversion.Language;
import tools.FileIO;

/**
 * Class for ProcessViewer GUI.
 * 
 * @author Max Adams and Nick Simoncelli
 * @version S2
 *
 */
public class ProcessViewer extends JFrame implements ActionListener
{

  private static final long serialVersionUID = 1L;

  private String currentPath;
  private Recipe recipe;
  private Meal meal;
  private String serif = "Serif";
  private Font bodyFont = new Font(serif, Font.PLAIN, 20);
  private Font titleFont = new Font(serif, Font.BOLD, 40);
  private Font headerFont = new Font(serif, Font.BOLD, 20);

  private JTextArea textArea = new JTextArea(5, 20);
  private JTextArea textArea2 = new JTextArea(15, 50);
  private JButton printButton;
  private JButton loadButton;
  private List<Utensil> utensils = new ArrayList<>();
  private List<Step> steps = new ArrayList<>();
  private List<Ingredient> embeddedRecipes = new ArrayList<>();

  private final String es = "es";
  private final String toStringHelp = "%s\n";
  private ResourceBundle bundle = Language.getLanguageBundle();

  /**
   * ProcessViewer Constructor.
   */
  public ProcessViewer()
  {

    setTitle(bundle.getString("ProcessViewer.title"));
    // setTitle("KILowBites Process Viewer");
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(600, 500);
    setLocationRelativeTo(null);
    setVisible(true);

    JPanel mainPanel = new GradientPanel();

    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topPanel.setOpaque(false);
    JPanel iconPanel = new JPanel(); // create new panel for icons
    iconPanel.setOpaque(false);
    ImageIcon icon1 = new ImageIcon(
        getClass().getClassLoader().getResource("baseline_print_black_24dp.png"));
    // ImageIcon icon1 = new ImageIcon("resources/baseline_print_black_24dp.png");
    Image img1 = icon1.getImage();
    Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon1 = new ImageIcon(newImg1);
    printButton = new JButton(newIcon1);
    // button.setBorderPainted(false); // remove button border
    // button.setContentAreaFilled(false); // remove button background
    // button.setFocusPainted(false); // remove button focus border
    // button.setOpaque(false); // make button transparent
    ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("open_icon.png"));
    // ImageIcon icon2 = new ImageIcon("resources/open_icon.png");
    Image img2 = icon2.getImage();
    Image newImg2 = img2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newIcon2 = new ImageIcon(newImg2);
    loadButton = new JButton(newIcon2);
    iconPanel.add(printButton);
    iconPanel.add(loadButton);
    topPanel.add(iconPanel); // add icon panel to top panel
    mainPanel.add(topPanel);

    // Bottom Panel with print section
    JPanel middlePanel = new JPanel(new BorderLayout());
    middlePanel.setOpaque(false);
    TitledBorder border = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE, 1, true),
        bundle.getString("ProcessViewer.border"));
    border.setTitleColor(Color.WHITE); // set title color to white
    middlePanel.setBorder(border);
    // JTextArea textArea = new JTextArea(5, 20);
    // textArea.setText("toString of each utensils from editors");
    textArea.setLineWrap(true);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    middlePanel.add(scrollPane);
    mainPanel.add(middlePanel);

    // Bottom panel with text fields
    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.setOpaque(false);
    TitledBorder border2 = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE, 1, true),
        bundle.getString("ProcessViewer.border2"));
    border2.setTitleColor(Color.WHITE);
    bottomPanel.setBorder(border2);
    // JTextArea textArea2 = new JTextArea(15, 50);
    // textArea2.setText("toStringPrintHelp the output each item");
    loadButton.addActionListener(this);
    printButton.addActionListener(this);
    textArea2.setLineWrap(true);
    textArea2.setWrapStyleWord(true);
    textArea2.setEditable(false);
    textArea.setEditable(false);
    JScrollPane scrollPane2 = new JScrollPane(textArea2);
    scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    bottomPanel.add(scrollPane2, BorderLayout.CENTER);
    mainPanel.add(bottomPanel);

    // Add all panels to main panel
    mainPanel.add(Box.createVerticalStrut(10));
    mainPanel.add(topPanel);
    mainPanel.add(middlePanel);
    mainPanel.add(Box.createVerticalStrut(10));
    mainPanel.add(bottomPanel);
    mainPanel.add(Box.createVerticalGlue());

    // Set content pane
    setContentPane(mainPanel);

  }

  @Override
  public void actionPerformed(final ActionEvent evt)
  {
    if (evt.getSource() == printButton)
    {
      if (recipe == null && meal == null)
      {
        JOptionPane.showMessageDialog(null, bundle.getString("ProcessViewer.Load"),
            bundle.getString("ProcessViewer.Error"), JOptionPane.INFORMATION_MESSAGE);
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
            g2.drawString(bundle.getString("ProcessViewer.drawString"), 140, 100);
            g2.setFont(headerFont);
            g2.drawString(bundle.getString("ProcessViewer.border"), 40, 150);
            g2.setFont(bodyFont);
            int i = 1;
            for (Utensil u : utensils)
            {
              g2.drawString(u.toString(), 40, 150 + (i * 20));
              i++;
            }
            g2.setFont(headerFont);
            g2.drawString(bundle.getString("ProcessViewer.border2"), 40, 170 + (i * 20));
            i++;
            g2.setFont(bodyFont);
            for (Step s : steps)
            {
              g2.drawString(s.toString(), 40, 170 + (i * 20));
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
        if (extension.equals("rcp"))
        {
          recipe = FileIO.readRecipe(path);
          for (Ingredient i : recipe.getIngredient())
          {
            if (i.getRecipe() != null)
            {
              embeddedRecipes.add(i);
            }
          }
          setTitle(recipe.getName());
          String utensilText = "";
          for (Utensil u : recipe.getUtensils())
          {
            utensils.add(u);
            utensilText += String.format(toStringHelp, u.toString());
            // utensilText += u.toString();
          }
          textArea.setText(utensilText);
          String stepText = "";
          for (Step s : recipe.getSteps())
          {
            steps.add(s);
            stepText += String.format(toStringHelp, s.toString());
            // stepText += u.toString();
          }
          textArea2.setText(stepText);
        }
        else if (extension.equals("mel"))
        {
          meal = FileIO.readMeal(path);
          for (Recipe r : meal.getRecipes())
          {
            for (Ingredient i : r.getIngredient())
            {
              if (i.getRecipe() != null)
              {
                embeddedRecipes.add(i);
              }
            }
          }
          setTitle(meal.getName());
          for (Recipe r : meal.getRecipes())
          {
            for (Utensil u : r.getUtensils())
            {
              if (!utensils.contains(u))
              {
                utensils.add(u);
              }
            }
          }
          String utensilText = "";
          for (Utensil u : utensils)
          {
            utensilText += String.format(toStringHelp, u.toString());
            // utensilText += u.toString();
          }
          textArea.setText(utensilText);
          String stepText = "";
          for (Recipe r : meal.getRecipes())
          {
            for (Step step : r.getSteps())
            {
              steps.add(step);
            }
          }
          for (Step u : steps)
          {
            stepText += String.format(toStringHelp, u.toString());
            // stepText += u.toString();
          }
          textArea2.setText(stepText);
        }
        else
        {
          JOptionPane.showMessageDialog(null, bundle.getString("ProcessViewer.load2"),
              bundle.getString("ProcessViewer.LError"), JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }
  }
}
