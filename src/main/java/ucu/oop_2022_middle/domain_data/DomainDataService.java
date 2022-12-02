package ucu.oop_2022_middle.domain_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainDataService {
    private final DomainDataRepository domainDataRepository;

    @Autowired

    public DomainDataService(DomainDataRepository domainDataRepository) {
        this.domainDataRepository = domainDataRepository;
    }

    public DomainData getDomainData(String domain) {
        if (null==domainDataRepository.findByDomain(domain)) {
            DomainData dd = DomainData.builder().domain(domain).name("Ukrainian Catholic University").twitter("coolTwitter").build();
            addDomainData(dd);
        }

        return domainDataRepository.findByDomain(domain);
    }
    public void addDomainData(DomainData domainData) {
        domainDataRepository.save(domainData);
    }

    public List<DomainData> getDomainDatas() {
        return  domainDataRepository.findAll();
    }

    // get one domain data by name if exists
//    public DomainData getDomainData() {
////        if (domainDataRepository.findByName(name) != null) {
////            return domainDataRepository.findByName(name);
////        }
////        DomainData domainData = new DomainData();
////
////
//////        while (!domainData.getDataReady()) {
//////            // TODO: get data from API, fill domainData object
//////        }
////        System.out.println("Domain data is ready");
////
////        domainDataRepository.save(domainData);
//
//        return domainData;
//    }
}