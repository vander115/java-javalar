package system.stars;

import java.util.ArrayList;

import system.plan.Element;
import system.plan.Position;
import system.enums.ElementType;

public abstract class Star extends Element {
  protected String name;
  protected ArrayList<Position> positions = new ArrayList<>();

  Star(String name) {
    this.name = name;
  }

  public ArrayList<Position> getPositions() {
    return this.positions;
  }

  public ElementType getElementType() {
    return ElementType.STAR;
  }
}
