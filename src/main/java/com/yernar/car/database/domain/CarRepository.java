package com.yernar.car.database.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//for larger databases use CRUD extention PagingAndSortingRepository
public interface CarRepository extends CrudRepository<Car, Long>{
	//long count()
	//Iterable<T> findAll()
	//Optional<T> findById(ID Id)
	//void delete(T entity)
	//void deleteAll()
	//<S extends T> save (S entity)

	//find cars by brand
	public List<Car> findByBrand(@Param("brand") String brand);

    //find cars by color
    public List<Car> findByColor(@Param("color") String color);

//	//fetch cars by brand using SQL
//	@Query("select c from Car c where c.brand = ?1")
//	public List<Car> findByBrand(String brand);



//	//find cars by year
//	public List<Car> findByYear(int year);
//
//	//fetch cars by brand and model
//	public List<Car> findByBrandAndModel(String brand, String model);
//
//	//fetch cars by brand or color
//	public List<Car> findByBrandOrColor(String brand, String color);
//
//	//fetch cars by brand and sort by year
//	public List<Car> findByBrandOrderByYearAsc(String brand, int year);
//
//
}
