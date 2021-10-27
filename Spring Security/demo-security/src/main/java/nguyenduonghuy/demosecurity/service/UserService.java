package nguyenduonghuy.demosecurity.service;

import java.util.List;

import nguyenduonghuy.demosecurity.dto.RoleDto;
import nguyenduonghuy.demosecurity.dto.UserDto;
import nguyenduonghuy.demosecurity.entities.Role;
import nguyenduonghuy.demosecurity.entities.User;

public interface UserService {
	UserDto save(User user);
	RoleDto save(Role role);
	void addRoleToUser(String username, String roleName);
	UserDto get(String username);
	List<UserDto> get(); 
}
