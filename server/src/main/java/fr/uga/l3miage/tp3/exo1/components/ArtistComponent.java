package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository ;

    public ArtistEntity getArtist(String name){
        return artistRepository.findById(name).orElseThrow();
    }

    public ArtistEntity createArtist(ArtistEntity artist){
        return artistRepository.save(artist);
    }

    public ArtistEntity updateArtist(String artistName ,ArtistEntity artist ){
        ArtistEntity artist1 = artistRepository.findById(artistName).orElseThrow();
        artist1.setName(artist.getName());
        artist1.setBiography(artist.getBiography());
        artist1.setGenreMusical(artist.getGenreMusical());
        artist1.setAlbumEntities(artist.getAlbumEntities());

        return artistRepository.save(artist1);
    }

    public void deleteAlbums(String name){
        artistRepository.deleteById(name);
    }


}
