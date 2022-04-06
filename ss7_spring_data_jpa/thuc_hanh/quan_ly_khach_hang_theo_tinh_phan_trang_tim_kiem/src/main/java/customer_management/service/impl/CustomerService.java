package customer_management.service.impl;

import customer_management.model.Customer;
import customer_management.repository.ICustomerRepository;
import customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(String name,Pageable pageable) {
        return iCustomerRepository.findAllByFirstNameContaining(name,pageable);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

//    @Override
//    public Page<Customer> (String searchName,Pageable pageable) {
//        return iCustomerRepository.findAllByFirstNameContaining(searchName,pageable);
//    }
}
