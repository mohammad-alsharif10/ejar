package apartment.ejar.feign;


import apartment.ejar.entities.Broker;
import apartment.ejar.models.BrokerModel;
import apartment.ejar.models.PageAndSize;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "broker-services", url = "http://localhost:8080/brokers")
public interface BrokerFeign {

    @RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
    Broker insert(@RequestBody Broker broker);

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Resource<PageAndSize> getPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Resources<BrokerModel> getBrokers(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Resource<BrokerModel> getLocationById(@PathVariable("id") Long id);

}
