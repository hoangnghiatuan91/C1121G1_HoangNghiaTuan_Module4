package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    //@Query(value = "select c from Customer c where c.deleteFlag = false and c.customerName like concat('%',:customer_name,'%') ")
    @Query(value = "select * from customer where customer.delete_flag = 0 and customer.customer_name like concat('%',:customer_name,'%') ", nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, @Param("customer_name") String customer_name);

    @Query(value = "select customer.customer_name,contract.contract_id,service.service_name,attach_service.attach_service_name from customer\n" +
            "inner join contract on contract.customer_id = customer.customer_id\n" +
            "inner join service on contract.service_id = service.service_id\n" +
            "inner join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
            "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id;", nativeQuery = true)
    Page<Customer> findCustomer(Pageable pageable, String customer_name);

    Customer findByCustomerCode(String codeName);

    @Query(value = "select customer.customer_id as customerId,customer.customer_name as customerName,contract.contract_id as contractId," +
            "service.service_name as serviceName,attach_service.attach_service_name as attachServiceName," +
            "contract_detail.contract_detail_id as contractDetailId,contract_detail.quantity," +
            "(service.service_cost-contract.contract_deposit + ifnull(attach_service.attach_service_cost,0)*ifnull(contract_detail.quantity,0)) as total from customer " +
            "inner join contract on contract.customer_id = customer.customer_id " +
            "inner join service on contract.service_id = service.service_id " +
            "inner join contract_detail on contract.contract_id = contract_detail.contract_id " +
            "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
            countQuery = "select count(*) from customer "+
                    "inner join contract on contract.customer_id = customer.customer_id " +
                    "inner join service on contract.service_id = service.service_id " +
                    "inner join contract_detail on contract.contract_id = contract_detail.contract_id " +
                    "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
                nativeQuery = true)
    <T>Page<T> findAllCustomerUseServicePage(Class<T> classType,Pageable pageable);

    @Query(value = "select * from customer where customer.delete_flag = 0 ", nativeQuery = true)
    List<Customer> findAllByCustomerNameContaining();
}
