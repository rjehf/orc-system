package pl.kazmierski.orcsystem2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
public interface GraphicRepo extends CrudRepository<Graphic, Long> {
}
