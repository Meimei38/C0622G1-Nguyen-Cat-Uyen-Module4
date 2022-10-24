package validate_song.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import validate_song.model.Song;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
}
