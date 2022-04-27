package com.sliit.dal.repository;

import com.sliit.dal.model.ItemModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<ItemModel, String> {

    List<ItemModel> findByType(String type);
}
