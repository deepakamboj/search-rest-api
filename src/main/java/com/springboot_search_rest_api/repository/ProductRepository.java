package com.springboot_search_rest_api.repository;

import com.springboot_search_rest_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("Select p from Product p where " +
            "p.name like concat('%',:query,'%') " +
            "Or p.description like concat('%',:query,'%')")
//JPQl query-Product is class name and p is alias
    List<Product> searchProducts(@Param("query") String query);

    @Query(value = "Select * from products p where" +
            "p.name like concat('%',:query,'%')" +
            "Or p.description like concat('%',:query,'%')", nativeQuery = true)
//native sql query-products is table name and * at place of alias
    List<Product> searchProductsSql(String query);
}
// In JPQL, always use @Param unless you explicitly compile with-parameters.
// In native SQL, it may work without @Param, but adding it makes your code portable and predictable.
//Spring Data JPA treats JPQL and native queries slightly differently when it comes to parameter name binding.
//JPQL case (needs @Param)
//In JPQL (HQL), Spring parses the query string itself and matches the:parameterName against your method parameters.
//By default, method parameter names are not available at runtime unless compiled with  -parameters.
//Without @Param, the binding fails because Spring can’t figure out which parameter maps to :query.
//Native SQL case (often works without @Param)
//For native queries, Spring doesn’t parse the SQL — it just hands it off to your JPA provider (Hibernate).
//Hibernate will map the :query parameter directly using the position/order of parameters in the method signature if no @Param is given.
//So even if it doesn’t see your real parameter name, it binds arg0 (the first parameter) to :query by position.