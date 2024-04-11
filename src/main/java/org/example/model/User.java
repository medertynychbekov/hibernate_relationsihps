package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;

    @ToString.Exclude
    @OneToOne(cascade = {
            CascadeType.REMOVE,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id")
    Passport passport;

    @ToString.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "owner")
    List<Pet> pets;

    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.REMOVE,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_and_social_medias",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "social_media_id"))
    List<SocialMedia> socialMedias;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
