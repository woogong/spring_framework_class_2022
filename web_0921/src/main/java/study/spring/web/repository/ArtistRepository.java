package study.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.web.entity.ArtistEntity;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
}
