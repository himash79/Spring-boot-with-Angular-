package lk.himash.pms.service;

import lk.himash.pms.model.ItemMaster;
import org.springframework.http.ResponseEntity;

public interface ItemMasterService {

    public ResponseEntity<?> getAllItems();

    public ResponseEntity<?> saveItem(ItemMaster itemObject);

    public ResponseEntity<?> getItem(String itemId);

    public ResponseEntity<?> deleteItem(String itemId);

    public ResponseEntity<?> getAllAvailableItems(String checkParam);

    public ResponseEntity<?> getFilterPriceItem(String itemPrice);

    public ResponseEntity<?> getFilteredCategoryItems(String catType);

    public ResponseEntity<?> updateItem(ItemMaster newItem, String itemId);
}
