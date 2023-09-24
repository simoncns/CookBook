package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.FileIO;

/**
 * MainWindow GUI class that constructs the main screen and allows you to open other screens.
 * 
 * @author Max Adams
 * @version S1
 *
 */
public class MainWindow extends JPanel
{

  private static final long serialVersionUID = 1L;

  /**
   * MainWindow GUI constructor for making the GUI.
   */
  public MainWindow()
  {
	  String userHome = System.getProperty("user.home");
	  Path kiloBitesPath = Paths.get(userHome, "KiloBites");
	  Path savesPath = Paths.get(userHome, "KiloBites", "saves");
	  Path mealsPath = Paths.get(userHome, "KiloBites", "saves", "meals");
	  Path recipePath = Paths.get(userHome, "KiloBites", "saves", "recipes");


      if (!Files.exists(kiloBitesPath)) 
      {
        try {
          Files.createDirectory(kiloBitesPath);
        } catch (IOException e) {
          System.err.println("Failed to create directory: " + e.getMessage());
        }
      }

      if (!Files.exists(savesPath)) 
      {
        try {
          Files.createDirectory(savesPath);
        } catch (IOException e) {
          System.err.println("Failed to create directory: " + e.getMessage());
        }
      }

      if (!Files.exists(mealsPath)) 
      {
        try {
          Files.createDirectory(mealsPath);
        } catch (IOException e) {
          System.err.println("Failed to create directory: " + e.getMessage());
        }
      }
      
      if (!Files.exists(recipePath)) 
      {
        try {
          Files.createDirectory(recipePath);
        } catch (IOException e) {
          System.err.println("Failed to create directory: " + e.getMessage());
        }
      }
    setLayout(new BorderLayout());
    ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("KILowBites_Logo.png"));
    //ImageIcon imageIcon = new ImageIcon("resources/KILowBites_Logo.png");
    JLabel imageLabel = new JLabel(imageIcon);
    JPanel containerPanel = new GradientPanel();
    containerPanel.add(imageLabel, BorderLayout.CENTER);
    add(containerPanel, BorderLayout.CENTER);
    int width = 300;
    int height = width * imageIcon.getIconHeight() / imageIcon.getIconWidth();
    imageLabel.setPreferredSize(new Dimension(width, height));
  }
}
