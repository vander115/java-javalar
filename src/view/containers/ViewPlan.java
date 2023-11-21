package view.containers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.entities.plan.Plan;
import view.components.ViewCell;

public class ViewPlan extends JPanel {

  Plan plan;
  ViewCell[][] viewCells = new ViewCell[15][15];

  public ViewPlan(Plan plan) {
    super();
    this.plan = plan;

    setPreferredSize(new Dimension(478, 478));
    setSize(new Dimension(478, 478));
    setLayout(new GridLayout(15, 15, 2, 2));

    setOpaque(false);
    setBackground(null);

    setViewCells();

  }

  public void setViewCells() {
    for (int i = 14; i >= 0; i--) {
      for (int j = 0; j < 15; j++) {
        ViewCell newCell = new ViewCell(plan.getCells()[i][j]);
        viewCells[i][j] = newCell;
        add(newCell);
      }
    }
  }

  public void revalidateViewCells() {
    removeAll();
    setViewCells();
    revalidate();
    repaint();
  }

}
