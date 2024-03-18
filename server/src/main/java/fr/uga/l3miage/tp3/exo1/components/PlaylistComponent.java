package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import fr.uga.l3miage.tp3.exo1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylist(String name){
        return playlistRepository.findById(name).orElseThrow();
    }

    public PlaylistEntity createPlaylist(PlaylistEntity playlistEntity){
        return playlistRepository.save(playlistEntity);
    }

    public PlaylistEntity updatePlaylist(String name, PlaylistEntity playlistEntity){
        PlaylistEntity pE = playlistRepository.findById(name).orElseThrow();
        pE.setDescription(playlistEntity.getDescription());
        pE.setName(playlistEntity.getName());
        pE.setSongEntities(playlistEntity.getSongEntities());
        pE.setTotalDuration(playlistEntity.getTotalDuration());
        return playlistRepository.save(pE);
    }

    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }

}
