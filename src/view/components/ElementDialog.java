package view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.entities.modifiers.Bug;
import controller.entities.modifiers.Developer;
import controller.entities.plan.Element;
import controller.entities.planets.Planet;
import controller.entities.stars.Star;
import controller.tools.Utils;
import view.style.Fonts;
import view.style.Paths;

public class ElementDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private Element element;

	JLabel content = new JLabel(new ImageIcon(Paths.BACKGROUND_PATH));

	public ElementDialog(Element element) {
		super();
		this.element = element;
		setSize(new Dimension(380, 526));
		setLocationRelativeTo(null);
		content.setLayout(new BorderLayout());
		content.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
		setElementContent(element);
		add(content);
		revalidate();
		repaint();
	}

	public void setElementContent(Element element) {
		switch (element.getElementType()) {
		case PLANET:
			setPlanetContent();
			return;
		case BUG:
			setBugContent();
			return;
		case DEVELOPER:
			setDevContent();
			return;
		case STAR:
			setStarContent();
			return;
		default:
			return;
		}
	}

	public void setPlanetContent() {
		Planet planet = (Planet) element;

		JPanel iconContent = setIconContent(planet.getIcon(), planet.getName());

		JPanel informationContent = new JPanel();
		informationContent.setPreferredSize(new Dimension(280, 100));
		informationContent.setLayout(new GridLayout(7, 1));
		informationContent.setOpaque(false);

		informationContent.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0));

		informationContent.add(new InformationLabel("Status: " + (planet.isAlive() ? "Vivo" : "Explodiu")));
		informationContent.add(new InformationLabel("Velocidade: " + planet.getVelocity()));
		informationContent.add(new InformationLabel(
				"Posição Atual: ( " + planet.getPosition().getX() + ", " + planet.getPosition().getY() + " )"));
		informationContent.add(new InformationLabel("Colisão com Bugs " + planet.getNumberOfBugsCollisions()));
		informationContent.add(new InformationLabel("Colisão com Devs " + planet.getNumberOfDevsCollisions()));
		informationContent.add(new InformationLabel("Horas passadas: " + planet.getTime().getPassedHours()));
		informationContent.add(new InformationLabel("Anos passados: " + planet.getNumberOfTranslations()));

		JPanel description = setDescription(planet.getDescription());

		setWindowInformations(planet.getIcon(), planet.getName());
		content.add(iconContent, BorderLayout.NORTH);
		content.add(informationContent, BorderLayout.CENTER);
		content.add(description, BorderLayout.SOUTH);
	}

	public void setBugContent() {
		Bug bug = (Bug) element;

		JPanel iconContent = setIconContent(bug.getIcon(), "Bug");

		JPanel informationContent = new JPanel();
		informationContent.setPreferredSize(new Dimension(280, 100));
		informationContent.setLayout(new GridLayout(1, 1));
		informationContent.setOpaque(false);

		informationContent.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0));

		informationContent.add(new InformationLabel(
				"Posição: ( " + bug.getPosition().getX() + ", " + bug.getPosition().getY() + " )"));

		JPanel description = setDescription(bug.getDescription());

		setWindowInformations(bug.getIcon(), "Bug");
		content.add(iconContent, BorderLayout.NORTH);
		content.add(informationContent, BorderLayout.CENTER);
		content.add(description, BorderLayout.SOUTH);
	}

	public void setDevContent() {
		Developer dev = (Developer) element;

		JPanel iconContent = setIconContent(dev.getIcon(), "Desenvolvedor");

		JPanel informationContent = new JPanel();
		informationContent.setPreferredSize(new Dimension(280, 100));
		informationContent.setLayout(new GridLayout(1, 1));
		informationContent.setOpaque(false);

		informationContent.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0));

		informationContent.add(new InformationLabel(
				"Posição: ( " + dev.getPosition().getX() + ", " + dev.getPosition().getY() + " )"));

		JPanel description = setDescription(dev.getDescription());

		setWindowInformations(dev.getIcon(), "Desenvolvedor");
		content.add(iconContent, BorderLayout.NORTH);
		content.add(informationContent, BorderLayout.CENTER);
		content.add(description, BorderLayout.SOUTH);
	}

	public void setStarContent() {
		Star star = (Star) element;

		JPanel iconContent = setIconContent(star.getIcon(), star.getName());

		JPanel informationContent = new JPanel();
		informationContent.setPreferredSize(new Dimension(280, 100));
		informationContent.setLayout(new GridLayout(1, 1));
		informationContent.setOpaque(false);

		informationContent.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0));

		informationContent.add(new InformationLabel(
				"Posição: ( " + star.getPositions().get(0).getX() + ", " + star.getPositions().get(0).getY() + " )"));

		JPanel description = setDescription(star.getDescription());

		setWindowInformations(star.getIcon(), star.getName());
		content.add(iconContent, BorderLayout.NORTH);
		content.add(informationContent, BorderLayout.CENTER);
		content.add(description, BorderLayout.SOUTH);
	}

	public JPanel setDescription(String description) {
		JPanel descriptionContent = new JPanel();
		descriptionContent.setPreferredSize(new Dimension(280, 200));
		descriptionContent.setLayout(new BorderLayout());
		descriptionContent.setOpaque(false);

		InformationLabel title = new InformationLabel("Descrição");

		title.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);

		JTextArea descriptionLabel = new JTextArea(description);

		descriptionLabel.setPreferredSize(new Dimension(280, 200));
		descriptionLabel.setOpaque(false);
		descriptionLabel.setLineWrap(true);
		descriptionLabel.setForeground(Color.WHITE);
		descriptionLabel.setWrapStyleWord(true);
		descriptionLabel.setFont(Fonts.upheavalPro(16));
		descriptionLabel.setEditable(false);

		descriptionContent.add(title, BorderLayout.NORTH);
		descriptionContent.add(descriptionLabel, BorderLayout.CENTER);

		return descriptionContent;
	}

	public JPanel setIconContent(ImageIcon icon, String name) {
		JLabel iconLabel = new JLabel(Utils.resizeImage(icon, 80, 80));
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(Fonts.upheavalPro(20));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setVerticalAlignment(JLabel.CENTER);

		JPanel iconContent = new JPanel();
		iconContent.setPreferredSize(new Dimension(280, 125));
		iconContent.setLayout(new BorderLayout());
		iconContent.setOpaque(false);
		iconContent.setBackground(Color.DARK_GRAY);
		iconContent.add(iconLabel, BorderLayout.CENTER);
		iconContent.add(nameLabel, BorderLayout.SOUTH);

		return iconContent;
	}

	public void setWindowInformations(ImageIcon icon, String name) {
		this.setIconImage(icon.getImage());
		this.setTitle(name);
	}

	public class InformationLabel extends JLabel {
		public InformationLabel(String text) {
			super(text);
			setFont(Fonts.upheavalPro(16));
			setForeground(Color.WHITE);
		}
	}

}
