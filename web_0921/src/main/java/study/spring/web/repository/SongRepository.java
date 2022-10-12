package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.web.entity.SongEntity;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
