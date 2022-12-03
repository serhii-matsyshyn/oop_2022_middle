package ucu.oop_2022_middle.domain_data;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucu.oop_2022_middle.readers.PDLReader;

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
        if (domainDataRepository.findByUrl(name) != null) {
            return domainDataRepository.findByUrl(name);
        }

        DomainData domainData = new DomainData();
        domainData.setUrl(name);

        domainData = PDLReader.getDomainData(name, domainData);

//        while (!domainData.getDataReady()) {
//            // TODO: get data from API, fill domainData object
//        }
        System.out.println("Domain data is ready");

        System.out.println(domainData);

        domainDataRepository.save(domainData);

        System.out.println("Domain data is saved");

        return domainData;
    }
}