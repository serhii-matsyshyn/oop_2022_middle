package ucu.oop_2022_middle.domain_data;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucu.oop_2022_middle.readers.BrandFetch;
import ucu.oop_2022_middle.readers.PDLReader;
import ucu.oop_2022_middle.readers.SerperReader;

import java.net.URI;
import java.net.URISyntaxException;
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
        String name_new;
        try {
            URI uri = new URI(name);
            name_new = uri.getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new DomainData();
        }
        if (name_new != null) {
            name = name_new;
        }

        System.out.println("name: " + name);

        if (domainDataRepository.findByUrl(name) != null) {
            return domainDataRepository.findByUrl(name);
        }

        DomainData domainData = new DomainData();
        domainData.setUrl(name);

        domainData = PDLReader.getDomainData(name, domainData);
        domainData = BrandFetch.getDomainData(name, domainData);
        domainData = SerperReader.getDomainData(domainData.getName(), domainData);

        System.out.println(domainData);

        domainDataRepository.save(domainData);

        return domainData;
    }
}