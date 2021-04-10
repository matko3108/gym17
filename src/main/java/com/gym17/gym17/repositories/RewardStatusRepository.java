package src.main.java.com.gym17.gym17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.RewardStatus;

@RepositoryRestResource(exported = false)
@Repository
public interface RewardStatusRepository extends JpaRepository<RewardStatus, Integer> {

	@Query("SELECT t FROM RewardStatus t WHERE t.name = :rewardStatus") 
	RewardStatus findByName(@Param("rewardStatus") String activityType);
	
	@Query("SELECT t FROM RewardStatus t WHERE t.id = :rewardStatusId") 
	RewardStatus findById(@Param("rewardStatusId") String rewardStatusId);
}