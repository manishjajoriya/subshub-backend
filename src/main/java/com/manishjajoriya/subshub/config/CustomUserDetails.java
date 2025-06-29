package com.manishjajoriya.subshub.config;

import com.manishjajoriya.subshub.entity.UserEntity;
import java.util.Collection;
import java.util.UUID;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
  @Getter
  private final UserEntity user;
  private final Collection<? extends GrantedAuthority> authorities;

  public CustomUserDetails(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
    this.user = user;
    this.authorities = authorities;
  }

  public UUID getUid() {
    return user.getUid();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

}