package view.containers;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.entities.plan.Element;
import controller.entities.plan.Plan;
import view.components.ElementDialog;
import view.components.ViewCell;

public class ViewPlan extends JPanel implements ActionListener {

  Plan plan;
  ViewCell[][] viewCells = new ViewCell[15][15];
  ElementDialog elementDialog;

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
    this.removeAll();
    for (int i = 14; i >= 0; i--) {
      for (int j = 0; j < 15; j++) {
        ViewCell newCell = new ViewCell(plan.getCells()[i][j]);
        newCell.addActionListener(this);
        viewCells[i][j] = newCell;
        add(newCell);
      }
    }
  }

  public void revalidateCells() {
    for (int i = 14; i >= 0; i--) {
      for (int j = 0; j < 15; j++) {
        viewCells[i][j].revalidateIcon();
      }
    }
  }

  public void revalidateViewCells() {
    revalidateCells();
    revalidate();
    repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Element element = ((ViewCell) e.getSource()).getCell().getElement();
    if (element != null) {
      elementDialog = new ElementDialog(element);
      elementDialog.setVisible(true);
    }
  }

}
