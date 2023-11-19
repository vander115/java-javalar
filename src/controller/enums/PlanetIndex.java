package controller.enums;

public enum PlanetIndex {
    PYTHON(1),
    JAVASCRIPT(2),
    RUBY_ON_RAILS(3),
    PHP(4),
    C_SHARP(5),
    C_PLUS_PLUS(6),
    C(7);

    private final int VALUE;

    PlanetIndex(int index) {
        VALUE = index;
    }

    public int getValue() {
        return VALUE;
    }

}
