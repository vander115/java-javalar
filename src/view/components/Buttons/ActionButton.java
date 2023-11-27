package view.components.Buttons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.style.Paths;

public class ActionButton extends JButton implements MouseListener {

  public ActionButton(String filename) {
    super();
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(40, 40));
    setOpaque(false);
    setBackground(new Color(0, 0, 0, 0));
    addMouseListener(this);

    setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    setIcon(new ImageIcon(Paths.ICONS_PATH + filename));

  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    setCursor(new Cursor(Cursor.HAND_CURSOR));

  }

  @Override
  public void mouseExited(MouseEvent e) {
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
}
