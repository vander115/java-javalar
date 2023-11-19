package view.components.Buttons;

import java.awt.event.ActionListener;

public class ClassroomButton extends ActionButton  {
  public ClassroomButton(ActionListener listener) {
    super("classroom.png");
    this.addActionListener(listener);
  }
}
