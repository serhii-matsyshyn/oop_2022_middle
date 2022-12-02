package domain_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainDataService {
    @Autowired
    private DomainDataRepository domainDataRepository;

    public DomainDataService(DomainDataRepository domainDataRepository) {
        this.domainDataRepository = domainDataRepository;
    }

    public List<DomainData> getDomainDataList() {
        return domainDataRepository.findAll();
    }

    public void addDomainData(DomainData flower) {
        domainDataRepository.save(flower);
    }

    // get one domain data by name if exists
    public DomainData getDomainData(String name) {
        if (domainDataRepository.findByName(name) != null) {
            return domainDataRepository.findByName(name);
        }
        DomainData domainData = new DomainData();


        while (!domainData.getDataReady()) {
            // TODO: get data from API, fill domainData object
        }

        domainDataRepository.save(domainData);

        return domainData;
    }
}