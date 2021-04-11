package person;

import person.appearance.Appearance;

public final class Person {

    private String id;
    private String fullName;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    //использовал патерн Builder
    private Person() {
    }

    public static PersonBuilder personBuilder() {
        return new Person().new PersonBuilder();
    }

    public final class PersonBuilder {

        private PersonBuilder() {
        }

        //написал имя принемаемой как "value" из-за CheckStyle
        public PersonBuilder setID(final String value) {
            Person.this.id = value;
            return this;
        }

        public PersonBuilder setFullName(final String value) {
            Person.this.fullName = value;
            return this;
        }

        public PersonBuilder setPhys(final Physical value) {
            Person.this.phys = value;
            return this;
        }

        public PersonBuilder setAppearance(final Appearance value) {
            Person.this.appearance = value;
            return this;
        }

        public PersonBuilder setPhone(final Phone value) {
            Person.this.phone = value;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(fullName).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}