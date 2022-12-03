package ucu.oop_2022_middle.domain_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucu.oop_2022_middle.handlers.Handler;
import ucu.oop_2022_middle.handlers.PDLHandlers.NamePDLHandler;
import ucu.oop_2022_middle.handlers.PDLHandlers.EmployeePDLHandler;
import ucu.oop_2022_middle.readers.PDLReader;

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
            addDomainData(domain);
        }

        return domainDataRepository.findByDomain(domain);
    }
    public void addDomainData(String domain) {
        DomainData.DomainDataBuilder domainDataBuilder = DomainData.builder().domain(domain);
        domainDataBuilder.name(handleName(domain));
        domainDataBuilder.employees(handleEmployees(domain));
        domainDataRepository.save(domainDataBuilder.build());
        PDLReader.clearJSON();
    }
    private String handleName (String domain) {
        Handler h = new NamePDLHandler();
        return h.handle(domain);
    }
    private String handleEmployees (String domain) {
        Handler h = new EmployeePDLHandler();
        return h.handle(domain);
    }

    public List<DomainData> getDomainDatas() {
        return  domainDataRepository.findAll();
    }

}