package domain_data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/get_data_about_domain")
    public String getDomainData(@RequestBody String name) throws JsonProcessingException {
        return domainDataService.getDomainData(name).toJson();
    }
}