package person.appearance.hair;

import java.util.Optional;

public enum HairColor {

    BLACK(1, "чёрные"),
    BROWN(2, "каштановые"),
    GINGER(3, "рыжие"),
    BLONDE(4, "светлые"),
    WHITE(5, "седые"),
    PINK(6, "розовые"),
    GREEN(7, "зелёные"),
    PURPLE(8, "фиолетовые"),
    BLUE(9, "синие");

    private final int colorID;
    private final String color;

    HairColor(int colorID, String color) {
        this.colorID = colorID;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getColorID() {
        return colorID;
    }

    public static Optional<String> getByColorID(int colorID) {
        for (HairColor color : HairColor.values()) {
            if (color.getColorID() == colorID) {
                return Optional.of(color.getColor());
            }
        }
        return Optional.empty();
    }
}
