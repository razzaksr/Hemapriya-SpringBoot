package orm.backend.Jpa_demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Hibernate repositories: interface performs operations via methods to affect the tables
 *  CrudRepository
 *  JpaRepository
 * 
 *  save>> insertion, updation, 
 *  findAll>> readAll, 
 *  findById>> read, 
 *  delete>> deleteById, delete >> void
 */

 /*
  * 
  1. Custom methods via property name without any HQL/SQL:
        read:
            findAllByPropertyName >> multiple records fetched by given property exact match value
  2. Custom methods via Hibernate Query Language:
        HQL completely focus on entity and its property
        eg: from Laptop;// HQL
        eg: Select laptopModel from Laptop;// hql
  3. Custom methods via SQL:
        SQL completely focus on table and its columns
        eg: select * from pc;// sql
        eg: select pc_model from pc;// sql
  */
// CrudRepository<Entity,Type of Primary key property>
@Repository // bean
public interface Manager extends CrudRepository<Laptop,String>{
    // Custom methods without definition
    List<Laptop> findAllByLaptopSsd(int ssd);
    List<Laptop> findAllByLaptopPrice(int price);

    // Custom methods with HQL
    @Query("from Laptop where laptopPrice <= :price")
    List<Laptop> fetchMoreByAmount(int price);
    @Query("Select laptopModel from Laptop")
    List<String> fetchMoreModels();

    // Custom methods with SQL
    @Query(value = "select * from pc where pc_memory>=:size and pc_cost<=:amount",nativeQuery = true)
    List<Laptop> fetchManyBySizeAndAmount(int size,int amount);
}
