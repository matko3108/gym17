package src.main.java.com.gym17.gym17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.gym17.gym17.model.ActivityList;
import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface ActivityListRepository extends JpaRepository<ActivityList, Integer> {
	@Modifying
    @Transactional 
	@Query(value = "DELETE FROM activity_list WHERE MONTH(create_date) < MONTH(NOW() - INTERVAL 1 MONTH)", nativeQuery = true)
	void deleteOldEntety();

}