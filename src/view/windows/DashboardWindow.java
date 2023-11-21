package view.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.entities.plan.Instant;
import controller.entities.plan.Plan;
import controller.entities.planets.Planet;
import controller.files.InstantFileManager;
import view.components.FooterCell;
import view.components.Buttons.ActionButton;
import view.containers.Footer;

import view.containers.Header;
import view.containers.ViewPlan;
import view.style.Fonts;

public class DashboardWindow extends JFrame {

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
    setSize(580, 670);
    setIconImage(new ImageIcon("src/view/assets/icons/suncat.png").getImage());
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    content = new JLabel(new ImageIcon("src/view/assets/images/background.png"));
    content.setLayout(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

    header = new Header();
    footer = new Footer();

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
    ArrayList<Planet> diedPlanets = new ArrayList<Planet>();

    for (Planet planet : plan.getPlanets()) {
      if (planet.getVelocity() <= 0) {
        diedPlanets.add(planet);
      }
    }

    if (diedPlanets.size() == 0) {
      return;
    }

    int width = (diedPlanets.size() * 40) + (diedPlanets.size() - 1 * 8);

    JPanel planetsContent = new JPanel();
    planetsContent.setLayout(new GridLayout(1, diedPlanets.size(), 4, 0));
    planetsContent.setPreferredSize(new Dimension(width, 36));
    planetsContent.setOpaque(false);

    for (Planet diedPlanet : diedPlanets) {
      planetsContent.add(new FooterCell(diedPlanet));
    }

    JLabel label = new JLabel("Planetas que morreram:");
    label.setForeground(Color.WHITE);
    label.setFont(Fonts.upheavalPro(16));
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);

    this.setSize(new Dimension(580, 710));

    content.remove(footer);
    footer.removeAll();
    footer.add(planetsContent, BorderLayout.EAST);
    footer.add(label, BorderLayout.WEST);
    content.add(footer, BorderLayout.SOUTH);

    revalidate();
    repaint();
  }

  private class NextLineButton extends ActionButton {

    JLabel indicator;
    Instant instant = plan.getInstant();

    public NextLineButton() {
      super("instant.png");

      setToolTipText("Processar próximo instante");

      this.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // for (int i = 0; i < plan.getInstant().getListOfInstants().size(); i++) {
          if (!plan.isValuesEmpty()) {
            if (instant.getCurrentInstant() < instant.getListOfInstants().size()) {
              plan.simulate();
              viewPlan.revalidateViewCells();
              setIndicator();
              setFooter();
              revalidate();
              repaint();
              // plan.insertPlan();
            } else {
              JOptionPane.showMessageDialog(null, "Fim da simulação!", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
          } else {
            JOptionPane.showMessageDialog(null, "Selecione um arquivo!", "Erro", JOptionPane.WARNING_MESSAGE);
          }
        }
        // }

      });

    }

    private void setIndicator() {
      if (!plan.isValuesEmpty()) {
        if (indicator != null) {
          this.remove(indicator);
        }
        indicator = new JLabel(instant.getCurrentInstant() + "/" + instant.getListOfInstants().size());
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
          // plan.resetPlan();
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
        public void actionPerformed(ActionEvent e) {
          if (!plan.isValuesEmpty()) {
            plan.insertPlan();
          } else {
            JOptionPane.showMessageDialog(null, "Selecione um arquivo!", "Erro", JOptionPane.WARNING_MESSAGE);
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
        public void actionPerformed(ActionEvent e) {
          plan.getReport().registerReport();
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
        public void actionPerformed(ActionEvent e) {
          try {
            plan.getReport().saveFile();
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
          } catch (Exception e1) {
            e1.printStackTrace();
          }

        }
      });
    }
  }

}
