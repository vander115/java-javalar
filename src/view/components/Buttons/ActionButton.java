package view.components.Buttons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ActionButton extends JButton {

  private final String DEFAULT_PATH = "src/view/assets/icons/";

  public ActionButton(String filename) {
    super();
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(40, 40));
    setOpaque(false);
    setBackground(new Color(0, 0, 0, 0));

    setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    setIcon(new ImageIcon(DEFAULT_PATH + filename));
   
  }
}
