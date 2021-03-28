package src.main.java.com.jadevirek.prescriptionapp.model.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonDeserialize(builder = PrescriptionDto.PrescriptionDtoBuilder.class)
public class PrescriptionDto implements Serializable {

    private Long id;
    private String serialNumber;
    private String description;
    private LocalDateTime date;

    /**
     * Default constructor using for ModelMapper if class has no builder
     */
    public PrescriptionDto() {
    }

    public PrescriptionDto(Long id, String serialNumber, String description, LocalDateTime date) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.description = description;
        this.date = date;
    }

    public static PrescriptionDtoBuilder builder() {
        return new PrescriptionDtoBuilder();
    }

    @JsonPOJOBuilder(withPrefix = "set", buildMethodName = "build")
    public static class PrescriptionDtoBuilder {
        private Long id;
        private String serialNumber;
        private String description;
        private LocalDateTime date;

        public PrescriptionDtoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PrescriptionDtoBuilder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public PrescriptionDtoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PrescriptionDtoBuilder setDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public PrescriptionDto build() {
            return new PrescriptionDto(id, serialNumber, description, date);
        }

        public Long getId() {
            return id;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public String getDescription() {
            return description;
        }

        public LocalDateTime getDate() {
            return date;
        }
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PrescriptionDto{");
        sb.append("id=")
                .append(id);
        sb.append(", serialNumber='")
                .append(serialNumber)
                .append('\'');
        sb.append(", description='")
                .append(description)
                .append('\'');
        sb.append(", date=")
                .append(date);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionDto that = (PrescriptionDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, description, date);
    }
}
