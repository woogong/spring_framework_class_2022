package study.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.web.domain.Song;
import study.spring.web.entity.SongEntity;
import study.spring.web.repository.SongRepository;

@Service(value = "songService")
public class SongServiceImpl implements SongService {
    private SongRepository songRepository;

    @Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
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
        songEntity.setSinger(song.getSinger());
        songEntity.setComposer(song.getComposer());
        songEntity.setPublishingYear(song.getYear());


        songRepository.save(songEntity);

        return song;
    }
}
