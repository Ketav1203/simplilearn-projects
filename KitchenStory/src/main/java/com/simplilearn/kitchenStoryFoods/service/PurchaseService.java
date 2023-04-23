package com.simplilearn.kitchenStoryFoods.service;


import com.simplilearn.kitchenStoryFoods.models.Purchase;
import com.simplilearn.kitchenStoryFoods.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> getPurchaseData(){
        return purchaseRepository.findAll();
    }

    public List<Purchase> getPurchaseDataSortedWithName(){
        return purchaseRepository.findAllOrderByName();
    }

    public List<Purchase> getPurchaseDataSortedWithPrice(){
        return purchaseRepository.findAllOrderByPrice();
    }

    public void savePurchaseData(Purchase purchase){
        purchaseRepository.save(purchase);
    }
}
