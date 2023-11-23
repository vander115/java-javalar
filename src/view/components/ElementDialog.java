package view.components;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.entities.plan.Element;
import controller.entities.planets.Planet;
import controller.enums.ElementType;
import controller.tools.Utils;
import view.style.Fonts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ElementDialog extends JDialog {

    private Element element;

    JLabel content = new JLabel(new ImageIcon("src/view/assets/images/background.png"));

    public ElementDialog(Element element) {
        super();
        this.element = element;
        setSize(new Dimension(380, 526));
        setLocationRelativeTo(null);
        content.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        if (element.getElementType() == ElementType.PLANET) {
            setPlanetContent();
        }
        add(content);
        revalidate();
        repaint();
    }

    public void setPlanetContent() {
        Planet planet = (Planet) element;

        JLabel icon = new JLabel(Utils.resizeImage(planet.getIcon(), 80, 80));
        JLabel name = new JLabel(planet.getName());
        name.setFont(Fonts.upheavalPro(20));
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);

        JPanel iconContent = new JPanel();
        iconContent.setPreferredSize(new Dimension(280, 125));
        iconContent.setLayout(new BorderLayout());
        iconContent.setOpaque(false);
        iconContent.setBackground(Color.DARK_GRAY);
        iconContent.add(icon, BorderLayout.CENTER);
        iconContent.add(name, BorderLayout.SOUTH);

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

        JPanel description = new JPanel();
        description.setPreferredSize(new Dimension(280, 150));
        description.setLayout(new BorderLayout());
        description.setOpaque(false);

        InformationLabel title = new InformationLabel("Descrição");

        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        JTextArea descriptionLabel = new JTextArea(planet.getDescription());

        descriptionLabel.setPreferredSize(new Dimension(280, 150));
        descriptionLabel.setOpaque(false);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setFont(Fonts.upheavalPro(16));
        descriptionLabel.setEditable(false);

        description.add(title, BorderLayout.NORTH);
        description.add(descriptionLabel, BorderLayout.CENTER);
        this.setIconImage(planet.getIcon().getImage());
        this.setTitle(planet.getName());
        content.add(iconContent, BorderLayout.NORTH);
        content.add(informationContent, BorderLayout.CENTER);
        content.add(description, BorderLayout.SOUTH);
    }

    public class InformationLabel extends JLabel {
        public InformationLabel(String text) {
            super(text);
            setFont(Fonts.upheavalPro(16));
            setForeground(Color.WHITE);
        }
    }

}
