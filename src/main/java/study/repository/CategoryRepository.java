package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
