package view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.entities.plan.Element;
import controller.entities.plan.Cell;
import controller.enums.ElementType;
import controller.tools.Utils;

public class ViewCell extends JButton {

  Cell cell;
  ElementType previousElementType;

  public ViewCell(Cell cell) {
    super();
    this.cell = cell;
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(30, 30));
    setOpaque(false);
    setBackground(Color.YELLOW);
    setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));

    previousElementType = cell.getElementType();

    if (cell.getElementType() != ElementType.EMPTY) {
      setIcon();
    }
  }

  public void revalidateIcon() {
    if (cell.getElementType() != previousElementType) {
      if (cell.getElementType() == ElementType.EMPTY) {
        this.setIcon(null);
      } else {
        setIcon();
      }
      previousElementType = cell.getElementType();
    }
  }

  public void setIcon() {
    ImageIcon icon = ((Element) cell.getElement()).getIcon();
    this.setIcon(Utils.resizeImage(icon, 32, 32));
  }

  public ElementType getElementType() {
    return cell.getElementType();
  }

  public Cell getCell() {
    return cell;
  }

}
