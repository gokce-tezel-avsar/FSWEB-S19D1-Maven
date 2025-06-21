package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value="select v.id,v.name, f.price, f.is_grown_on_tree FROM fsweb.vegetable v ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value="select v.id,v.name, f.price, f.is_grown_on_tree FROM fsweb.vegetable v ORDER BY v.price Asc", nativeQuery = true)
    List<Vegetable> getByPriceAsc();


    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Fruit> searchByName(String name);

}
