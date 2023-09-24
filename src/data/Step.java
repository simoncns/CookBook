package data;

import java.io.Serializable;

/**
 * Represents a single step.
 * 
 * @author Stephen Watson
 *
 */
public class Step implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String action;
  private String on;
  private String utensil;
  private String details;
  private boolean stepCompleted;

  
  /**
   * Constructs a single step with an Ingredient and Utensil.
   * 
   * @param action String representing action
   * @param on String representing "on"
   * @param utensil String representing utensil
   * @param details String representing other details
   */
  public Step(final String action, final String on, final String utensil, final String details)
  {
    this.action = action;
    this.on = on;
    this.utensil = utensil;
    this.details = details;
    this.stepCompleted = false; // Step validation.
  }
  
  /**
   * Constructs a single step with an Ingredient and Utensil.
   * 
   * @param action String representing action
   * @param on String representing "on"
   * @param utensil String representing utensil
   */
  public Step(final String action, final String on, final String utensil)
  {
    this.action = action;
    this.on = on;
    this.utensil = utensil;
    this.details = null;
    this.stepCompleted = false; // Step validation.
  } 
 
  /**
   * Marks this step as completed or not.
   * 
   * @param value boolean representing completion
   */
  public void setStepCompleted(final boolean value)
  {
    this.stepCompleted = value;
  }

  /**
   * Gets status of steps completion. 
   * 
   * @return boolean boolean representing completion
   */
  public boolean isStepCompleted()
  {
    return stepCompleted;
  }

  /**
   * String representation of a step.
   * 
   * @return String representation of step
   */
  public String toString()
  {
    if((details == null) || (details.equals("")))
    {
      return String.format("%s %s %s", this.action, this.on, utensil);
    }
    return String.format("%s %s %s %s", this.action, this.on, utensil, details);
  }
}
