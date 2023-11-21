package view.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import controller.entities.planets.Planet;
import controller.tools.Utils;

public class FooterCell extends JButton {
  public FooterCell(Planet planet) {
    super();
    setToolTipText(planet.getName());
    setPreferredSize(new Dimension(30, 30));
    setIcon(Utils.convertIconToGrayScale(planet.getIcon()));

    setOpaque(false);
    setBackground(new Color(0, 0, 0, 0));
    setBorder(BorderFactory.createEmptyBorder());
  }
}
