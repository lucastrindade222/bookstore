package br.com.lucas.bookstore.model;

import lombok.*;

;
import javax.persistence.Entity;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Client extends Person {
    private static final long serialVersionUID = 1L;

    private String about;

    public Client(String email, String password, String name, String avatarUrl) {
        super(email, password, name, avatarUrl);
    }

}
