package nguyenduonghuy.demosecurity.dto;

import lombok.NoArgsConstructor;
import nguyenduonghuy.demosecurity.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
	private Long id;
	private String name;
	
	public RoleDto (Role role) {
		this.id = role.getId();
		this.name = role.getName();
	}
}
