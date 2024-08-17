package br.com.tkzi.user.domain.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
	
	private UUID userId;
	
	private String emailTo;
	
	private String subject;
	
	private String text;

}
