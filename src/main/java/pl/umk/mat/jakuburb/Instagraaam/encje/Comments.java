package pl.umk.mat.jakuburb.Instagraaam.encje;

import jakarta.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Poost post;

    @ManyToOne
    private User owner;
    @Column(columnDefinition="varchar(1000)")
    private String opis;

    public Comments(Poost post, User owner, String opis) {
        this.post = post;
        this.owner = owner;
        this.opis = opis;
    }

    public Comments(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poost getPost() {
        return post;
    }

    public void setPost(Poost post) {
        this.post = post;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
