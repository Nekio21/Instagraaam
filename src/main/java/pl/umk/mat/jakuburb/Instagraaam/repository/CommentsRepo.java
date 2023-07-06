package pl.umk.mat.jakuburb.Instagraaam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.umk.mat.jakuburb.Instagraaam.encje.Comments;
import pl.umk.mat.jakuburb.Instagraaam.encje.Poost;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;

import java.util.List;

@Repository
public interface CommentsRepo extends CrudRepository<Comments, Long> {
    List<Comments> findByOwner(User user);

    List<Comments> findByPost(Poost poost);
}
