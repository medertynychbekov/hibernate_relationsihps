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
@Table(name = "social_medias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int countOfFollower;

    @ManyToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH
    }, fetch = FetchType.LAZY, mappedBy = "socialMedias")
    List<User> users;

    public SocialMedia(String name, int countOfFollower) {
        this.name = name;
        this.countOfFollower = countOfFollower;
    }
}
