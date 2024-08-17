package br.com.tkzi.email.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.tkzi.email.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "TB_EMAILS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmailModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private UUID emailId;
	
	private UUID userId;
	
	private String emailFrom;
	
	private String emailTo;
	
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	private LocalDateTime sendDateEmail;
	
	private StatusEmail statusEmail;
	
	

}
