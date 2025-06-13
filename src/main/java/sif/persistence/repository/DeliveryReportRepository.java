package sif.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sif.persistence.entity.DeliveryReport;

@Repository
public interface DeliveryReportRepository extends JpaRepository<DeliveryReport, Long> {
}
