package nguyenduonghuy.demosecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import nguyenduonghuy.demosecurity.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
