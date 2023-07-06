package pl.umk.mat.jakuburb.Instagraaam.encje;

import jakarta.persistence.*;

@Entity
@Table(name = "uuuser")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;

    @Column(columnDefinition="varchar(15000)")
    private String urlImage;

    @Column(columnDefinition="varchar(1000)")
    private String opis;

    public User(String login, String password, String opis){
        this.login = login;
        this.password = password;
        this.opis = opis;
    }

    public User(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
