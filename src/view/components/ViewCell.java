package view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import javax.swing.JPanel;
import javax.swing.JLabel;

import controller.entities.plan.Element;
import controller.entities.plan.Cell;
import controller.enums.ElementType;

public class ViewCell extends JPanel {

  Cell cell;
  JLabel labelIcon = new JLabel();

  public ViewCell(Cell cell) {
    super();
    this.cell = cell;
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(30, 30));
    setOpaque(false);
    setBackground(Color.YELLOW);
    setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));

    labelIcon.setLayout(new BorderLayout());
    labelIcon.setPreferredSize(new Dimension(30, 30));
    labelIcon.setOpaque(true);
    labelIcon.setVisible(true);

    if (cell.getElementType() != ElementType.EMPTY) {
      labelIcon.setIcon(((Element) cell.getElement()).getIcon());
      this.add(labelIcon, BorderLayout.CENTER);
    }

  }
}
