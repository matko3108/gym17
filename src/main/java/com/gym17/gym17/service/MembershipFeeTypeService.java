package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.MembershipFeeType;
import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.repositories.MembershipFeeTypeRepository;

@Service
public class MembershipFeeTypeService {
	private MembershipFeeTypeRepository MembershipFeeTypeRepository;

	@Autowired
	public MembershipFeeTypeService(MembershipFeeTypeRepository MembershipFeeTypeRepository) {
		this.MembershipFeeTypeRepository = MembershipFeeTypeRepository;
	}
	public Iterable<MembershipFeeType> list() {
		Iterable<MembershipFeeType> MembershipFeeTypeCollection = MembershipFeeTypeRepository.findAll();
		return MembershipFeeTypeCollection;
	}

	public Optional<MembershipFeeType> findById(int parseInt) {
		return MembershipFeeTypeRepository.findById(parseInt);
	}
	
	public MembershipFeeType saveMembershipFeeType(MembershipFeeType data) {
		return MembershipFeeTypeRepository.save(data);
	}
	public void delete(MembershipFeeType MembershipFeeType) {
		MembershipFeeTypeRepository.delete(MembershipFeeType);				
	}

	public Optional<MembershipFeeType> findByExternalId(String externalId) {
		Optional<MembershipFeeType> optOrg = MembershipFeeTypeRepository.findByIdExternalId(externalId);
		//if (optOrg.isPresent()) {
		//	optOrg.get().setPassword(null);
		//}
		return optOrg;
	}

}