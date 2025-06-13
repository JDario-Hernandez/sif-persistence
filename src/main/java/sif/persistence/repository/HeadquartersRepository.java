package sif.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sif.persistence.entity.Headquarters;

@Repository
public interface HeadquartersRepository extends JpaRepository<Headquarters, Long> {
}
