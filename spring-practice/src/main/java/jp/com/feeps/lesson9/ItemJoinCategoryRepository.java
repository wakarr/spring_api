package jp.com.feeps.lesson9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemJoinCategoryRepository extends JpaRepository<ItemJoinCategory, Integer> {
	
	@Query("SELECT ic FROM ItemJoinCategory ic WHERE ic.price >= :price")
	List<ItemJoinCategory> findByPriceGreaterThanEqualInputPriceQuery(@Param("price") int price);

}
