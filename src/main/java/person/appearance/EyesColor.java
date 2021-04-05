package person.appearance;

import person.appearance.hair.HairColor;

import java.util.Optional;

public enum EyesColor {
    BLUE(0, "голубые"),
    GREEN(1, "зелёные"),
    BROWN(2, "карие"),
    GRAY(3, "серые"),
    DIFF(4, "разные");

    final private int colorID;
    final private String color;

    EyesColor(int colorID, String color) {
        this.colorID = colorID;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getColorID(){
        return colorID;
    }

    public static Optional<String> getByColorID(int colorID) {
        for (EyesColor color : EyesColor.values()) {
            if (color.getColorID() == colorID) {
                return Optional.of(color.getColor());
            }
        }
        return Optional.empty();
    }
}
