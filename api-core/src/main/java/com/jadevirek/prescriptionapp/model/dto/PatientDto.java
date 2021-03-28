package src.main.java.com.jadevirek.prescriptionapp.model.dto;

import java.io.Serializable;

public class PatientDto implements Serializable {

    private Long id;
    private String fName;
    private String sName;
    private String pesel;
    private String email;
    private String address;
    private String age;


    private PatientDto(Long id, String fName, String sName, String pesel, String email, String address, String age) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.pesel = pesel;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    private PatientDto() {
    }

    /**
     * Factory method
     */
    public static PatientDtoBuilder builder() {
        return new PatientDtoBuilder();
    }

    /**
     * Builder pattern for PatientDto
     */
    public static class PatientDtoBuilder {
        private Long id;
        private String fName;
        private String sName;
        private String pesel;
        private String email;
        private String address;
        private String age;

        public PatientDto build() {
            return new PatientDto(id, fName, sName, pesel, email, address, age);
        }

        public PatientDtoBuilder setfName(String fName) {
            this.fName = fName;
            return this;
        }

        public PatientDtoBuilder setsName(String sName) {
            this.sName = sName;
            return this;
        }

        public PatientDtoBuilder setPesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public PatientDtoBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PatientDtoBuilder setAge(String age) {
            this.age = age;
            return this;
        }

        public PatientDtoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PatientDtoBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
    }
}
