package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.CustomerMembershipFee;
import src.main.java.com.gym17.gym17.repositories.CustomerMembershipFeeRepository;

@Service
public class CustomerMembershipFeeService {
	private CustomerMembershipFeeRepository CustomerMembershipFeeRepository;

	@Autowired
	public CustomerMembershipFeeService(CustomerMembershipFeeRepository CustomerMembershipFeeRepository) {
		this.CustomerMembershipFeeRepository = CustomerMembershipFeeRepository;
	}
	public Iterable<CustomerMembershipFee> list() {
		Iterable<CustomerMembershipFee> CustomerMembershipFeeCollection = CustomerMembershipFeeRepository.findAll();
		return CustomerMembershipFeeCollection;
	}

	public Optional<CustomerMembershipFee> findById(int parseInt) {
		return CustomerMembershipFeeRepository.findById(parseInt);
	}
	
	public CustomerMembershipFee saveCustomerMembershipFee(CustomerMembershipFee data) {
		return CustomerMembershipFeeRepository.save(data);
	}
	public void delete(CustomerMembershipFee CustomerMembershipFee) {
		CustomerMembershipFeeRepository.delete(CustomerMembershipFee);				
	}
	public void deleteOldEntety() {
		// TODO Auto-generated method stub
		CustomerMembershipFeeRepository.deleteOldEntety();
	}

}