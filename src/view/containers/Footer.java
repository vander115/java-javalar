package view.containers;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Footer extends JPanel {

  public Footer() {
    super();

    setPreferredSize(new Dimension(36, 36));
    setLayout(new BorderLayout());
    setOpaque(false);

    setBorder(BorderFactory.createEmptyBorder(4, 2, 0, 2));

  }

}
