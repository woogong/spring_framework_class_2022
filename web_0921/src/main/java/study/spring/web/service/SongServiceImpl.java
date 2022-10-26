package study.spring.web.service;

import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.web.domain.Artist;
import study.spring.web.domain.Song;
import study.spring.web.entity.ArtistEntity;
import study.spring.web.entity.SongEntity;
import study.spring.web.repository.ArtistRepository;
import study.spring.web.repository.SongRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "songService")
public class SongServiceImpl implements SongService {
    private SongRepository songRepository;

    private ArtistRepository artistRepository;

    @Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void prepare() {
        ArtistEntity artist = new ArtistEntity();
        artist.setName("BTS");
        artist.setDebutYear(2013);
        artistRepository.save(artist);

        SongEntity songEntity = new SongEntity();
        songEntity.setTitle("다이너마이트");
        songEntity.setYear(2020);
        songEntity.setComposer("미국사람");
        songEntity.setArtist(artist);
        songRepository.save(songEntity);

        artist = new ArtistEntity();
        artist.setName("블랙핑크");
        artist.setDebutYear(2015);
        artistRepository.save(artist);

        songEntity = new SongEntity();
        songEntity.setTitle("마지막처럼");
        songEntity.setYear(2022);
        songEntity.setComposer("누군가");
        songEntity.setArtist(artist);
        songRepository.save(songEntity);

        songEntity = new SongEntity();
        artist = new ArtistEntity();
        artist.setName("아이유");
        artist.setDebutYear(2005);
        artistRepository.save(artist);

        songEntity.setTitle("드라마");
        songEntity.setYear(2019);
        songEntity.setComposer("작곡가");
        songEntity.setArtist(artist);
        songRepository.save(songEntity);

    }


    @Override
    public Song addSong(Song song) {
        /*
        SongEntity songEntity = new SongEntity(0L,
                song.getTitle(), song.getSinger(), song.getComposer(),
                song.getYear());
         */

        SongEntity songEntity = new SongEntity();
        songEntity.setTitle(song.getTitle());
        songEntity.setComposer(song.getComposer());
        songEntity.setYear(song.getYear());


        songRepository.save(songEntity);

        return song;
    }

    @Override
    public List<Song> getList() {
        List<SongEntity> list = songRepository.findAll();

        List<Song> result = new ArrayList<>();
        for (SongEntity item : list) {
            Song song = new Song(item.getTitle(),
                    item.getComposer(), item.getYear());
            song.setIdx(item.getIdx());

            Artist artist = new Artist();
            artist.setArtistIdx(item.getArtist().getArtistIdx());
            artist.setName(item.getArtist().getName());
            artist.setDebutYear(item.getArtist().getDebutYear());
            song.setArtist(artist);

            result.add(song);
        }

        return result;
    }

    @Override
    public Song read(Long idx) {
        Optional<SongEntity> optional = songRepository.findById(idx);

        if (optional.isPresent()) {
            SongEntity entity = optional.get();
            Song song = new Song(entity.getTitle(),
                    entity.getComposer(), entity.getYear());

            Artist artist = new Artist();
            artist.setArtistIdx(entity.getArtist().getArtistIdx());
            artist.setName(entity.getArtist().getName());
            artist.setDebutYear(entity.getArtist().getDebutYear());
            song.setArtist(artist);

            song.setIdx(entity.getIdx());

            return song;

        } else {
            throw new IllegalArgumentException("잘못된 IDX 입니다.");
        }
    }

    @Override
    public void update(Song song) {
        SongEntity entity = new SongEntity(song.getIdx(), song.getTitle(),
                song.getComposer(), song.getYear());

        songRepository.save(entity);
    }

    @Override
    public void delete(Long idx) {
        songRepository.deleteById(idx);
    }
}
