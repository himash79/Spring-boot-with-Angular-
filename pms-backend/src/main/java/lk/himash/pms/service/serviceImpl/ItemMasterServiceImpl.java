package lk.himash.pms.service.serviceImpl;

import lk.himash.pms.model.ItemMaster;
import lk.himash.pms.repository.ItemMasterRepository;
import lk.himash.pms.service.ItemMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemMasterServiceImpl implements ItemMasterService {

    @Autowired
    private ItemMasterRepository itemMaRepo;

    @Override
    public ResponseEntity<?> getAllItems() {
        List<ItemMaster> list = itemMaRepo.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteItem(String itemId) {
        itemMaRepo.deleteById(itemId);
        return new ResponseEntity("Item " + itemId + " deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveItem(ItemMaster itemObject) {
        ItemMaster item = itemMaRepo.save(itemObject);
        return new ResponseEntity(item, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getItem(String itemId) {
        ItemMaster item = itemMaRepo.findById(itemId).get();
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllAvailableItems(String checkParam) {
        List<ItemMaster> availableItems = itemMaRepo.getAllAvailableItems(checkParam);
        return new ResponseEntity (availableItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFilterPriceItem(String itemPrice) {
        List<ItemMaster> filteredItems = itemMaRepo.getFilterPriceItem(itemPrice);
        return new ResponseEntity(filteredItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFilteredCategoryItems(String catType) {
        List<ItemMaster> filteredItems = itemMaRepo.getFilteredCategoryItems(catType);
        return new ResponseEntity(filteredItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateItem(ItemMaster newItem, String itemId) {
        ItemMaster oldItem = itemMaRepo.findById(itemId).get();
        ItemMaster updatedItem = settleUpdateDetails(oldItem, newItem);
        return new ResponseEntity(updatedItem, HttpStatus.OK);
    }

    private static ItemMaster settleUpdateDetails(ItemMaster oldItem, ItemMaster newItem) {
        oldItem.setItem_name(newItem.getItem_name());
        oldItem.setItem_category(newItem.getItem_category());
        oldItem.setItem_price(newItem.getItem_price());
        oldItem.setItem_status(newItem.getItem_status());
        return newItem;
    }
}
