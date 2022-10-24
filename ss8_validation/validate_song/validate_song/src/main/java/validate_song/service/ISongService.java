package validate_song.service;

import validate_song.model.Song;

import java.util.List;

public interface ISongService {
    void save(Song song);

    List<Song> findAll();
}
