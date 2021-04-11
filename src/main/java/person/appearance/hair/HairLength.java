package person.appearance.hair;

import java.util.Optional;

public enum HairLength {

    LONG("длинные"),
    SHORT("короткие"),
    BALD("нет");

    private final String hairLength;

    HairLength(final String hairLength) {
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    public static Optional<HairLength> getByHairLengthName(final String hairLength) {
        for (HairLength length: HairLength.values()) {
            if (length.getHairLength().equals(hairLength)) {
                return Optional.of(length);
            }
        }
        return Optional.empty();
    }
}
