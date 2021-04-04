package person.appearance;

public enum EyesColor {
    BLUE("голубые"),
    GREEN("зелёные"),
    BROWN("карие"),
    GRAY("серые"),
    DIFF("разные");

    final private String color;

    EyesColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
