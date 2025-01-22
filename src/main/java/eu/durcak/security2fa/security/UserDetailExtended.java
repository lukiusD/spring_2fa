package eu.durcak.security2fa.security;

import eu.durcak.security2fa.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailExtended implements UserDetails {

    private User user;
    private boolean challengeCompleted;

    public UserDetailExtended(User user) {
        this.user = user;
        this.challengeCompleted = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    public boolean is2FaEnabled() {
        return this.user.isEnabled2fa();
    }

    public String getOtpSecret() {
        return this.user.getOtpSecret();
    }

    public boolean isChallengeCompleted() {
        return challengeCompleted;
    }

    public void setChallengeCompleted(boolean completed) {
        this.challengeCompleted = completed;
    }
}
