package ucu.oop_2022_middle.domain_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1")
public class DomainDataController {
    private final DomainDataService domainDataService;

    @Autowired
    public DomainDataController(DomainDataService domainDataService) {
        this.domainDataService = domainDataService;
    }

    @RequestMapping(value = "/domain_data", method = RequestMethod.GET)
    @ResponseBody
    public DomainData getDomainData(
            @RequestParam("domain") String domain
    ) {
        System.out.println(domain);
        return domainDataService.getDomainData(domain);
    }
@RequestMapping(value = "/domain_data", method = RequestMethod.POST)
    public void addDomainData(@RequestParam("domain")  String domain) {
        domainDataService.addDomainData(domain);//.toJson();
    }
}