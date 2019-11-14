package fr.gtm.bovoyages.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_client")
private long id;
	@Column(name = "nom")
private String nom;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
