package testgroup.BOOT_prilozhenie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@AllArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Role(int id) {
        this.id = id;
    }


    @JsonCreator
    public Role(@JsonProperty("name") String name) {
        this.name = name;
    }

    public Role(){

    }
    @Override
    public String getAuthority() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}