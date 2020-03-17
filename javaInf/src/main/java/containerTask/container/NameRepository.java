package containerTask.container;

import containerTask.model.Name;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {
}
