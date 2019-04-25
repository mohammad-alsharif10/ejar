package apartment.ejar.util;

import apartment.ejar.controllers.jwtController.LoginResponse;
import apartment.ejar.entities.BaseEntity;
import apartment.ejar.security.EjarDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@AllArgsConstructor
@Service
public class Auditing {

    private EjarDetailsService ejarDetailsService;

    public BaseEntity createdOn(BaseEntity baseEntity) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        baseEntity.setCreatedOn(date);
        return baseEntity;
    }

    public BaseEntity createdBy(BaseEntity baseEntity) {
        baseEntity.setCreatedBy(ejarDetailsService.loadUserByJwtTokenAndDatabase
                (LoginResponse.getLoginResponse().getJwt()).get().getUsername());
        return baseEntity;
    }
}
