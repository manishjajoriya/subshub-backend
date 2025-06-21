package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.repository.UserRepo;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepo userRepo;

  @Autowired
  public CustomUserDetailsService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity user =
        userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    List<GrantedAuthority> grantedAuthorities = user.getRole().stream().map(
        SimpleGrantedAuthority::new).collect(
        Collectors.toList());
    return new CustomUserDetails(user, grantedAuthorities);
  }

  public UserDetails loadUserById(UUID id) throws UsernameNotFoundException {
    UserEntity user = userRepo.findByUid(id).orElseThrow(() ->
        new UsernameNotFoundException(id.toString()));
    List<GrantedAuthority> grantedAuthorities = user.getRole().stream().map(
        SimpleGrantedAuthority::new).collect(
        Collectors.toList());
    return new CustomUserDetails(user, grantedAuthorities);
  }

}
