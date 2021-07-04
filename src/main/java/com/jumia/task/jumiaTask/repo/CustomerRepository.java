package com.jumia.task.jumiaTask.repo;

import com.jumia.task.jumiaTask.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    @Query(value = "SELECT phone  FROM customer c",nativeQuery = true)
    public List<String> getAllPhoneNumbers();

    @Query(value = "SELECT phone  FROM customer c LIMIT ?1",nativeQuery = true)
    public List<String> getPhoneNumbersByRequestedPage(Integer count);
}
