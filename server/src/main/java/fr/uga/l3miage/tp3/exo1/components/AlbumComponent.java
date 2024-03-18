package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    public AlbumEntity getAlbum (String name){
        return albumRepository.findById(name).orElseThrow();
    }

    public AlbumEntity createAlbum(AlbumEntity album){
        return albumRepository.save(album);
    }

    public AlbumEntity updateAlbum(String albumName, AlbumEntity album){
        AlbumEntity album1 = albumRepository.findById(albumName).orElseThrow();
        album1.setReleaseDate(album.getReleaseDate());
        album1.setTitle(album.getTitle());
        album1.setArtistEntity(album.getArtistEntity());
        album1.setSongEntities(album.getSongEntities());
        return albumRepository.save(album1);
    }

    public void deleteAlbum(String name){
        albumRepository.deleteById(name);
    }
}
