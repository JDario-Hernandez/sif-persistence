package sif.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sif.persistence.entity.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
}