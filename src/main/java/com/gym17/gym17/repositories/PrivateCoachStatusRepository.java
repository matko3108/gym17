package src.main.java.com.gym17.gym17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.PrivateCoachStatus;

@RepositoryRestResource(exported = false)
@Repository
public interface PrivateCoachStatusRepository extends JpaRepository<PrivateCoachStatus, Integer> {

}