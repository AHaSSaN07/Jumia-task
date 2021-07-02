package com.jumia.task.jumiaTask.repo;

import com.jumia.task.jumiaTask.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
