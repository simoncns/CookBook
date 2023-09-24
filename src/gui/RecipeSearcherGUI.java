package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import data.Ingredient;
import data.Meal;
import data.Recipe;
import information.MealSearcher;
import information.RecipeSearcher;
import languageconversion.Language;

public class RecipeSearcherGUI extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private Locale userLocale = Locale.getDefault();
  private ResourceBundle bundle;

  private JTextField requiredIngredients;
  private JTextField excludedIngredients;

  private DefaultListModel<String> recipeModel;
  private JList<String> recipeDisplay;

  private Dimension scrollPanelDimension = new Dimension(435, 200);

  private String SEARCH = "Search";
  private final String defaultDirectory = "/KiloBites/saves/recipes";
  private final String userHome = System.getProperty("user.home");

  public RecipeSearcherGUI()
  {
    super();
    bundle = Language.getLanguageBundle();
    
    setTitle(bundle.getString("RecipeSearchGUI.title"));
    setSize(550, 350);

    JPanel mainPanel = new GradientPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    mainPanel.add(mealSearch());
    mainPanel.setVisible(true);

    setContentPane(mainPanel);
    setVisible(true);
  }

  private JPanel mealSearch()
  {
    JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT));
    content.setOpaque(false);
    content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JLabel requiredIngredientLabel = new JLabel(
        bundle.getString("RecipeSearchGUI.requiredIngredientLabel"));
    requiredIngredientLabel.setForeground(Color.WHITE);
    requiredIngredients = new JTextField(40);
    
    requiredIngredients.setToolTipText(bundle.getString("RecipeSearchGUI.Tool1")
            + bundle.getString("RecipeSearchGUI.Tool2") + bundle.getString("RecipeSearchGUI.Tool3"));


    JLabel excludedIngredientLabel = new JLabel(
        bundle.getString("RecipeSearchGUI.excludedIngredientLabel"));
    excludedIngredientLabel.setForeground(Color.WHITE);
    excludedIngredients = new JTextField(40);
    excludedIngredients.setToolTipText(bundle.getString("RecipeSearchGUI.Tool1")
        + bundle.getString("RecipeSearchGUI.Tool2") + bundle.getString("RecipeSearchGUI.Tool3"));


    recipeModel = new DefaultListModel<>();
    recipeDisplay = new JList<String>(recipeModel);
    recipeDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(recipeDisplay);
    scrollPane.setPreferredSize(scrollPanelDimension);

    JButton addButton = new JButton(bundle.getString("RecipeSearchGUI.addButton"));
    addButton.setPreferredSize(new Dimension(80, 20));
    addButton.setActionCommand(bundle.getString("RecipeSearchGUI.addButton"));
    addButton.addActionListener(this);

    content.add(requiredIngredientLabel);
    content.add(requiredIngredients);
    content.add(excludedIngredientLabel);
    content.add(excludedIngredients);
    content.add(scrollPane);
    content.add(addButton);
    content.setVisible(true);

    return content;
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals(bundle.getString("RecipeSearchGUI.addButton")))
    {
      recipeModel.clear();
      String directoryPath = userHome + defaultDirectory;
      Map<String, Recipe> recipes = new HashMap<>();
      List<Recipe> recipes2 = new ArrayList<>();
      File directory = new File(directoryPath);
      if (directory.isDirectory())
      {
        File[] files = directory.listFiles();
        for (File file : files)
        {
          try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
          {
            Recipe recipe = (Recipe) ois.readObject();
            recipes.put(recipe.getName(), recipe);
            
          }
          catch (IOException | ClassNotFoundException io)
          {
            io.printStackTrace();
          }
        }
      }
      List<String> reqIngredients = new ArrayList<>();
      List<String> exclIngredients = new ArrayList<>();
      String[] splitReq = requiredIngredients.getText().split(", ");
      String[] splitExc = excludedIngredients.getText().split(", ");
      for (int i = 0; i < splitReq.length; i++)
      {
        reqIngredients.add(splitReq[i]);

      }
      for (int i = 0; i < splitExc.length; i++)
      {
        exclIngredients.add(splitExc[i]);

      }
      
      
      

      List<Recipe> goodRecipes = RecipeSearcher.searchRecipes(reqIngredients, exclIngredients,
          recipes);
//      for (Recipe recipe : goodRecipes)
//      {
//        for(Ingredient ingredient: recipe.getIngredient())
//        {
//          if(ingredient.getRecipe() != null){
//            {
//              Map<String,Recipe> embeded = new HashMap<>();
//              embeded.put(ingredient.getName(), ingredient.getRecipe());
//              List<Recipe> embedRecipes = 
//                  RecipeSearcher.searchRecipes(reqIngredients, exclIngredients, embeded);
//              if(embedRecipes.isEmpty())
//              {
//                goodRecipes.remove(recipe);
//              }
//            }
//          }
//        }
//      }

      for (Recipe recipe : goodRecipes)
      {
        // System.out.println();
        recipeModel.addElement(recipe.getName());
      }

    }

  }

}
