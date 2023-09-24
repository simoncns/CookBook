package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import data.Ingredient;
import data.Recipe;
import data.Step;
import data.Utensil;
import enums.Ingredients;
import languageconversion.Language;
import tools.FileIO;
import tools.Measurements;
import tools.Numerics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class for Recipe Editor gui.
 * 
 * @author Stephen Watson
 *
 */
public class RecipeEditor extends JFrame implements ActionListener, DocumentListener
{
  private static final long serialVersionUID = 1L;

  // Panel Dimensions
  private Dimension panelSize = new Dimension(250, 600);
  private Dimension iconPanelDimension = new Dimension(500, 70);
  private Dimension buttonDimension = new Dimension(50, 50);
  private Dimension scrollPanelDimension = new Dimension(555, 190);
  private Dimension deleteButtonDimension = new Dimension(100, 190);
 
  // Icon Action Commands
  private final String newRecipeCommand = "NEW";
  private final String openRecipeCommand = "OPEN";
  private final String saveRecipeCommand = "SAVE";
  private final String saveAsRecipeCommand = "SAVEAS";
  private final String closeRecipeCommand = "CLOSE";

  // Add Action Commands
  private final String addUtensilCommand = "UTENSIL";
  private final String addIngredientCommand = "INGREDIENT";
  private final String addStepsCommand = "STEPS";

  // Delete Action Commands
  private final String deleteUtensilCommand = "D_UTENSIL";
  private final String deleteIngredientCommand = "D_INGREDIENT";
  private final String deleteStepCommand = "D_STEP";

  // Add Embedded Action Command
  private final String addEmbeddedIngredient = "A_EMBEDDED";
  private final String showEmbeddedIngredient = "S_EMBEDDED";

  // Icon Panel Buttons
  private JButton newButton;
  private JButton openButton;
  private JButton saveButton;
  private JButton saveAsButton;
  private JButton closeButton;

  // Recipe Name Panel
  private JTextField recipeNameField;
  private JTextField recipeServesField;

  // Utensil Panel
  private JTextField utensilNameField;
  private JTextField utensilDetailField;
  private DefaultListModel<String> utensilModel;
  private JList<String> utensilDisplay;

  // Ingredient Panel
  private JComboBox<String> ingredientNameBox;
  private JTextField ingredientDetailsField;
  private JTextField ingredientAmountField;
  private JComboBox<String> ingredientUnitsBox;
  private DefaultListModel<String> ingredientsModel;
  private JList<String> ingredientsDisplay;

  // Step Panel
  private JTextField stepsActionField;
  private JComboBox<String> stepsOnBox;
  private JComboBox<String> stepsUtensilBox;
  private JTextField stepsDetailsField;
  private DefaultListModel<String> stepsModel;
  private JList<String> stepsDisplay;

  // List of Utensils
  private List<Utensil> utensils;
  private List<Ingredient> ingredients;
  private List<Step> steps;

  // Path for Recipe Saves
  private final Path defaultPath;
  private Path currentPath;
  private String currentFilename;

  // Combo Box
  private final Measurements[] measurementUnits = Measurements.values();
  private final Ingredients[] baseIngredients = Ingredients.values();

  // Resource bundle
  private ResourceBundle bundle = Language.getLanguageBundle();
  private String ingredientNameString = bundle.getString("RecipeEditor.ingredientNameLabel");
  private String ingredientAmountString = bundle.getString("RecipeEditor.ingredientAmountLabel");
  private String ingredinetDetailString = bundle.getString("RecipeEditor.ingredientDetailsLabel");
  private String ingredinetUnitString = bundle.getString("RecipeEditor.ingredientUnitsLabel");
  private String addButtonString = bundle.getString("RecipeEditor.addButton");
  private String deleteButtonString = bundle.getString("RecipeEditor.deleteButton");

  private JTextField ingredientName;
  private JTextField ingredientAmount;
  private JTextField ingredientDetails;
  private JTextField ingredientCalorie;
  private JTextField ingredientDensity;
  private JComboBox<String> ingredientUnits;

  private final String slash = "\\";

  // Extension
  private final String recipeExtension = ".rcp";
  private final String recipeDefaultPath = System.getProperty("user.home")
      + "/KiloBites/saves/recipes";

  private final String addflexingredientcommand = "Ingredient";

  private JFrame frame;
  private JFrame ingredientframe;

  // Callback
  private RecipeCallback callback;

  /**
   * Constructs the editor.
   */
  public RecipeEditor()
  {
    // Set Path
    defaultPath = Paths.get(recipeDefaultPath);
    currentPath = Paths.get("");
    currentFilename = "";

    // New Lists
    utensils = new ArrayList<Utensil>();
    ingredients = new ArrayList<Ingredient>();
    steps = new ArrayList<Step>();

    // Create frame
    createEditorFrame();
  }

  /**
   * Recipe Editor constructor that takes in a recipe as the default value.
   * 
   * @param recipe
   */
  public RecipeEditor(final Recipe recipe)
  {
    // Set Path
    defaultPath = Paths.get(recipeDefaultPath);
    currentPath = Paths.get("");
    currentFilename = "";

    // New Lists
    utensils = new ArrayList<Utensil>();
    ingredients = new ArrayList<Ingredient>();
    steps = new ArrayList<Step>();

    // Create frame
    createEditorFrame();
    
    // Updates current fields with new recipe.
    updateRecipe(recipe);
  }

  /**
   * Creates main frame of Recipe Editor.
   */
  private void createEditorFrame()
  {
    // Build Frame
    frame = new JFrame();
    JPanel contentPane = new GradientPanel();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
    contentPane.add(createIconPanel());
    contentPane.add(createNamePanel());
    contentPane.add(createUtensilPanel());
    contentPane.add(createIngredientsPanel());
    contentPane.add(createStepsPanel());

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle(bundle.getString("RecipeEditor.title"));
    setContentPane(contentPane);
    pack();
    frame.setSize(750, 1000);
    frame.add(contentPane);
    frame.setVisible(true);
  }

  /**
   * Makes a new window when specific conditions are met.
   * 
   * @return JFrame
   */
  public JFrame createExtraIngredient()
  {
    ingredientframe = new JFrame();
    ingredientframe.setTitle("Additional Ingredients");
    setSize(550, 200);

    JPanel mainPanel = new GradientPanel();

    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.add(createingredient());
    mainPanel.setVisible(true);

    setContentPane(mainPanel);
    ingredientframe.setSize(550, 200);
    ingredientframe.add(mainPanel);
    ingredientframe.setVisible(true);
    return ingredientframe;
  }

  /**
   * Create the Ingredients Panel.
   * 
   * @return JPanel
   */
  public JPanel createingredient()
  {
    JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT));
    content.setOpaque(false);
    content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JLabel ingredientNameLabel = new JLabel(ingredientNameString);
    ingredientNameLabel.setForeground(Color.WHITE);
    ingredientName = new JTextField(10);

    JLabel ingredientAmountLabel = new JLabel(ingredientAmountString);
    ingredientAmountLabel.setForeground(Color.WHITE);
    ingredientAmount = new JTextField(5);

    JLabel ingredientDetailLabel = new JLabel(ingredinetDetailString);
    ingredientDetailLabel.setForeground(Color.WHITE);
    ingredientDetails = new JTextField(10);

    JLabel ingredientUnitLabel = new JLabel(ingredinetUnitString);
    ingredientUnitLabel.setForeground(Color.white);
    ingredientUnits = new JComboBox<>();
    for (Measurements item : measurementUnits)
    {
      ingredientUnits.addItem(item.getString());
    }
    ingredientUnits.setPreferredSize(new Dimension(120, 20));

    JLabel ingredientCalorieLabel = new JLabel(
        bundle.getString("RecipeEditor.ingredientCalorieLabel"));
    ingredientCalorieLabel.setForeground(Color.WHITE);
    ingredientCalorie = new JTextField(4);

    JLabel ingredientDensityLabel = new JLabel(
        bundle.getString("RecipeEditor.ingredientDensityLabel"));
    ingredientDensityLabel.setForeground(Color.white);
    ingredientDensity = new JTextField(4);

    JButton addButton = new JButton(addButtonString);
    addButton.setPreferredSize(new Dimension(60, 20));
    addButton.setActionCommand(addflexingredientcommand);
    addButton.addActionListener(this);

    content.add(ingredientNameLabel);
    content.add(ingredientName);
    content.add(ingredientAmountLabel);
    content.add(ingredientAmount);
    content.add(ingredientDetailLabel);
    content.add(ingredientDetails);
    content.add(ingredientUnitLabel);
    content.add(ingredientUnits);
    content.add(ingredientCalorieLabel);
    content.add(ingredientCalorie);
    content.add(ingredientDensityLabel);
    content.add(ingredientDensity);
    content.add(addButton);
    content.setVisible(true);

    return content;
  }

  /**
   * Constructs the icon panel.
   * 
   * @return JPanel
   */
  private JPanel createIconPanel()
  {
    JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    iconPanel.setOpaque(false);
    iconPanel.setPreferredSize(iconPanelDimension);

    ImageIcon newIcon = new ImageIcon(getClass().getClassLoader().getResource("new_icon.png"));
    Image scaled = newIcon.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
    ImageIcon finalnewicon = new ImageIcon(scaled);
    newButton = new JButton(finalnewicon);
    newButton.setFocusPainted(false);
    newButton.setActionCommand(newRecipeCommand);
    newButton.addActionListener(this);
    newButton.setPreferredSize(buttonDimension);

    ImageIcon openIcon = new ImageIcon(getClass().getClassLoader().getResource("open_icon.png"));
    // ImageIcon openIcon = new ImageIcon("resources/open_icon.png");
    openButton = new JButton(openIcon);
    openButton.setActionCommand(openRecipeCommand);
    openButton.addActionListener(this);
    openButton.setPreferredSize(buttonDimension);

    ImageIcon saveIcon = new ImageIcon(getClass().getClassLoader().getResource("save_icon.png"));
    // ImageIcon saveIcon = new ImageIcon("resources/save_icon.png");
    saveButton = new JButton(saveIcon);
    saveButton.setActionCommand(saveRecipeCommand);
    saveButton.addActionListener(this);
    saveButton.setPreferredSize(buttonDimension);
    saveButton.setEnabled(false);

    ImageIcon saveAsIcon = new ImageIcon(
        getClass().getClassLoader().getResource("save_as_icon.png"));
    // ImageIcon saveAsIcon = new ImageIcon("resources/save_as_icon.png");
    saveAsButton = new JButton(saveAsIcon);
    saveAsButton.setActionCommand(saveAsRecipeCommand);
    saveAsButton.addActionListener(this);
    saveAsButton.setPreferredSize(buttonDimension);
    saveAsButton.setEnabled(false);

    ImageIcon closeIcon = new ImageIcon(getClass().getClassLoader().getResource("close_icon.png"));
    // ImageIcon closeIcon = new ImageIcon("resources/close_icon.png");
    closeButton = new JButton(closeIcon);
    closeButton.setActionCommand(closeRecipeCommand);
    closeButton.addActionListener(this);
    closeButton.setPreferredSize(buttonDimension);

    iconPanel.add(newButton);
    iconPanel.add(openButton);
    iconPanel.add(saveButton);
    iconPanel.add(saveAsButton);
    iconPanel.add(closeButton);

    return iconPanel;
  }

  /**
   * Constructs the name panel.
   * 
   * @return JPanel
   */
  private JPanel createNamePanel()
  {
    // Create Panel
    JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    namePanel.setOpaque(false);

    // Name field
    JLabel recipeNameLabel = new JLabel(bundle.getString("RecipeEditor.recipeNameLabel"));
    recipeNameLabel.setForeground(Color.WHITE);
    recipeNameField = new JTextField(40);
    recipeNameField.getDocument().addDocumentListener(this);

    // Serves field
    JLabel recipeServesLabel = new JLabel(bundle.getString("RecipeEditor.recipeServesLabel"));
    recipeServesLabel.setForeground(Color.WHITE);
    recipeServesField = new JTextField(10);

    // Add the components to the panel
    namePanel.add(recipeNameLabel);
    namePanel.add(recipeNameField);
    namePanel.add(recipeServesLabel);
    namePanel.add(recipeServesField);

    return namePanel;
  }

  /**
   * Constructs the Utensils panel.
   * 
   * @return JPanel
   */
  private JPanel createUtensilPanel()
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
    TitledBorder innerBorder = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE), bundle.getString("RecipeEditor.innerBorder"));
    innerBorder.setTitleColor(Color.WHITE);
    innerPanel.setBorder(innerBorder);
    innerPanel.setPreferredSize(panelSize);
    deletePanel.setPreferredSize(deleteButtonDimension);

    // Name field
    JLabel utensilNameLabel = new JLabel(bundle.getString("RecipeEditor.utensilNameLabel"));
    utensilNameLabel.setForeground(Color.WHITE);
    utensilNameField = new JTextField(25);

    // Details field
    JLabel utensilDetailLabel = new JLabel(bundle.getString("RecipeEditor.utensilDetailLabel"));
    utensilDetailLabel.setForeground(Color.WHITE);
    utensilDetailField = new JTextField(20);

    // Add button
    JButton addButton = new JButton(addButtonString);
    addButton.setPreferredSize(new Dimension(60, 20));
    addButton.setActionCommand(addUtensilCommand);
    addButton.addActionListener(this);

    // Utensil display
    utensilModel = new DefaultListModel<>();
    utensilDisplay = new JList<String>(utensilModel);
    utensilDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(utensilDisplay);
    scrollPane.setPreferredSize(scrollPanelDimension);

    // Delete button
    JButton deleteButton = new JButton(deleteButtonString);
    deleteButton.setActionCommand(deleteUtensilCommand);
    deleteButton.addActionListener(this);
    deleteButton.setPreferredSize(new Dimension(100, 20));
    deletePanel.add(deleteButton, BorderLayout.SOUTH);

    // Add panels and components to innerPanel
    innerPanel.add(utensilNameLabel);
    innerPanel.add(utensilNameField);
    innerPanel.add(utensilDetailLabel);
    innerPanel.add(utensilDetailField);
    innerPanel.add(addButton);
    innerPanel.add(scrollPane);
    innerPanel.add(deletePanel);

    // Add innerPanel to outerPanel
    outerPanel.add(innerPanel, BorderLayout.CENTER);

    return outerPanel;
  }

  /**
   * Constructs the Ingredients panel.
   * 
   * @return JPanel
   */
  private JPanel createIngredientsPanel()
  {
    // Create panels
    JPanel outerPanel = new JPanel(new BorderLayout());
    outerPanel.setOpaque(false);
    JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    innerPanel.setOpaque(false);
    JPanel deletePanel = new JPanel(new BorderLayout());
    deletePanel.setOpaque(false);

    // Set Layout and Dimensions
    outerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    TitledBorder innerBorder = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE), bundle.getString("RecipeEditor.innerBorder1"));
    innerBorder.setTitleColor(Color.WHITE);
    innerPanel.setBorder(innerBorder);
    innerPanel.setPreferredSize(panelSize);
    deletePanel.setPreferredSize(deleteButtonDimension);

    // Name field
    JLabel ingredientNameLabel = new JLabel(ingredientNameString);
    ingredientNameLabel.setForeground(Color.WHITE);
    ingredientNameBox = new JComboBox<>();
    for (Ingredients item : baseIngredients)
    {
      ingredientNameBox.addItem(item.getName());
    }
    ingredientNameBox.setEditable(true);
    ingredientNameBox.setPreferredSize(new Dimension(120, 20));

    // Detail field
    JLabel ingredientDetailsLabel = new JLabel(ingredinetDetailString);
    ingredientDetailsLabel.setForeground(Color.WHITE);
    ingredientDetailsField = new JTextField(10);

    // Amount field
    JLabel ingredientAmountLabel = new JLabel(ingredientAmountString);
    ingredientAmountLabel.setForeground(Color.WHITE);
    ingredientAmountField = new JTextField(4);

    // Unit field
    JLabel ingredientUnitsLabel = new JLabel(ingredinetUnitString);
    ingredientUnitsLabel.setForeground(Color.WHITE);
    ingredientUnitsBox = new JComboBox<>();
    for (Measurements item : measurementUnits)
    {
      ingredientUnitsBox.addItem(item.getString());
    }
    ingredientUnitsBox.setEditable(true);
    ingredientUnitsBox.setPreferredSize(new Dimension(120, 20));

    // Add button
    JButton addButton = new JButton(addButtonString);
    addButton.setPreferredSize(new Dimension(60, 20));
    addButton.setActionCommand(addIngredientCommand);
    addButton.addActionListener(this);

    // Ingredients display
    ingredientsModel = new DefaultListModel<>();
    ingredientsDisplay = new JList<String>(ingredientsModel);
    ingredientsDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(ingredientsDisplay);
    scrollPane.setPreferredSize(scrollPanelDimension);

    // Show Embedded button
    JButton showEmbeddedButton = new JButton(bundle.getString("RecipeEditor.showEmbedded"));
    showEmbeddedButton.setActionCommand(showEmbeddedIngredient);
    showEmbeddedButton.addActionListener(this);
    showEmbeddedButton.setPreferredSize(new Dimension(100, 20));
    deletePanel.add(showEmbeddedButton, BorderLayout.NORTH);

    // Add Embedded button
    JButton addEmbeddedButton = new JButton(bundle.getString("RecipeEditor.addEmbedded"));
    addEmbeddedButton.setActionCommand(addEmbeddedIngredient);
    addEmbeddedButton.addActionListener(this);
    addEmbeddedButton.setPreferredSize(new Dimension(100, 20));
    deletePanel.add(addEmbeddedButton, BorderLayout.CENTER);

    // Delete button
    JButton deleteButton = new JButton(deleteButtonString);
    deleteButton.setActionCommand(deleteIngredientCommand);
    deleteButton.addActionListener(this);
    deleteButton.setPreferredSize(new Dimension(100, 20));
    deletePanel.add(deleteButton, BorderLayout.SOUTH);

    // Add panels and components to innerPanel
    innerPanel.add(ingredientNameLabel);
    innerPanel.add(ingredientNameBox);
    innerPanel.add(ingredientDetailsLabel);
    innerPanel.add(ingredientDetailsField);
    innerPanel.add(ingredientAmountLabel);
    innerPanel.add(ingredientAmountField);
    innerPanel.add(ingredientUnitsLabel);
    innerPanel.add(ingredientUnitsBox);
    innerPanel.add(addButton);
    innerPanel.add(scrollPane);
    innerPanel.add(deletePanel);

    // Add innerPanel to outerPanel
    outerPanel.add(innerPanel, BorderLayout.CENTER);

    return outerPanel;
  }

  /**
   * Constructs the Steps panel.
   * 
   * @return JPanel
   */
  private JPanel createStepsPanel()
  {
    // Create Panels
    JPanel outerPanel = new JPanel(new BorderLayout());
    outerPanel.setOpaque(false);
    JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    innerPanel.setOpaque(false);
    JPanel deletePanel = new JPanel(new BorderLayout());
    deletePanel.setOpaque(false);

    // Set Layout and Dimensions
    outerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    TitledBorder innerBorder = BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE), bundle.getString("RecipeEditor.innerBorder2"));
    innerBorder.setTitleColor(Color.WHITE);
    innerPanel.setBorder(innerBorder);
    innerPanel.setPreferredSize(panelSize);
    deletePanel.setPreferredSize(deleteButtonDimension);

    // Name field
    JLabel stepsActionLabel = new JLabel(bundle.getString("RecipeEditor.stepsActionLabel"));
    stepsActionLabel.setForeground(Color.WHITE);
    stepsActionField = new JTextField(8);

    // On field
    JLabel stepsOnLabel = new JLabel(bundle.getString("RecipeEditor.stepsOnLabel"));
    stepsOnBox = new JComboBox<>();
    stepsOnBox.setPreferredSize(new Dimension(110, 20));

    // Utensil field
    JLabel stepsUtensilLabel = new JLabel(bundle.getString("RecipeEditor.stepsUtensilLabel"));
    stepsUtensilLabel.setForeground(Color.WHITE);
    stepsUtensilBox = new JComboBox<>();
    stepsUtensilBox.setPreferredSize(new Dimension(110, 20));

    // Details field
    JLabel stepsDetailsLabel = new JLabel(bundle.getString("RecipeEditor.stepsDetailsLabel"));
    stepsDetailsLabel.setForeground(Color.WHITE);
    stepsDetailsField = new JTextField(9);

    // Add button
    JButton addButton = new JButton(addButtonString);
    addButton.setPreferredSize(new Dimension(60, 20));
    addButton.setActionCommand(addStepsCommand);
    addButton.addActionListener(this);

    // Step display
    stepsModel = new DefaultListModel<>();
    stepsDisplay = new JList<String>(stepsModel);
    stepsDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(stepsDisplay);
    scrollPane.setPreferredSize(scrollPanelDimension);

    // delete Button
    JButton deleteButton = new JButton(deleteButtonString);
    deleteButton.setActionCommand(deleteStepCommand);
    deleteButton.addActionListener(this);
    deleteButton.setPreferredSize(new Dimension(100, 20));
    deletePanel.add(deleteButton, BorderLayout.SOUTH);

    // Add panels and components to innerPanel
    innerPanel.add(stepsActionLabel);
    innerPanel.add(stepsActionField);
    innerPanel.add(stepsOnLabel);
    innerPanel.add(stepsOnBox);
    innerPanel.add(stepsUtensilLabel);
    innerPanel.add(stepsUtensilBox);
    innerPanel.add(stepsDetailsLabel);
    innerPanel.add(stepsDetailsField);
    innerPanel.add(addButton);
    innerPanel.add(scrollPane);
    innerPanel.add(deletePanel);

    // Add innerPanel to outerPanel
    outerPanel.add(innerPanel, BorderLayout.CENTER);

    return outerPanel;
  }

  /**
   * Updates the comboBoxes.
   */
  private void updateComboBoxes()
  {
    stepsOnBox.removeAllItems();
    Collections.sort(ingredients);
    for (Ingredient item : ingredients)
    {
      stepsOnBox.addItem(item.getName());
    }

    Collections.sort(utensils);
    for (Utensil item : utensils)
    {
      stepsOnBox.addItem(item.getName().toUpperCase());
    }

    stepsUtensilBox.removeAllItems();
    for (Utensil item : utensils)
    {
      stepsUtensilBox.addItem(item.getName());
    }
  }
  
  private void updateRecipe(final Recipe recipe)
  {
    // Set Name Panel
    recipeNameField.setText(recipe.getName());
    recipeServesField.setText(String.valueOf(recipe.getAmount()));
    utensils = new ArrayList<Utensil>(recipe.getUtensils());
    ingredients = new ArrayList<Ingredient>(recipe.getIngredient());
    steps = new ArrayList<Step>(recipe.getSteps());

    // Set Models
    utensilModel.clear();
    for (Utensil item : recipe.getUtensils())
    {
      utensilModel.addElement(item.toString());
    }

    ingredientsModel.clear();
    for (Ingredient item : recipe.getIngredient())
    {
      ingredientsModel.addElement(item.toString());
    }

    stepsModel.clear();
    for (Step item : recipe.getSteps())
    {
      stepsModel.addElement(item.toString());
    }
  }
  
  private void openRecipe()
  {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(defaultPath.toFile());
    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
    {
      File file = fileChooser.getSelectedFile();

      // Sets Current Path
      int lastSlashIndex = file.getPath().lastIndexOf(slash);
      if (lastSlashIndex != -1)
      {
        currentPath = Paths.get(file.getPath().substring(0, lastSlashIndex));
        currentFilename = file.getPath().substring(lastSlashIndex + 1);
        if (currentFilename.endsWith(recipeExtension))
        {
          currentFilename = currentFilename.substring(0,
              currentFilename.length() - recipeExtension.length());
        }
      }

      // Get recipe from file
      Recipe recipe = FileIO.readRecipe(file.toPath());

      updateRecipe(recipe);
    }
  }
  
  private void saveRecipe()
  {
    String currentName = recipeNameField.getText();
    Integer currentServes = Numerics.integerValueOf(recipeServesField.getText());

    if (!currentName.equals("") && !currentServes.equals(null))
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
      }

      System.out.print(currentPath.toString());
      Recipe recipe = new Recipe(currentName, currentServes, ingredients, utensils, steps);

      if (callback != null)
      {
        callback.onRecipeCreated(recipe);
      }

      FileIO.writeRecipe(recipe, currentPath, currentFilename);
    }
  }
  
  private void saveAsRecipe()
  {
    String currentName = recipeNameField.getText();
    Integer currentServes = Numerics.integerValueOf(recipeServesField.getText());

    if (!currentName.equals("") && !currentServes.equals(null))
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

        Recipe recipe = new Recipe(currentName, currentServes, ingredients, utensils, steps);
        FileIO.writeRecipe(recipe, currentPath, currentFilename);
      }
    }
  }
  
  private void addUtensil()
  {
    String currentName = utensilNameField.getText();
    String currentDetail = utensilDetailField.getText();

    if (currentDetail.equals(""))
    {
      currentDetail = null;
    }

    if (!currentName.equals(""))
    {
      // Create Utensil
      Utensil currentUtensil = new Utensil(currentName, currentDetail);
      utensilModel.addElement(currentUtensil.toString());
      utensils.add(currentUtensil);

      // Set Panel
      utensilNameField.setText("");
      utensilDetailField.setText("");
    }
  }
  
  private void addIngredient()
  {
    String currentName = ingredientNameBox.getSelectedItem().toString();
    String currentAmount = (ingredientAmountField.getText());
    String currentUnit = ingredientUnitsBox.getSelectedItem().toString();
    String currentDetail = ingredientDetailsField.getText();

    if (currentDetail.equals(""))
    {
      currentDetail = null;
    }

    if (Ingredients.fromCode(currentName) != null)
    {
      if (!currentName.equals("") && !currentAmount.equals(null) && !currentAmount.equals(""))
      {
        Ingredient currentIngredient = new Ingredient(currentAmount.toString(), currentUnit,
            currentName, currentDetail);
        ingredientsModel.addElement(currentIngredient.toString());
        ingredients.add(currentIngredient);

        // Clear text
        ingredientNameBox.setSelectedIndex(0);
        ingredientAmountField.setText("");
        ingredientUnitsBox.setSelectedIndex(0);
        ingredientDetailsField.setText("");
      }
    }
    else
    {
      createExtraIngredient();
      ingredientName.setText(ingredientNameBox.getSelectedItem().toString());
      ingredientAmount.setText(ingredientAmountField.getText());
      ingredientDetails.setText(ingredientDetailsField.getText());
      ingredientUnits.setSelectedItem(ingredientUnitsBox.getSelectedItem());
      frame.setVisible(false);
    }
  }
  
  private void addFlexingIngredient()
  {
    String currentName = ingredientName.getText();
    Double currentAmount = Numerics.doubleValueOf(ingredientAmount.getText());
    String currentUnit = ingredientUnits.getSelectedItem().toString();
    String currentDetail = ingredientDetails.getText();
    Integer currentCalories = Numerics.integerValueOf(ingredientCalorie.getText());
    Double currentDensity = Numerics.doubleValueOf(ingredientDensity.getText());

    if (!currentName.equals("") || !currentAmount.equals(null) || !currentCalories.equals(null)
        || !currentDensity.equals(null))
    {
      Ingredient currentIngredient = new Ingredient(currentAmount.toString(), currentUnit,
          currentName, currentDetail);
      currentIngredient.setCalorie(currentCalories);
      currentIngredient.setDensity(currentDensity);
      ingredientsModel.addElement(currentIngredient.toString());
      ingredients.add(currentIngredient);
      ingredientframe.setVisible(false);
      frame.setVisible(true);
    }
  }
  
  private void showEmbeddedRecipe()
  {
    int index = ingredientsDisplay.getSelectedIndex();
    if (index != -1)
    {
      Recipe recipe = ingredients.get(index).getRecipe();
      if (recipe != null)
      {
        new RecipeEditor(recipe);
      }
    }
  }
  
  private void addEmbeddedIngredient()
  {
    int index = ingredientsDisplay.getSelectedIndex();
    if (index != -1)
    {
      ingredients.get(index).setRecipe(null);

      RecipeEditor recipeEditor = new RecipeEditor();

      recipeEditor.setCallback(new RecipeCallback()
      {
        @Override
        public void onRecipeCreated(final Recipe recipe)
        {
          System.out.println("test");
          ingredients.get(index).setRecipe(recipe);
        }
      });
    }
  }

  private void addStepe()
  {
    String currentAction = stepsActionField.getText();
    String currentOn = stepsOnBox.getSelectedItem().toString();
    String currentUtensi = stepsUtensilBox.getSelectedItem().toString();
    String currentDetail1 = stepsDetailsField.getText();

    if (!currentAction.equals("") || !currentUtensi.equals("") || !currentOn.equals(""))
    {
      Step currentStep = new Step(currentAction, currentOn, currentUtensi, currentDetail1);
      stepsModel.addElement(currentStep.toString());
      steps.add(currentStep);
    }
  }
  
  private void deleteUtensil()
  {
    if (utensilDisplay.getSelectedIndex() != -1)
    {
      int index = utensilDisplay.getSelectedIndex();
      utensilModel.remove(index);
      utensils.remove(index);
    }
  }
  
  private void deleteIngredient()
  {
    if (ingredientsDisplay.getSelectedIndex() != -1)
    {
      int index = ingredientsDisplay.getSelectedIndex();
      ingredientsModel.remove(index);
      ingredients.remove(index);
    }
  }
  
  private void deleteStep()
  {
    if (stepsDisplay.getSelectedIndex() != -1)
    {
      int index = stepsDisplay.getSelectedIndex();
      stepsModel.remove(index);
      steps.remove(index);
    }
  }
  
  @Override
  public void actionPerformed(final ActionEvent evt)
  {
    // New Recipe
    if (evt.getActionCommand().equals(newRecipeCommand))
    {
      this.setVisible(false);
      new RecipeEditor();
    }

    // Open Recipe
    if (evt.getActionCommand().equals(openRecipeCommand))
    {
      openRecipe();
    }

    // Save Recipe
    if (evt.getActionCommand().equals(saveRecipeCommand))
    {
      saveRecipe();
    }

    // Save As Recipe
    if (evt.getActionCommand().equals(saveAsRecipeCommand))
    {
      saveAsRecipe();
    }

    // Close Panel
    if (evt.getActionCommand().equals(closeRecipeCommand))
    {
      frame.setVisible(false);
    }

    // Add Utensil
    if (evt.getActionCommand().equals(addUtensilCommand))
    {
      addUtensil();
    }
    
    // Add Ingredient
    if (evt.getActionCommand().equals(addIngredientCommand))
    {
      addIngredient();
    }

    // Add Flexing Ingredient
    if (evt.getActionCommand().equals(addflexingredientcommand))
    {
      addFlexingIngredient();
    }

    // Show Embedded Recipe
    if (evt.getActionCommand().equals(showEmbeddedIngredient))
    {
      showEmbeddedRecipe();
    }

    // Add Embedded Ingredient
    if (evt.getActionCommand().equals(addEmbeddedIngredient))
    {
      addEmbeddedIngredient();
    }

    // Add Step
    if (evt.getActionCommand().equals(addStepsCommand))
    {
      addStepe();
    }

    // Delete Utensil
    if (evt.getActionCommand().equals(deleteUtensilCommand))
    {
      deleteUtensil();
    }

    // Delete Ingredient
    if (evt.getActionCommand().equals(deleteIngredientCommand))
    {
      deleteIngredient();
    }

    // Delete Step
    if (evt.getActionCommand().equals(deleteStepCommand))
    {
      deleteStep();
    }

    updateComboBoxes();
  }

  /**
   * Call back for recipe editor.
   * 
   * @param callback
   */
  public void setCallback(final RecipeCallback callback)
  {
    this.callback = callback;
  }

  @Override
  public void insertUpdate(final DocumentEvent e)
  {
    newButton.setEnabled(false);
    openButton.setEnabled(false);
    saveButton.setEnabled(true);
    saveAsButton.setEnabled(true);
    closeButton.setEnabled(true);
  }

  @Override
  public void removeUpdate(final DocumentEvent e)
  {
    newButton.setEnabled(false);
    openButton.setEnabled(false);
    saveButton.setEnabled(true);
    saveAsButton.setEnabled(true);
    closeButton.setEnabled(true);
  }

  @Override
  public void changedUpdate(final DocumentEvent e)
  {
    newButton.setEnabled(false);
    openButton.setEnabled(false);
    saveButton.setEnabled(true);
    saveAsButton.setEnabled(true);
    closeButton.setEnabled(true);
  }
}

/**
 * Call back interface for recipe editor.
 * 
 * @author Stephen Watson
 *
 */
interface RecipeCallback
{
  void onRecipeCreated(Recipe recipe);
}
