package ucu.oop_2022_middle.domain_data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
@Entity
@Table
@Getter
@Setter
@ToString

public class DomainData {
    @Id
    @GeneratedValue
    @ToString.Exclude @JsonIgnore
    private int Id;

    @Column(unique = true)
    String name;
    String twitter;
    String facebook;
    String logo;
    String icon;
    String employees;
    String address;

    @ToString.Exclude @JsonIgnore
    @Transient
    boolean dataReady;

    public DomainData(){
        this.name = null;
        this.twitter = null;
        this.facebook = null;
        this.logo = null;
        this.icon = null;
        this.employees = null;
        this.address = null;
    }

    public boolean getDataReady() {
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                if (field.get(this) == null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
    }
}
