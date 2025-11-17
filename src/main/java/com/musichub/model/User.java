package com.musichub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users") // лучше всегда указывать имя таблицы
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // Один юзер может иметь много плейлистов
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Playlist> playlists;
}
