package app.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import app.dto.RegisterDTO;

@Entity
@DiscriminatorValue(value = "Manager")
public class Manager extends User {

	public Manager() {
		super();
	}

	public Manager(Long id, String username, String password, String firstName, String lastName, String picture, Date registered) {
		super(id, username, password, firstName, lastName, picture, registered);
	}

	public Manager(RegisterDTO registerDTO) {
		super(registerDTO);
	}

}
