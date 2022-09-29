package WebDBEx1.WebDBEx1.repositories;

import WebDBEx1.WebDBEx1.model.departmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepo extends JpaRepository<departmentModel, Integer > {
}
