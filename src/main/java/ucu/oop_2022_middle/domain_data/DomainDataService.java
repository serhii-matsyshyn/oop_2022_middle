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
        if (domainDataRepository.findByName(name) != null) {
            return domainDataRepository.findByName(name);
        }
        PDLReader pdlReader = new PDLReader();
        pdlReader.setJSON(name);

        JSONObject jsonObject = pdlReader.getJSON();

        System.out.println(jsonObject.toString());

        DomainData domainData = new DomainData();
        domainData.setName(name);
//        domainData.setTwitter(jsonObject.getString("twitter"));
//        domainData.setFacebook(jsonObject.getString("facebook"));
//
//
//        String twitter;
//        String facebook;
//        String logo;
//        String icon;
//        String employees;
//        String address;



//        while (!domainData.getDataReady()) {
//            // TODO: get data from API, fill domainData object
//        }
        System.out.println("Domain data is ready");

        domainDataRepository.save(domainData);

        return domainData;
    }
}