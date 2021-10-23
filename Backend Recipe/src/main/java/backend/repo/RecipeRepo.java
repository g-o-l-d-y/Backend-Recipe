package backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.model.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

}
