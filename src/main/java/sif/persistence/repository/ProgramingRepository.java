package sif.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sif.persistence.entity.Programing;

@Repository
public interface ProgramingRepository extends JpaRepository<Programing, Long> {
}
