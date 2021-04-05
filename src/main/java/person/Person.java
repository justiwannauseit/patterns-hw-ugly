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

        public PersonBuilder setID(final String id) {
            Person.this.id = id;
            return this;
        }

        public PersonBuilder setFullName(final String fullName) {
            Person.this.fullName = fullName;
            return this;
        }

        public PersonBuilder setPhys(final Physical phys) {
            Person.this.phys = phys;
            return this;
        }

        public PersonBuilder setAppearance(final Appearance appearance) {
            Person.this.appearance = appearance;
            return this;
        }

        public PersonBuilder setPhone(final Phone phone) {
            Person.this.phone = phone;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }


    @Override
    public final String toString() {
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