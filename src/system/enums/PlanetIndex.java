package system.enums;

public enum PlanetIndex {
  PYTHON(),
  JAVASCRIPT(),
  RUBY_ON_RAILS(),
  PHP(),
  C_SHARP(),
  C_PLUS_PLUS(),
  C();

  public int indexValue;

  PlanetIndex() {
    this.indexValue = this.ordinal() + 1;
  }

  public int getIndexValue() {
    return indexValue;
  }

}
