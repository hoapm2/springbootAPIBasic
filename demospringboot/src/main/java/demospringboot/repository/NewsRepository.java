package demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demospringboot.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
		
}
