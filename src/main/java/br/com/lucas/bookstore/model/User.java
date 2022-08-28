package br.com.lucas.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String name;
    private String avatarUrl;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Role role;

    public User( String email, String password,String name,String avatarUrl) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    @JsonIgnore
    public List<Role> getRoles() {
        var list = Arrays.asList(this.role);
        return list;
    }





}
