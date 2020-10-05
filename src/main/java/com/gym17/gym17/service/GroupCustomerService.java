package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.GroupCustomer;
import src.main.java.com.gym17.gym17.repositories.GroupCustomerRepository;

@Service
public class GroupCustomerService {
	private GroupCustomerRepository GroupCustomerRepository;

	@Autowired
	public GroupCustomerService(GroupCustomerRepository GroupCustomerRepository) {
		this.GroupCustomerRepository = GroupCustomerRepository;
	}
	public Iterable<GroupCustomer> list() {
		Iterable<GroupCustomer> GroupCustomerCollection = GroupCustomerRepository.findAll();
		return GroupCustomerCollection;
	}

	public Optional<GroupCustomer> findById(int parseInt) {
		return GroupCustomerRepository.findById(parseInt);
	}
	
	public GroupCustomer saveGroupCustomer(GroupCustomer data) {
		return GroupCustomerRepository.saveAndFlush(data);
	}
	public void delete(GroupCustomer GroupCustomer) {
		GroupCustomerRepository.delete(GroupCustomer);				
	}

}