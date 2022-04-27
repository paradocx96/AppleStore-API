package com.sliit.api;

import com.sliit.domain.Item;
import com.sliit.domain.ItemDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemApi {

    private final ItemDataAdapter itemDataAdapter;

    @Autowired
    public ItemApi(ItemDataAdapter itemDataAdapter) {
        this.itemDataAdapter = itemDataAdapter;
    }

    public String create(Item item) {
        return itemDataAdapter.create(item);
    }

    public List<Item> getAll() {
        return itemDataAdapter.getAll();
    }

    public Item getById(String id) {
        return itemDataAdapter.getById(id);
    }

    public List<Item> getByType(String type) {
        return itemDataAdapter.getByType(type);
    }

    public String updateById(Item item) {
        return itemDataAdapter.updateById(item);
    }

    public String deleteById(String id) {
        return itemDataAdapter.deleteById(id);
    }
}
