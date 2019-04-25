package apartment.ejar.controllers;


import apartment.ejar.feign.BrokerFeign;
import apartment.ejar.models.Paging;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/brokers")
public class BrokerController {

    private BrokerFeign brokerFeign;

    public BrokerController(BrokerFeign brokerFeign) {
        this.brokerFeign = brokerFeign;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
    public Paging brokers(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new Paging<>(new ArrayList<>(brokerFeign.getBrokers(page, size).getContent()),
                brokerFeign.getPage(page, size).getContent().getPage());
    }

}
