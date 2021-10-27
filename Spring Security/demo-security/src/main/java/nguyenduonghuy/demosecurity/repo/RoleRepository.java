package nguyenduonghuy.demosecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import nguyenduonghuy.demosecurity.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
