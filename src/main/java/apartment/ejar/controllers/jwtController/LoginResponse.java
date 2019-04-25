package apartment.ejar.controllers.jwtController;


import org.springframework.stereotype.Service;

@Service
public class LoginResponse {
    private static LoginResponse loginResponse;
    private String jwt;
    private String accessType = "Bearer";
    private Boolean status;
    private String statusMessage;

    private LoginResponse() {
    }

    public static LoginResponse getLoginResponse() {
        if (loginResponse == null) {
            synchronized (LoginResponse.class) {
                if (loginResponse == null) {
                    loginResponse = new LoginResponse();
                }
            }
        }
        return loginResponse;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
