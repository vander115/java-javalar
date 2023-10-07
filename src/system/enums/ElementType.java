package system.enums;

public enum ElementType {
  EMPTY("Vazio"),
  STAR("Estrela"),
  PLANET("Planeta"),
  BUG("Bug"),
  DEVELOPER("Desenvolvedor");

  public String label;

  ElementType(String label) {
    this.label = label;
  }
}
