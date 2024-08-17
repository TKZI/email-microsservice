package br.com.tkzi.user.domain.repositores;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tkzi.user.domain.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
