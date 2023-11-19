package controller.enums;

public enum ElementType {
    EMPTY("Vazio"),
    STAR("Estrela"),
    PLANET("Planeta"),
    BUG("Bug"),
    DEVELOPER("Desenvolvedor");

    private final String LABEL;

    ElementType(String label) {
        LABEL = label;
    }

    public String getLabel() {
        return LABEL;
    }
}
