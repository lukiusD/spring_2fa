package eu.durcak.security2fa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;

    @ColumnDefault("false")
    private boolean enabled2fa;
    private String otpSecret;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getOtpSecret() {
        return otpSecret;
    }

    public boolean isEnabled2fa() {
        return enabled2fa;
    }

}