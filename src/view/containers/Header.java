package view.containers;

import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {

  public Header() {
    super();
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(522, 56));
    setBorder(BorderFactory.createEmptyBorder(0, 0, 16, 0));
    setOpaque(false);
    setBackground(null);

    setLogo();
  }

  public void setLogo() {
    JLabel logo = new JLabel(new ImageIcon("src/view/assets/images/logo.png"));
    logo.setPreferredSize(new Dimension(126, 32));
    this.add(logo, BorderLayout.WEST);
  }

}
