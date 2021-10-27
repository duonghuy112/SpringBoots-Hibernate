package nguyenduonghuy.demosecurity.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nguyenduonghuy.demosecurity.entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String name;
	private String username;
	private List<RoleDto> roles = new ArrayList<>();
	
	public UserDto (User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.roles.addAll(user.getRoles().stream().map(RoleDto::new).collect(Collectors.toList()));
	}
}
