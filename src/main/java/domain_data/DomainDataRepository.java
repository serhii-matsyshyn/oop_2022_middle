package domain_data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainDataRepository extends JpaRepository<DomainData, Long> {
    @Query("SELECT t FROM domain_data t WHERE t.name = ?1")
    DomainData findByName(String name);
}
