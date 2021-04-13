package src.main.java.com.gym17.gym17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.PrivateCoachSchedule;

@RepositoryRestResource(exported = false)
@Repository
public interface PrivateCoachScheduleRepository extends JpaRepository<PrivateCoachSchedule, Integer> {

	@Query(value = "SELECT * FROM private_coach_schedule t WHERE t.fk_customer = :parseInt", nativeQuery = true)
	Iterable<PrivateCoachSchedule> findByCustomer(@Param("parseInt") int parseInt);

	@Query(value = "SELECT * FROM private_coach_schedule WHERE end IS NOT NULL AND end < NOW()", nativeQuery = true)
	Iterable<PrivateCoachSchedule> getOldEntety();

	@Query(value = "SELECT * FROM private_coach_schedule t WHERE t.fk_status = 1", nativeQuery = true)
	Iterable<PrivateCoachSchedule> findFree();
}