package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="contatos")
public class Contato implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
        @Size(min = 4, message = "Campo maior que 4 caracteres") @NotEmpty(message = "N‹o pode ser vazio")
	private String nome;
        @Email(message="Isto n‹o Ž e-mail") @NotEmpty(message = "N‹o pode ser vazio")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
