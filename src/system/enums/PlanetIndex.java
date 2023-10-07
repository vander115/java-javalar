package system.enums;

public enum PlanetIndex {
  PYTHON(1),
  JAVASCRIPT(2),
  RUBY_ON_RAILS(3),
  PHP(4),
  C_SHARP(5),
  C_PLUS_PLUS(6),
  C(7);

  public int value;

  PlanetIndex(int index) {
    value = index;
  }

  public int getValue() {
    return value;
  }

}
