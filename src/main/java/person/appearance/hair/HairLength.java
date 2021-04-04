package person.appearance.hair;

public enum HairLength {
    LONG ("длинные"),
    BALD ("нет"),
    SHORT ("короткие");

    private final String hairLength;

    HairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }
}

