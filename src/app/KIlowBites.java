package app;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.*;
import java.util.ResourceBundle;

import javax.swing.*;

import gui.MainWindow;
import gui.MenuController;
import languageconversion.Language;

/**
 * ProductDriver class for running the GUIs and allowing them to show up.
 * 
 * @author Max Adams
 * @version S1
 *
 */
public class KIlowBites implements Runnable
{

  private static final String FILE = "File";
  private static final String EDIT = "Edit";
  private static final String SEARCH = "Search";
  private static final String VIEW = "View";
  private static final String TOOLS = "Tools";
  private static final String CONFIGURE = "Configure";
  private static final String HELP = "Help";

  private static final String[] MENU_OPTION = {FILE, EDIT, SEARCH, VIEW, TOOLS, CONFIGURE, HELP};
  private String[] args;

  /**
   * ProductDriver method.
   * 
   * @param args
   */
  public KIlowBites(final String[] args)
  {
    this.args = args;
  }

  /**
   * Main method that throws multiple exceptions.
   * 
   * @param args
   * @throws InterruptedException
   * @throws InvocationTargetException
   */
  public static void main(final String[] args)
      throws InterruptedException, InvocationTargetException
  {

    SwingUtilities.invokeAndWait(new KIlowBites(args));
  }

  /**
   * Run method for running the code and creating certain buttons.
   */
  public void run()
  {
    ResourceBundle bundle = Language.getLanguageBundle();
    setLookAndFeel();

    JFrame frame = new JFrame(bundle.getString("MainWindow.title"));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel contentPane = (JPanel) frame.getContentPane();
    contentPane.setLayout(new BorderLayout());

    MainWindow mainWindow = new MainWindow();
    contentPane.add(mainWindow, BorderLayout.CENTER);

    String[] courses;
    if ((args == null) || (args.length == 0))
      courses = MENU_OPTION;
    else
      courses = args;
    
    courses.toString(); // Just to shut up Check-Styles S.W.

    MenuController controller = new MenuController();

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu menu;
    JMenuItem item;

    menu = new JMenu(bundle.getString("MainWindow.FileLabel"));
    menuBar.add(menu);
    menu.setActionCommand(FILE);
    item = new JMenuItem(bundle.getString("MainWindow.ExitLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("Exit");
    menu.add(item);

    menu = new JMenu(bundle.getString("MainWindow.EditLabel"));
    menuBar.add(menu);
    item = new JMenuItem(bundle.getString("MainWindow.RecipeLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("Recipe");
    menu.add(item);
    item = new JMenuItem(bundle.getString("MainWindow.MealLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("Meal");
    menu.add(item);

    menu = new JMenu(bundle.getString("MainWindow.SearchLabel"));
    menuBar.add(menu);
    item = new JMenuItem(bundle.getString("MainWindow.RecipesLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
    item.setActionCommand("Recipes");
    menu.add(item);
    item = new JMenuItem(bundle.getString("MainWindow.MealsLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK));
    item.setActionCommand("Meals");
    menu.add(item);

    menu = new JMenu(bundle.getString("MainWindow.ViewLabel"));
    menuBar.add(menu);
    item = new JMenuItem(bundle.getString("MainWindow.ShoppingListLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("ShoppingList");
    menu.add(item);
    item = new JMenuItem(bundle.getString("MainWindow.ProcessLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("Process");
    menu.add(item);

    menu = new JMenu(bundle.getString("MainWindow.ToolsLabel"));
    menuBar.add(menu);
    item = new JMenuItem(bundle.getString("MainWindow.CalorieCalculatorLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("Calorie Calculator");
    menu.add(item);
    item = new JMenuItem(bundle.getString("MainWindow.UnitConverterLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
    item.setActionCommand("Unit Converter");
    menu.add(item);

    menu = new JMenu(bundle.getString("MainWindow.ConfigureLabel"));
    menuBar.add(menu);
    //item = new JMenuItem(bundle.getString("MainWindow.PreferencesLabel"));
    //item.addActionListener(controller);
    //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
    //item.setActionCommand("Preferences");
    //menu.add(item);
    item = new JMenuItem(bundle.getString("MainWindow.ShortcutsLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
    item.setActionCommand("Shortcuts");
    menu.add(item);

    menu = new JMenu(bundle.getString("MainWindow.HelpLabel"));
    menuBar.add(menu);
    item = new JMenuItem(bundle.getString("MainWindow.UserGuideLabel"));
    item.addActionListener(controller);
    item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
        InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    item.setActionCommand("User Guide");
    menu.add(item);

    frame.setSize(300, 200);
    frame.setVisible(true);
  }

  /**
   * Sets the look and feel of KiloBites
   */
  private void setLookAndFeel()
  {
    // Setup the look and feel
    boolean done = false;
    try
    {
      // Use Nimbus if it is available
      UIManager.LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
      for (int i = 0; i < lfs.length && !done; i++)
      {
        if ("Nimbus".equals(lfs[i].getName()))
        {
          UIManager.setLookAndFeel(lfs[i].getClassName());
          done = true;
        }
      }

      // If Nimbus isn't available, use the system look and feel
      if (!done)
      {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
      }
    }
    catch (ClassNotFoundException cnfe)
    {
      // Use the default look and feel
    }
    catch (IllegalAccessException iae)
    {
      // Use the default look and feel
    }
    catch (InstantiationException ie)
    {
      // Use the default look and feel
    }
    catch (UnsupportedLookAndFeelException ulale)
    {
      // Use the default look and feel
    }
  }
}
