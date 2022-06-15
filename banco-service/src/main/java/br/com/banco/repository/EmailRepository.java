package br.com.banco.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.EmailModel;

public interface EmailRepository  extends JpaRepository<EmailModel, UUID>{

}
