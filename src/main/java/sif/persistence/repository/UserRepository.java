package sif.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sif.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
