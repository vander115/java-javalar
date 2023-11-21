package view.containers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.entities.planets.Planet;
import controller.tools.Utils;

public class Footer extends JPanel {

  public Footer() {
    super();

    setPreferredSize(new Dimension(36, 36));
    setLayout(new BorderLayout());
    setOpaque(false);

    setBorder(BorderFactory.createEmptyBorder(4, 2, 0, 2));

  }

}
