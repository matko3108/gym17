package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.LuckyReward;

@RepositoryRestResource(exported = false)
@Repository
public interface LuckyRewardRepository extends JpaRepository<LuckyReward, Integer> {

	@Query(value = "SELECT * FROM lucky_reward t WHERE t.fk_customer = :parseInt AND fk_reward_status = 1", nativeQuery = true)
	Optional<LuckyReward> findByCustomer(@Param("parseInt") int parseInt);

	@Query(value = "SELECT * FROM lucky_reward WHERE expiration_date IS NOT NULL AND expiration_date < NOW() AND fk_reward_status = 1", nativeQuery = true)
	Iterable<LuckyReward> getOldEntety();

	@Query(value = "SELECT * FROM lucky_reward t WHERE t.code = :randomString", nativeQuery = true)
	Optional<LuckyReward> findByCode(@Param("randomString") String randomString);
}