package data;

import java.io.Serializable;

/**
 * 
 * The Utensil class to make a utensil object with a name and details.
 * 
 * @author BigdaddyAidan.
 *
 */
public class Utensil implements Serializable, Comparable<Utensil>
{
  private static final long serialVersionUID = 1L;
  private String name;
  private String details;

  /**
   * Constructs a Utensil object with a name and detail.
   * 
   * @param name name of utensil
   * @param details other details
   */
  public Utensil(final String name, final String details)
  {
    this.name = name;
    this.details = details;
  }

  /**
   * Constructs a Utensil object with only a name, sets details to null.
   * 
   * @param name name of utensil to be returned
   */
  public Utensil(final String name)
  {
    this.name = name;
    this.details = null;
  }

  /**
   * Getter for the name of the utensil.
   * 
   * @return returns the name of the utensil.
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * CompareTo override.
   * 
   * @return Int representing compared object position
   */
  @Override
  public int compareTo(final Utensil o)
  {
    return this.name.compareTo(o.getName());
  }
  
  /**
   * Method to write a utensil as a string representation.
   * 
   * @return returns the string representation.
   */
  public String toString()
  {
    if (this.details == null)
    {
      return String.format("%s", this.name);
    }
    return String.format("%s (%s)", this.name, this.details);
  }
}
