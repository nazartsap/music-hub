package com.musichub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Название плейлиста
    @Column(nullable = false)
    private String name;

    // Владелец плейлиста
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    // Треки в плейлисте
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Track> tracks;
}
