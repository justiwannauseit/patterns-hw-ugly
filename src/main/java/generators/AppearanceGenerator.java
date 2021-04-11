package generators;

import person.appearance.Appearance;
import person.appearance.EyesColor;
import person.appearance.hair.Hair;
import person.appearance.hair.HairColor;
import person.appearance.hair.HairLength;

public class AppearanceGenerator implements Generator<Appearance> {

    private String eyes;
    private int eyesColorID;
    private int hairLength;
    private String hairColor;

    /**
     * Внешность генерируется по третьей цифре кода (i):
     * Глаза: по индексу i/2 (=0..4)
     * Длина волос: i
     * Цвет волос: из enum по индексу i-1 при i>0 (=0..8).
     */
    @Override
    public final void generateParams(final int code) {
        final int i = code % 100 / 10;

        //убрал switch
        eyesColorID = i / 2;
        if (EyesColor.getByColorID(eyesColorID).isPresent()) {
            eyes = EyesColor.getByColorID(eyesColorID).get();
        } else {
            throw new IllegalStateException("Unexpected value: " + i / 2);
        }

        hairLength = i;
        if (i > 0 && HairColor.getByColorID(i).isPresent()) {
            hairColor = HairColor.getByColorID(i).get();
        }
    }

    @Override
    public final Appearance buildResponse() {
        Hair hair = new Hair();
        if (hairLength > 0) {
            if (hairLength > 4) {
                hair.setHairLength(HairLength.LONG);
            } else {
                hair.setHairLength(HairLength.SHORT);
            }
        } else {
            hair.setHairLength(HairLength.BALD);
        }
        hair.setHairColor(HairColor.getByColorName(hairColor));
        return new Appearance(eyes, hair);
    }
}

