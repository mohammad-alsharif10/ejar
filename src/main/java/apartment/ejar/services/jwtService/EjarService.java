package apartment.ejar.services.jwtService;

import apartment.ejar.controllers.jwtController.LoginResponse;
import apartment.ejar.entities.Broker;
import apartment.ejar.entities.Role;
import apartment.ejar.repositories.BrokerRepository;
import apartment.ejar.repositories.RoleRepository;
import apartment.ejar.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EjarService {

    @Autowired
    private BrokerRepository brokerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private LoginResponse loginResponse;

    public Optional<String> signin(String username, String password) {
        Optional<String> token = Optional.empty();
        Optional<Broker> broker = brokerRepository.findByUsername(username);
        if (broker.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username, broker.get().getRoles()));
            } catch (AuthenticationException e) {
                System.out.println("Log in failed for user {}" + username);
            }
        }
        return token;
    }

    public List<Broker> getAll() {
        return brokerRepository.findAll();
    }

    public boolean isUserPresent(String username) {
        return brokerRepository.findByUsername(username).isPresent();
    }

    public Broker setRoles(Broker broker) {
        List<Role> jsonRoles = broker.getRoles();
        List<Role> roles = new ArrayList<>();
        jsonRoles.forEach(role -> roles.add(roleRepository.findById(role.getId()).get()));
        broker.setRoles(roles);
        return broker;
    }
}
