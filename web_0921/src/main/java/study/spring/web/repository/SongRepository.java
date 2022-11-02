package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import study.spring.web.domain.Song;
import study.spring.web.entity.SongEntity;

import java.util.List;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

    public List<SongEntity> findByTitle(String title);

    public List<SongEntity> findByYear(int year);

    @Modifying
    @Transactional
    @Query(value = "UPDATE song SET title = :name WHERE idx = :idx", nativeQuery = true)
    public void updateTest(
            @Param(value = "idx") Long idx,
            @Param(value = "name") String name);
}
