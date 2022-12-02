package ucu.oop_2022_middle.domain_data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainDataRepository extends JpaRepository<DomainData, Long> {
        //@Query("SELECT t FROM DomainData t WHERE t.name = ?1")
        DomainData findByName(/*@Param("name")*/ String name);
        DomainData findByDomain(String domain);
}
