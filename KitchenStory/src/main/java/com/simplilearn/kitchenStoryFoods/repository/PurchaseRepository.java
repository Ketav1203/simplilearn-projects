package com.simplilearn.kitchenStoryFoods.repository;

import com.simplilearn.kitchenStoryFoods.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {


    @Query(value = "SELECT p FROM Purchase p ORDER BY p.name ASC")
    List<Purchase> findAllOrderByName();

    @Query(value = "SELECT p FROM Purchase p ORDER BY p.price ASC")
    List<Purchase> findAllOrderByPrice();
}
