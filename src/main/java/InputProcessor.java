import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhoneGenerator;
import generators.PhysGenerator;
import person.Person;
import person.Phone;
import person.Physical;
import person.appearance.Appearance;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);

            final FioGenerator fioGenerator = new FioGenerator();
            fioGenerator.generateParams(intCode);
            //DTO скорее всего. Собирается полное имя сразу в одном стринге ();
            String fullName = fioGenerator.getLastName() + " " + fioGenerator.getFirstName() + " " + fioGenerator.getMiddleName();

            final PhysGenerator physGenerator = new PhysGenerator();
            physGenerator.generateParams(intCode);
            final Physical physical = physGenerator.buildResponse();

            final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
            appearanceGenerator.generateParams(intCode);
            final Appearance appearance = appearanceGenerator.buildResponse();

            Phone phone = null;
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                final PhoneGenerator phoneGenerator = new PhoneGenerator();
                phoneGenerator.generateParams(intCode);
                phone = phoneGenerator.buildResponse();
            }

            result = new Person(input,
                    fullName,
                    physical,
                    appearance,
                    phone).toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}
