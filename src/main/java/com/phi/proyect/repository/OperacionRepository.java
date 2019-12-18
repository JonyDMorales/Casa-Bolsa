package com.phi.proyect.repository;

import com.phi.proyect.models.Operacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/*Se debe crear un crud por tabla*/

@Repository
public interface OperacionRepository extends CrudRepository<Operacion, Long> {
}
