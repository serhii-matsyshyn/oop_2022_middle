package ucu.oop_2022_middle.domain_data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1")
public class DomainDataController {
    private final DomainDataService domainDataService;

    @Autowired
    public DomainDataController(DomainDataService domainDataService) {
        this.domainDataService = domainDataService;
    }

    @RequestMapping(value = "/domain_data", method = RequestMethod.GET)//("/all_domain_data")
    @ResponseBody
    public DomainData getDomainData(
            @RequestParam("domain") String domain
    ) throws JsonProcessingException {
        // convert to json
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

        System.out.println(domain);
        return /*"data for " + name;*/domainDataService.getDomainData(domain);//ow.writeValueAsString(domainDataService.getDomainDataList());
    }

//    @GetMapping
//    public List<DomainData>
//    getDomainDatas () {
//        return domainDataService.getDomainDatas();
//    }
@RequestMapping(value = "/domain_data", method = RequestMethod.POST)
    public void addDomainData(@RequestParam("domain")  String domain) throws JsonProcessingException {
        domainDataService.addDomainData(domain);//.toJson();
    }
}