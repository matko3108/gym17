package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.ActivityType;
import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {

	@Query("SELECT t FROM ActivityType t WHERE t.name = :activityType") 
	ActivityType findByName(@Param("activityType") String activityType);
}