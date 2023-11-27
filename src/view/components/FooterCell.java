package view.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.entities.planets.Planet;
import controller.tools.Utils;

public class FooterCell extends JButton {

	private static final long serialVersionUID = 1L;

	public FooterCell(Planet planet) {
		super();
		setToolTipText(planet.getName());
		setPreferredSize(new Dimension(30, 30));
		ImageIcon icon = planet.getIcon();
		ImageIcon grayScaledIcon = Utils.convertIconToGrayScale(icon);
		ImageIcon resizedIcon = Utils.resizeImage(grayScaledIcon, 30, 30);
		setIcon(resizedIcon);

		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setBorder(BorderFactory.createEmptyBorder());
	}
}
