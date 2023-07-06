package pl.umk.mat.jakuburb.Instagraaam.encje;

import jakarta.persistence.*;

@Entity
public class Poost {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition="varchar(15000)")
    private String url;

    @Column(columnDefinition="varchar(1000)")
    private String opis;

    @ManyToOne
    private User user;

    public Poost(String url, String opis, User user){
        this.url = url;
        this.opis = opis;
        this.user = user;
    }

    public Poost(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
