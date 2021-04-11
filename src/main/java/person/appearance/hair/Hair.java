package person.appearance.hair;

import java.util.Optional;

public class Hair {

    private HairLength hairLength;
    private Optional<HairColor> hairColor;

    public final HairLength getHairLength() {
        return hairLength;
    }

    public final void setHairLength(final HairLength hairLength) {
        this.hairLength = hairLength;
    }

    public final Optional<HairColor> getHairColor() {
        return hairColor;
    }

    public final void setHairColor(final Optional<HairColor> hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * @return получение длинны и цвета волос.
     */
    @Override
    public String toString() {
        return hairColor.map(color -> hairLength.getHairLength() + ", " + color.getColor()).orElse("нет");
    }

}
