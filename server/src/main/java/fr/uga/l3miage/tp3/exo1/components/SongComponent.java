package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity getSong(String name){
        return songRepository.findById(name).orElseThrow();
    }

    public SongEntity createSong(SongEntity songEntity){
        return songRepository.save(songEntity);
    }

    public SongEntity updateSong(String title, SongEntity songEntity){
        SongEntity sE = songRepository.findById(title).orElseThrow();
        sE.setTitle(songEntity.getTitle());
        sE.setDuration(songEntity.getDuration());
        sE.setArtistEntity(songEntity.getArtistEntity());
        sE.setAlbumEntity(songEntity.getAlbumEntity());
        return songRepository.save(sE);
    }

    public void deleteSong(String title){
        songRepository.deleteById(title);
    }
}
