package apartment.ejar.controllers.jwtController;


import apartment.ejar.entities.Broker;
import apartment.ejar.feign.BrokerFeign;
import apartment.ejar.services.jwtService.EjarService;
import apartment.ejar.util.Auditing;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class SignUp {

    private BrokerFeign brokerFeign;
    private EjarService ejarService;
    private Auditing auditing;


    @RequestMapping(path = "/sign-up", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity signUp(@RequestBody Broker broker) {
        ejarService.setRoles(broker);
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        broker.setPassword(passwordEncoder.encode(broker.getPassword()));
        auditing.createdOn(broker);
        auditing.createdBy(broker);
        return ResponseEntity.status(HttpStatus.CREATED).body(brokerFeign.insert(broker));
    }
}
