import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhoneGenerator;
import generators.PhysGenerator;
import person.Person;
import person.Phone;
import person.Physical;
import person.appearance.Appearance;

public class InputProcessor {

    private final FioGenerator fioGenerator = new FioGenerator();
    private final PhysGenerator physGenerator = new PhysGenerator();
    private final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
    private final PhoneGenerator phoneGenerator = new PhoneGenerator();

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);

            fioGenerator.generateParams(intCode);

            //Хотел DTO но зачем, когда можно как то так:
            String DELIMITER = " ";
            final String fullName = fioGenerator.getLastName() +
                    DELIMITER +
                    fioGenerator.getFirstName() +
                    DELIMITER +
                    fioGenerator.getMiddleName();

            physGenerator.generateParams(intCode);
            final Physical physical = physGenerator.buildResponse();
            appearanceGenerator.generateParams(intCode);
            final Appearance appearance = appearanceGenerator.buildResponse();

            Phone phone = null;
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                phoneGenerator.generateParams(intCode);
                phone = phoneGenerator.buildResponse();
            }


            result = Person.personBuilder()
                    .setID(input)
                    .setFullName(fullName)
                    .setPhys(physical)
                    .setAppearance(appearance)
                    .setPhone(phone)
                    .build()
                    .toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
