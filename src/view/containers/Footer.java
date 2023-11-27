package view.containers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.entities.plan.Plan;
import controller.entities.planets.Planet;
import view.components.ElementDialog;
import view.components.FooterCell;
import view.style.Fonts;

public class Footer extends JPanel {

	private static final long serialVersionUID = 1L;

	Plan plan;

	public Footer(Plan plan) {
		super();
		this.plan = plan;
		setPreferredSize(new Dimension(36, 36));
		setLayout(new BorderLayout());
		setOpaque(false);

		setBorder(BorderFactory.createEmptyBorder(4, 2, 0, 2));

	}

	public void updateFooter() {
		if (plan.getDiedPlanets().isEmpty()) {
			System.out.println("Nenhum planeta explodiu");
			return;
		}

		int width = (plan.getDiedPlanets().size() * 35) + (plan.getDiedPlanets().size() - 1 * 8);

		JPanel planetsContent = new JPanel();
		planetsContent.setLayout(new GridLayout(1, plan.getDiedPlanets().size(), 4, 0));
		planetsContent.setPreferredSize(new Dimension(width, 36));
		planetsContent.setOpaque(false);

		for (Planet diedPlanet : plan.getDiedPlanets()) {
			System.out.println(diedPlanet.getName() + " explodiu");
			FooterCell cell = new FooterCell(diedPlanet);
			cell.addActionListener(getActionListener(diedPlanet));
			planetsContent.add(cell);
		}

		JLabel label = new JLabel("Planetas que explodiram:");
		label.setForeground(Color.WHITE);
		label.setFont(Fonts.upheavalPro(16));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		this.removeAll();
		this.add(planetsContent, BorderLayout.EAST);
		this.add(label, BorderLayout.WEST);

		revalidate();
		repaint();
	}

	public ActionListener getActionListener(Planet diedPlanet) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ElementDialog elementDialog = new ElementDialog(diedPlanet);
				elementDialog.setVisible(true);
			}
		};
	}

}
