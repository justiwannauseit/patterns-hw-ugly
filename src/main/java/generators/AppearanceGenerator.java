package generators;

import person.appearance.Appearance;
import person.appearance.EyesColor;
import person.appearance.hair.*;

import java.util.HashMap;

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
//        switch (i / 2) {
//            case 0:
//                eyes = EyesColor.BLUE.getColor();
//                break;
//            case 1:
//                eyes = EyesColor.GREEN.getColor();
//                break;
//            case 2:
//                eyes = EyesColor.BROWN.getColor();
//                break;
//            case 3:
//                eyes = EyesColor.GRAY.getColor();
//                break;
//            case 4:
//                eyes = EyesColor.DIFF.getColor();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + i / 2);
//        }

        eyesColorID = i/2;
        if (EyesColor.getByColorID(eyesColorID).isPresent()){
            eyes = EyesColor.getByColorID(eyesColorID).get();
        } else throw new IllegalStateException("Unexpected value: " + i / 2);

        hairLength = i;
        if (i > 0 && HairColor.getByColorID(i).isPresent()) {
            hairColor = HairColor.getByColorID(i).get();
        }
    }

    @Override
    public final Appearance buildResponse() {
        Hair hair;
        if (hairLength > 0) {
            hair = (hairLength > 4) ? new LongHair(hairColor) : new ShortHair(hairColor);
        } else {
            hair = new NoHair();
        }
        return new Appearance(eyes, hair);
    }
}

