package ucu.oop_2022_middle.domain_data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class DomainDataController {
    private final DomainDataService domainDataService;

    @Autowired
    public DomainDataController(DomainDataService domainDataService) {
        this.domainDataService = domainDataService;
    }

    @GetMapping("/all_domain_data")
    public String getDomainDataList() throws JsonProcessingException {
        // convert to json
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(domainDataService.getDomainDataList());
    }

    @PostMapping(value="/get_data_about_domain", consumes="application/json", produces="application/json")
    public String getDomainData(@RequestBody Map<String,String> data) throws JsonProcessingException {
        String name = data.get("name");
        System.out.println("name: " + name);
        return domainDataService.getDomainData(name).toJson();
    }
}