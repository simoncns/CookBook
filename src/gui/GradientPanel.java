package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * GradientPanel, Creates the gradient for all backgrounds inside of KIlowBites.
 * 
 * @author Max Adams and Stephen
 * @version S2
 *
 */
public class GradientPanel extends JPanel
{
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a GradientPanel.
   */
  public GradientPanel()
  {
    super();
    setLayout(new BorderLayout());
  }

  /**
   * Override for paintComponenet to apply gradient.
   */
  @Override
  protected void paintComponent(final Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    int w = getWidth();
    int h = getHeight();
    GradientPaint gp = new GradientPaint(0, 0, new Color(0, 50, 0), w, 0, new Color(0, 100, 0));
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setPaint(gp);
    g2d.fillRect(0, 0, w, h);
    g2d.dispose();
  }
}
