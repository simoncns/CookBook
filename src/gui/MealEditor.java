package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import data.Ingredient;
import data.Meal;
import data.Recipe;
import data.Step;
import data.Utensil;
import languageconversion.Language;
import tools.FileIO;

/**
 * meal and utensils.
 * 
 * @author Patrick Dodds
 * @version 4/3/22
 *
 */
public class MealEditor extends JFrame implements ActionListener
{

  private static final long serialVersionUID = 1L;

  // Panel size
  private final int panelHeight = 275;
  private final int panelWidth = 600;

  // Panel Dimensions
  private Dimension panelSize = new Dimension(panelWidth, panelHeight);
  private Dimension iconPanelDimension = new Dimension(500, 70);
  private Dimension buttonDimension = new Dimension(50, 50);
  private Dimension scrollPanelDimension = new Dimension(555, 190);
  private Dimension deleteButtonDimension = new Dimension(100, 190);

  // Icon Panel Buttons
  private JButton newButton;
  private JButton openButton;
  private JButton saveButton;
  private JButton saveAsButton;
  private JButton closeButton;

  // Icon Action Commands
  private final String newMealCommand = "NEW";
  private final String openMealCommand = "OPEN";
  private final String saveMealCommand = "SAVE";
  private final String saveAsMealCommand = "SAVEAS";
  private final String closeMealCommand = "CLOSE";

  // Labels for Buttons.
  private final String add = " Add Recipe";
  private final String addRecipeCommand = "UTENSIL";
  private final String delete = "Delete";
  private DefaultListModel<String> RecipeModel;
  private JList<String> RecipeDisplay;
  private final String deleteRecipeCommand = "D_RECIPE";

  // Recipe Name Panel
  private JTextField mealNameField;
  private final String name = "Name:";

  private Locale userLocale = Locale.getDefault();
  private ResourceBundle bundle;

  // Path for Meal Saves
  private final String defaultDirectory = "/KiloBites/saves/meals";
  private final String userHome = System.getProperty("user.home");
  private Path currentPath;
  private final Path defaultPath;
  private String currentFilename;
  private final String recipeDirectory = "/KiloBites/saves/recipes";

  private final String mealFileExtension = ".mel";

  private final String slash = "\\";

  // List of recipes
  private List<Recipe> recipes;

  public MealEditor()
  {
    // Set Path
    defaultPath = Paths.get(System.getProperty("user.home") + "/KiloBites/saves/meals");
    currentPath = Paths.get("");
    currentFilename = "";
    
    bundle = Language.getLanguageBundle();

    setTitle("KILowBites Meal Editor");

    recipes = new ArrayList<>();

    // Build Frame
    JPanel contentPane = new GradientPanel();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
    contentPane.add(createIconPanel());
    contentPane.add(createNamePanel());
    contentPane.add(createRecipePanel());

    setContentPane(contentPane);
    pack();
    setVisible(true);
  }

  private JPanel createIconPanel()
  {
    JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    iconPanel.setOpaque(false);
    iconPanel.setPreferredSize(iconPanelDimension);

    ImageIcon newIcon = new ImageIcon(getClass().getClassLoader().getResource("new_icon.png"));
    // ImageIcon newIcon = new ImageIcon("resources/new_icon.png");
    newButton = new JButton(newIcon);
    newButton.setActionCommand(newMealCommand);
    newButton.addActionListener(this);
    newButton.setPreferredSize(buttonDimension);

    ImageIcon openIcon = new ImageIcon(getClass().getClassLoader().getResource("open_icon.png"));
    // ImageIcon openIcon = new ImageIcon("resources/open_icon.png");
    openButton = new JButton(openIcon);
    openButton.setActionCommand(openMealCommand);
    openButton.addActionListener(this);
    openButton.setPreferredSize(buttonDimension);

    ImageIcon saveIcon = new ImageIcon(getClass().getClassLoader().getResource("save_icon.png"));
    // ImageIcon saveIcon = new ImageIcon("resources/save_icon.png");
    saveButton = new JButton(saveIcon);
    saveButton.setActionCommand(saveMealCommand);
    saveButton.addActionListener(this);
    saveButton.setPreferredSize(buttonDimension);

    ImageIcon saveAsIcon = new ImageIcon(
        getClass().getClassLoader().getResource("save_as_icon.png"));
    // ImageIcon saveAsIcon = new ImageIcon("resources/save_as_icon.png");
    saveAsButton = new JButton(saveAsIcon);
    saveAsButton.setActionCommand(saveAsMealCommand);
    saveAsButton.addActionListener(this);
    saveAsButton.setPreferredSize(buttonDimension);

    ImageIcon closeIcon = new ImageIcon(getClass().getClassLoader().getResource("close_icon.png"));
    // ImageIcon closeIcon = new ImageIcon("resources/close_icon.png");
    closeButton = new JButton(closeIcon);
    closeButton.setActionCommand(closeMealCommand);
    closeButton.addActionListener(this);
    closeButton.setPreferredSize(buttonDimension);

    iconPanel.add(newButton);
    iconPanel.add(openButton);
    iconPanel.add(saveButton);
    iconPanel.add(saveAsButton);
    iconPanel.add(closeButton);

    return iconPanel;

  }

  private JPanel createNamePanel()
  {
    // Create Panel
    JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    namePanel.setOpaque(false);

    // Name field
    JLabel recipeNameLabel = new JLabel(bundle.getString("MealEditor.recipeNameLabel"));
    recipeNameLabel.setForeground(Color.WHITE);
    mealNameField = new JTextField(40);

    // Add the components to the panel
    namePanel.add(recipeNameLabel);
    namePanel.add(mealNameField);

    return namePanel;
  }

  private JPanel createRecipePanel()
  {
    // Create Panels
    JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    innerPanel.setOpaque(false);
    JPanel deletePanel = new JPanel(new BorderLayout());
    deletePanel.setOpaque(false);
    JPanel outerPanel = new JPanel(new BorderLayout());
    outerPanel.setOpaque(false);

    // Set Layout and Dimensions
    outerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    TitledBorder innerBorder = BorderFactory
        .createTitledBorder(BorderFactory.createLineBorder(Color.WHITE));
    innerPanel.setBorder(innerBorder);
    innerPanel.setPreferredSize(panelSize);
    deletePanel.setPreferredSize(deleteButtonDimension);

    // Add button
    JButton addButton = new JButton(bundle.getString("MealEditor.addButton"));
    addButton.setPreferredSize(new Dimension(100, 20));
    addButton.setActionCommand(addRecipeCommand);
    addButton.addActionListener(this);

    // Utensil display
    RecipeModel = new DefaultListModel<>();
    RecipeDisplay = new JList<String>(RecipeModel);
    RecipeDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    RecipeDisplay.setPreferredSize(scrollPanelDimension);

    // Delete button
    JButton deleteButton = new JButton(bundle.getString("MealEditor.deleteButton"));
    deleteButton.setActionCommand(deleteRecipeCommand);
    deleteButton.addActionListener(this);
    deleteButton.setPreferredSize(new Dimension(100, 20));
    deletePanel.add(deleteButton, BorderLayout.SOUTH);

    // Add panels and components to innerPanel;
    innerPanel.add(addButton);
    innerPanel.add(RecipeDisplay);
    innerPanel.add(deletePanel);

    // Add innerPanel to outerPanel
    outerPanel.add(innerPanel, BorderLayout.CENTER);

    return outerPanel;
  }

  public void actionPerformed(final ActionEvent evt)
  {
    if (evt.getActionCommand().equals(newMealCommand))
    {
      this.setVisible(false);
      new MealEditor();

    }

    // Open Meal
    if (evt.getActionCommand().equals(openMealCommand))
    {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File(userHome + defaultDirectory));
      int result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION)
      {
        File file = fileChooser.getSelectedFile();

        int lastSlashIndex = file.getPath().lastIndexOf("\\");
        if (lastSlashIndex != -1)
        {
          currentPath = Paths.get(file.getPath().substring(0, lastSlashIndex));
          currentFilename = file.getPath().substring(lastSlashIndex + 1);
          if (currentFilename.endsWith(mealFileExtension))
          {
            currentFilename = currentFilename.substring(0,
                currentFilename.length() - mealFileExtension.length());
          }

        }
        Meal meal = FileIO.readMeal(file.toPath());

        // FileInputStream fileInputStream = new FileInputStream(file);
        // ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        // Meal meal = (Meal) objectInputStream.readObject();
        // objectInputStream.close();

        mealNameField.setText(meal.getName());
        recipes = meal.getRecipes();

        RecipeModel.clear();
        for (Recipe recipe : recipes)
        {
          RecipeModel.addElement(recipe.getName());
        }

      }

    }

    // Save Meal
    if (evt.getActionCommand().equals(saveMealCommand))
    {
      String currentName = mealNameField.getText();

      if (!currentName.equals(""))
      {
        if (currentPath.toString().equals(""))
        {
          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setCurrentDirectory(defaultPath.toFile());
          fileChooser.setSelectedFile(new File(currentName));
          int result = fileChooser.showOpenDialog(null);
          if (result == JFileChooser.APPROVE_OPTION)
          {
            File file = fileChooser.getSelectedFile();
            int lastSlashIndex = file.getPath().lastIndexOf(slash);
            if (lastSlashIndex != -1)
            {
              currentPath = Paths.get(file.getPath().substring(0, lastSlashIndex));
              currentFilename = file.getPath().substring(lastSlashIndex + 1);
            }
          }
          Meal meal = new Meal(currentName);

          for (Recipe recipe : recipes)
          {
            meal.addRecipe(recipe);
          }
          FileIO.writeMeal(meal, currentPath, currentFilename);
        }

      }

    }

    // Save as meal
    if (evt.getActionCommand().equals(saveAsMealCommand))
    {
      String currentName = mealNameField.getText();
      Meal meal = new Meal(currentName);
      for (Recipe recipe : recipes)
      {
        meal.addRecipe(recipe);
      }
      if (!currentName.equals(""))
      {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(defaultPath.toFile());
        fileChooser.setSelectedFile(new File(currentFilename));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
          String fullPath = fileChooser.getSelectedFile().getPath();
          System.out.println(fullPath);
          int lastSlashIndex = fullPath.lastIndexOf(slash);
          if (lastSlashIndex != -1)
          {
            currentPath = Paths.get(fullPath.substring(0, lastSlashIndex));
            currentFilename = fullPath.substring(lastSlashIndex + 1);
          }

          FileIO.writeMeal(meal, currentPath, currentFilename);
        }
      }

    }

    // Close Panel
    if (evt.getActionCommand().equals(closeMealCommand))
    {
      this.setVisible(false);
    }

    // Add Recipe
    if (evt.getActionCommand().equals(addRecipeCommand))
    {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File(userHome + recipeDirectory));
      int result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION)
      {
        File file = fileChooser.getSelectedFile();
        try
        {
          int lastSlashIndex = file.getPath().lastIndexOf("\\");
          if (lastSlashIndex != -1)
          {
            // currentPath = file.getPath().substring(0, lastSlashIndex);
          }
          else
          {
            // currentPath = file.getPath();
          }

          FileInputStream fileInputStream = new FileInputStream(file);
          ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
          Recipe recipe = (Recipe) objectInputStream.readObject();
          objectInputStream.close();

          RecipeModel.addElement(recipe.getName());

          if (recipes == null)
          {
            recipes = new ArrayList<Recipe>();
          }
          else
          {
            recipes.add(recipe);
          }

        }
        catch (IOException | ClassNotFoundException e)
        {
          e.printStackTrace();

        }

      }
    }

    // Delete Commands
    if (evt.getActionCommand().equals(deleteRecipeCommand))
    {
      if (RecipeDisplay.getSelectedIndex() != -1)
      {
        int index = RecipeDisplay.getSelectedIndex();
        RecipeModel.remove(index);
        recipes.remove(index);

      }
    }
  }

}
