package com.technoidentity.service;

import com.technoidentity.dto.SignUp;
import com.technoidentity.dto.UserDto;
import com.technoidentity.entity.User;
import com.technoidentity.util.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    User add(SignUp signUp);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    UserDetails loadUserById(String id);

    Boolean existsByEmail(String email);

    UserDto getById(Long id);

    List<UserDto> findByEmailContainingIgnoreCase(String email);

    Pagination findByEmailContaining(Integer status, String email, Pageable pageable);

}
