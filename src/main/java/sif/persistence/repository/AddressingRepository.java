package sif.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sif.persistence.entity.Addressing;

@Repository
public interface AddressingRepository extends JpaRepository<Addressing, Long> {
}