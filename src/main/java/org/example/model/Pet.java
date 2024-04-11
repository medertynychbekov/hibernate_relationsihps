package org.example.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;

    @ToString.Exclude
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User owner; // хозяин

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
