package WebDBEx1.WebDBEx1.repositories;

import WebDBEx1.WebDBEx1.model.instructorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface instructorRepo extends JpaRepository<instructorModel, Integer> {
}
