package lk.himash.pms.repository;

import lk.himash.pms.model.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, String> {

    @Query("SELECT a FROM ItemMaster a WHERE a.item_status = :itemStatus")
    public List<ItemMaster> getAllAvailableItems(@Param("itemStatus") String itemStatus);

    @Query("SELECT a FROM ItemMaster a WHERE a.item_price >= :itemPrice ")
    public List<ItemMaster> getFilterPriceItem(@Param("itemPrice") String itemPrice);

    @Query("SELECT a FROM ItemMaster a WHERE a.item_category = :catType ")
    public List<ItemMaster> getFilteredCategoryItems(@Param("catType") String itemCategory);

}
