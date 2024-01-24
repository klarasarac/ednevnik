package ba.sum.fsre.ednevnik.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=5, max=20, message = "Polje ime mora biti izmđu 5 i 20 znakova.")
    @NotBlank(message="Polje ime je obvezno")
    String ime;

    @Size(min=5, max=20, message = "Polje ime mora biti izmđu 5 i 20 znakova.")
    @NotBlank(message="Polje prezime je obvezno")
    String prezime;

    @NotBlank(message="Polje email je obvezno")
    @Email(message = "Email adresa mora biti ispravnog formata.")
    String email;

    @NotBlank(message = "Molimo unesite lozinku")
    String lozinka;

    @NotBlank(message = "Molimo ponovite lozinku")
    @Transient
    String potvrdaLozinke;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    Set<Role> roles = new HashSet<>();

    public User() {}

    public User(Long id, String ime, String prezime, String email, String lozinka, String potvrdaLozinke) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.potvrdaLozinke = potvrdaLozinke;
        roles.add(Role.STUDENT);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPotvrdaLozinke() {
        return potvrdaLozinke;
    }

    public void setPotvrdaLozinke(String potvrdaLozinke) {
        this.potvrdaLozinke = potvrdaLozinke;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @AssertTrue(message = "Lozinke se moraju podudarati")
    public boolean isPasswordsEqual(){
        try {
            return this.lozinka.equals(this.potvrdaLozinke);
        } catch (Exception e){
            return false;
        }
    }
}
