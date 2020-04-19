package readinglist;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Reader implements UserDetails {

    private static final long serialVersionUID=1L;

    @Id //Reader 필드
    private String username;

    private String fullname;

    private String password;

    @Override //UserDetail메소드
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    @Override //계정이 만료되지 않았다는 것을 반환
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override //계정이 잠겨 있지 않았다는 것을 반환
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override //자격이 유효하다는 것을 반환
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //계정이 활성화되어 있다는 것을 반환
    public boolean isEnabled() {
        return true;
    }
}
