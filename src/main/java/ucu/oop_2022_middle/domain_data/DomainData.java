package ucu.oop_2022_middle.domain_data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table
@Builder
public class DomainData {
    @Id
    @GeneratedValue
    private Long id;

//    @Column(unique = true)
    private String domain;
    private String name;
    private String twitter;
    private String facebook;
    private String logo;
    private String icon;
    private String employees;
    private String address;

//    @ToString.Exclude @JsonIgnore
//    @Transient
//    boolean dataReady;

//    public boolean getDataReady() {
//        for (Field field : this.getClass().getDeclaredFields()) {
//            try {
//                if (field.get(this) == null) {
//                    return false;
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }
//
//    public String toJson() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        return ow.writeValueAsString(this);
//    }
}
