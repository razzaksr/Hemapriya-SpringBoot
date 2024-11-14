package orm.backend.Jpa_demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Hibernate repositories: interface performs operations via methods to affect the tables
 *  CrudRepository
 *  JpaRepository
 * 
 *  save>> insertion, updation, 
 *  findAll>> read, 
 *  findById>> read, 
 *  delete>> deleteById, delete >> void
 */
// CrudRepository<Entity,Type of Primary key property>
@Repository // bean
public interface Manager extends CrudRepository<Laptop,String>{
    
}
