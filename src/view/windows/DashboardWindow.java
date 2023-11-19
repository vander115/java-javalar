package view.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.FileManager;
import controller.entities.plan.Plan;
import view.components.Buttons.ActionButton;
import view.containers.Header;
import view.containers.ViewPlan;

public class DashboardWindow extends JFrame {

  public final int PADDING = 24;

  JLabel content;
  Header header;
  Plan plan = new Plan();

  ViewPlan viewPlan = new ViewPlan(plan);

  FileManager fileManager = new FileManager();

  public DashboardWindow() {
    super("Suncat's Javalar");
    setLayout(new BorderLayout());
    setResizable(false);
    setSize(600, 670);
    setIconImage(new ImageIcon("src/view/assets/icons/suncat.png").getImage());
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    content = new JLabel(new ImageIcon("src/view/assets/images/background.png"));
    content.setLayout(new BorderLayout());
    content.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

    header = new Header();
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

  private class NextLineButton extends ActionButton {

    JLabel indicator;

    public NextLineButton() {
      super("instant.png");

      this.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (!plan.isValuesEmpty()) {
            if (plan.instant.getCurrentInstant() < plan.instant.getListOfInstants().size()) {
              plan.simulate();
              viewPlan.revalidateViewCells();
              setIndicator();
              revalidate();
              repaint();
            } else {
              JOptionPane.showMessageDialog(null, "Fim da simulação!", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
          } else {
            JOptionPane.showMessageDialog(null, "Selecione um arquivo!", "Erro", JOptionPane.WARNING_MESSAGE);
          }
        }
      });

    }

    private void setIndicator() {
      if (!plan.isValuesEmpty()) {
        if (indicator != null) {
          this.remove(indicator);
        }
        indicator = new JLabel(plan.instant.getCurrentInstant() + "/" + plan.instant.getListOfInstants().size());
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

      this.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          plan.instant.processInstants();
        }
      });
    }

  }

  private class ReportButton extends ActionButton {
    public ReportButton() {
      super("report.png");
    }
  }

  private class ClassroomButton extends ActionButton {
    public ClassroomButton() {
      super("classroom.png");
    }
  }

  private class SaveButton extends ActionButton {
    public SaveButton() {
      super("save.png");
    }
  }

}
