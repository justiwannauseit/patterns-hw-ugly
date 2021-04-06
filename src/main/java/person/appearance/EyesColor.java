package person.appearance;

import java.util.Optional;

public enum EyesColor {
    BLUE(0, "голубые"),
    GREEN(1, "зелёные"),
    BROWN(2, "карие"),
    GRAY(3, "серые"),
    DIFF(4, "разные");

    private final int colorID;
    private final String color;

    EyesColor(final int colorID, final String color) {
        this.colorID = colorID;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getColorID() {
        return colorID;
    }

    public static Optional<String> getByColorID(final int colorID) {
        for (EyesColor color : EyesColor.values()) {
            if (color.getColorID() == colorID) {
                return Optional.of(color.getColor());
            }
        }
        return Optional.empty();
    }
}
