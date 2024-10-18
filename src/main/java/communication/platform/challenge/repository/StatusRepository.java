package communication.platform.challenge.repository;

import communication.platform.challenge.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
