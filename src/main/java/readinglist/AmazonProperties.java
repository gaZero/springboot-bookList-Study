package readinglist;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon") //"amazon"접두어가 붙은 프로퍼티 주입
public class AmazonProperties {
    private String associateId;

    public void setAssociateId(String associateId){
        this.associateId=associateId;
    }

    public String getAssociateId(){
        return associateId;
    }
}
