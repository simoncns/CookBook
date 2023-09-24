package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import data.Meal;
import data.Recipe;

/**
 * Utility for File IO.
 * 
 * @author Stephen Watson
 *
 */
public class FileIO
{
  private static final String RECIPE = ".rcp";
  private static final String MEAL = ".mel";
  private static final String BACKSLASH = "\\";

  /**
   * Reads in selected recipes.
   * 
   * @param path
   * @return Recipe
   */
  public static Recipe readRecipe(final Path path)
  {
    Recipe recipe;

    try
    {
      FileInputStream fileInputStream = new FileInputStream(path.toFile());
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      recipe = (Recipe) objectInputStream.readObject();

      fileInputStream.close();
      objectInputStream.close();
    }
    catch (IOException | ClassNotFoundException e)
    {
      recipe = null;
    }

    return recipe;
  }

  /**
   * Writes recipes to a file.
   * 
   * @param recipe
   * @param path
   * @param filename
   * @return boolean
   */
  public static boolean writeRecipe(final Recipe recipe, final Path path, final String filename)
  {
    try
    {

      if (!path.toFile().exists())
      {
        Files.createDirectories(path);
      }

      File file = new File(path.toString() + BACKSLASH + filename + RECIPE);

      FileOutputStream fileOut = new FileOutputStream(file);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(recipe);
      out.close();
      fileOut.close();
    }
    catch (IOException e)
    {
      return false;
    }
    return true;
  }

  /**
   * Reads in a selected Meal.
   * 
   * @param path
   * @return Meal
   */
  public static Meal readMeal(final Path path)
  {
    Meal meal;

    try
    {
      FileInputStream fileInputStream = new FileInputStream(path.toFile());
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      meal = (Meal) objectInputStream.readObject();

      fileInputStream.close();
      objectInputStream.close();
    }
    catch (IOException | ClassNotFoundException e)
    {
      meal = null;
    }

    return meal;
  }

  /**
   * Writes a given Meal.
   *
   * @param meal
   * @param path
   * @param filename
   * @return boolean
   */
  public static boolean writeMeal(final Meal meal, final Path path, final String filename)
  {
    try
    {

      if (!path.toFile().exists())
      {
        Files.createDirectories(path);
      }

      File file = new File(path.toString() + BACKSLASH + filename + MEAL);

      FileOutputStream fileOut = new FileOutputStream(file);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(meal);
      out.close();
      fileOut.close();
    }
    catch (IOException e)
    {
      return false;
    }
    return true;
  }
}
