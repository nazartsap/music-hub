package com.musichub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Название песни
    @Column(nullable = false)
    private String title;

    // Исполнитель
    @Column(nullable = false)
    private String artist;

    // Путь к файлу (например, audio/filename.mp3)
    private String filePath;

    // Длительность трека (в секундах)
    private int duration;

    // Плейлист, к которому принадлежит
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;
}
