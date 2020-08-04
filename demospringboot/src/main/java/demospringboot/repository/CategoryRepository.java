package demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demospringboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
		CategoryEntity findOneByCode(String code);
}
