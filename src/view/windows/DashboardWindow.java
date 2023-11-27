package view.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.entities.plan.Plan;
import model.files.InstantFileManager;
import view.components.Buttons.ActionButton;
import view.containers.Footer;
import view.containers.Header;
import view.containers.ViewPlan;
import view.style.Paths;
import view.style.Sizes;

public class DashboardWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public final int PADDING = 24;

	JLabel content;
	Header header;
	Footer footer;
	Plan plan = new Plan();

	ViewPlan viewPlan = new ViewPlan(plan);

	InstantFileManager fileManager = new InstantFileManager();

	public DashboardWindow() {
		super("Suncat's Javalar");
		setLayout(new BorderLayout());
		setResizable(false);
		setSize(Sizes.WINDOW_DIMENSION);
		setIconImage(new ImageIcon(Paths.JAVALAR_ICON_PATH).getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		content = new JLabel(new ImageIcon(Paths.BACKGROUND_PATH));
		content.setLayout(new BorderLayout());
		content.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

		header = new Header();
		footer = new Footer(plan);

		setButtonsContainer();

		content.add(header, BorderLayout.NORTH);
		content.add(viewPlan, BorderLayout.CENTER);

		setContentPane(content);
		revalidate();
		repaint();
	}

	public void setButtonsContainer() {
		JPanel buttonsContainer = new JPanel();
		buttonsContainer.setLayout(new GridLayout(1, 5, 8, 0));
		buttonsContainer.setPreferredSize(new Dimension(240, 40));
		buttonsContainer.setOpaque(false);
		buttonsContainer.setBackground(null);

		buttonsContainer.add(new NextLineButton());
		buttonsContainer.add(new UploadButton());
		buttonsContainer.add(new ReportButton());
		buttonsContainer.add(new ClassroomButton());
		buttonsContainer.add(new SaveButton());

		header.add(buttonsContainer, BorderLayout.EAST);
	}

	public void setFooter() {

		if (plan.getDiedPlanets().isEmpty()) {
			return;
		}

		this.setSize(new Dimension(580, 700));
		content.remove(footer);
		footer.updateFooter();
		content.add(footer, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}

	public void resetPlan() {
		plan.resetPlan();
		viewPlan.setViewCells();
		viewPlan.revalidateViewCells();
		this.remove(footer);
		this.setSize(Sizes.WINDOW_DIMENSION);
	}

	private class NextLineButton extends ActionButton {

		JLabel indicator;

		public NextLineButton() {
			super("instant.png");

			setToolTipText("Processar próximo instante");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!plan.isValuesEmpty()) {
						if (plan.getInstant().getCurrentInstant() < plan.getInstant().getListOfInstants().size()) {
							plan.simulate();
							viewPlan.revalidateViewCells();
							setIndicator();
							setFooter();
						} else {
							JOptionPane.showMessageDialog(null, "Fim da simulação!", "Atenção",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um arquivo!", "Erro",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			});

		}

		private void setIndicator() {
			if (!plan.isValuesEmpty()) {
				if (indicator != null) {
					this.remove(indicator);
				}
				indicator = new JLabel(
						plan.getInstant().getCurrentInstant() + "/" + plan.getInstant().getListOfInstants().size());
				indicator.setForeground(Color.WHITE);
				indicator.setFont(new Font("Arial Bold", Font.BOLD, 8));
				indicator.setHorizontalAlignment(JLabel.CENTER);
				this.add(indicator, BorderLayout.SOUTH);
			}
		}
	}

	private class UploadButton extends ActionButton {
		public UploadButton() {
			super("upload.png");

			setToolTipText("Ler novo arquivo de entrada");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					resetPlan();
					plan.getInstant().processInstants();

					if (!plan.isValuesEmpty()) {
						setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					}
				}
			});
		}

	}

	private class ReportButton extends ActionButton {
		public ReportButton() {
			super("report.png");
			setToolTipText("Gerar relatório");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					if (!plan.isValuesEmpty()) {
						new Thread(plan).start();
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um arquivo!", "Erro",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			});
		}
	}

	private class ClassroomButton extends ActionButton {
		public ClassroomButton() {
			super("classroom.png");

			setToolTipText("Ler dados do grupo");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					try {
						new Thread(plan.getReport()).start();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao ler dados!", "Erro", JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				}
			});
		}
	}

	private class SaveButton extends ActionButton {
		public SaveButton() {
			super("save.png");
			setToolTipText("Salvar arquivo de saída");

			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					try {
						plan.getReport().saveFile();
						JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo!", "Erro",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				}
			});
		}
	}

}
