package br.com.tkzi.email.repositores;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tkzi.email.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
