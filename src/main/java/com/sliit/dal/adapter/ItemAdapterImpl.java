package com.sliit.dal.adapter;

import com.sliit.dal.model.ItemModel;
import com.sliit.dal.repository.ItemRepository;
import com.sliit.domain.Item;
import com.sliit.domain.ItemDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ItemAdapterImpl implements ItemDataAdapter {

    private final ItemRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ItemAdapterImpl(ItemRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String create(Item item) {
        ItemModel itemModel = new ItemModel();

        try {
            itemModel.setName(item.getName());
            itemModel.setCode(item.getCode());
            itemModel.setAvailableUnit(item.getAvailableUnit());
            itemModel.setPrice(item.getPrice());
            itemModel.setTaxPrice(item.getTaxPrice());
            itemModel.setProductDescription(item.getProductDescription());
            itemModel.setImagePath(item.getImagePath());
            itemModel.setType(item.getType());
            itemModel.setDatetime(item.getDatetime());

            itemModel = repository.save(itemModel);

            return "Item " + itemModel.getCode() + " Create Success";
        } catch (Exception e) {
            return "Item Create ERROR";
        }
    }

    @Override
    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();

        try {
            List<ItemModel> itemModels = repository.findAll();

            for (ItemModel itemModel : itemModels) {
                Item item = new Item();

                item.setId(itemModel.getId());
                item.setName(itemModel.getName());
                item.setCode(itemModel.getCode());
                item.setAvailableUnit(itemModel.getAvailableUnit());
                item.setPrice(itemModel.getPrice());
                item.setTaxPrice(itemModel.getTaxPrice());
                item.setProductDescription(itemModel.getProductDescription());
                item.setImagePath(itemModel.getImagePath());
                item.setType(itemModel.getType());
                item.setDatetime(itemModel.getDatetime());

                items.add(item);
            }
            return items;
        } catch (Exception e) {
            return items;
        }
    }

    @Override
    public Item getById(String id) {
        ItemModel itemModel;
        Item item = new Item();

        try {
            itemModel = repository.findById(id).get();

            item.setId(itemModel.getId());
            item.setName(itemModel.getName());
            item.setCode(itemModel.getCode());
            item.setAvailableUnit(itemModel.getAvailableUnit());
            item.setPrice(itemModel.getPrice());
            item.setTaxPrice(itemModel.getTaxPrice());
            item.setProductDescription(itemModel.getProductDescription());
            item.setImagePath(itemModel.getImagePath());
            item.setType(itemModel.getType());
            item.setDatetime(itemModel.getDatetime());

            return item;
        } catch (NoSuchElementException e) {
            return item;
        }
    }

    @Override
    public List<Item> getByType(String type) {
        List<Item> items = new ArrayList<>();

        try {
            List<ItemModel> itemModels = repository.findByType(type);

            for (ItemModel itemModel : itemModels) {
                Item item = new Item();

                item.setId(itemModel.getId());
                item.setName(itemModel.getName());
                item.setCode(itemModel.getCode());
                item.setAvailableUnit(itemModel.getAvailableUnit());
                item.setPrice(itemModel.getPrice());
                item.setTaxPrice(itemModel.getTaxPrice());
                item.setProductDescription(itemModel.getProductDescription());
                item.setImagePath(itemModel.getImagePath());
                item.setType(itemModel.getType());
                item.setDatetime(itemModel.getDatetime());

                items.add(item);
            }
            return items;
        } catch (Exception e) {
            return items;
        }
    }

    @Override
    public String updateById(Item item) {
        try {
            ItemModel itemModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where("id").is(item.getId())),
                    new Update()
                            .set("name", item.getName())
                            .set("code", item.getCode())
                            .set("availableUnit", item.getAvailableUnit())
                            .set("price", item.getPrice())
                            .set("taxPrice", item.getTaxPrice())
                            .set("productDescription", item.getProductDescription())
                            .set("imagePath", item.getImagePath())
                            .set("type", item.getType())
                            .set("datetime", item.getDatetime()),
                    ItemModel.class
            );

            if (itemModel != null) {
                return "Item " + item.getCode() + " update Success";
            } else {
                return "Item Does not exist";
            }
        } catch (Exception e) {
            return "Item update ERROR";
        }
    }

    @Override
    public String deleteById(String id) {
        ItemModel itemModel = null;

        try {
            itemModel = repository.findById(id).get();
            if (itemModel != null) {
                repository.deleteById(id);
                return "Item delete success";
            } else {
                return "Item Does not exist";
            }
        } catch (NoSuchElementException e) {
            return "Item delete ERROR";
        }
    }
}
