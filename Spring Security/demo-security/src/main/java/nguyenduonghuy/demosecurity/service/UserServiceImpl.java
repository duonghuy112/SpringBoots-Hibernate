package nguyenduonghuy.demosecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nguyenduonghuy.demosecurity.dto.RoleDto;
import nguyenduonghuy.demosecurity.dto.UserDto;
import nguyenduonghuy.demosecurity.entities.Role;
import nguyenduonghuy.demosecurity.entities.User;
import nguyenduonghuy.demosecurity.repo.RoleRepository;
import nguyenduonghuy.demosecurity.repo.UserRepository;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			log.error("User not found in database");
		} else {
			log.info("User found in database: {}", username);
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getName())));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
	
	@Override
	public UserDto save(User user) {
		log.info("Saving new user {} to database", user.getName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new UserDto(userRepository.save(user));
	}

	@Override
	public RoleDto save(Role role) {
		log.info("Saving new role {} to database", role.getName());
		return new RoleDto(roleRepository.save(role));
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Adding role {} to user {}", roleName, username);
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public UserDto get(String username) {
		log.info("Fetching user {}", username);
		return new UserDto(userRepository.findByUsername(username));
	}

	@Override
	public List<UserDto> get() {
		log.info("Fetching all users");
		return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
	}

}
