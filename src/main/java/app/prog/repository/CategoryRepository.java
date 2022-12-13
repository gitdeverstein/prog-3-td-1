package app.prog.repository;

import app.prog.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    CategoryEntity findByCategoryIdAndName(Integer categoryId, String name);
}
