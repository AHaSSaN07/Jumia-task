package com.jumia.task.jumiaTask.dummyDataSources;

import com.jumia.task.jumiaTask.entity.Customer;
import com.jumia.task.jumiaTask.repo.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DummyCustomerRepo implements CustomerRepository {
    @Override
    public List<String> getAllPhoneNumbers() {
        List<String> list = new ArrayList<>();
        list.add("(212) 6007989253");
        list.add("(212) 698054317");
        list.add("(212) 6546545369");
        list.add("(212) 6617344445");
        list.add("(258) 849181828");
        list.add("(258) 849181828");
        list.add("(251) 9119454961");
        list.add("(251) 966002259");
        list.add("(237) 697151594");
        list.add("(237) 6A0311634");
        list.add("(237) 695539786");
        return list;
    }


    @Override
    public <S extends Customer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }
}