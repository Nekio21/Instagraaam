package pl.umk.mat.jakuburb.Instagraaam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.umk.mat.jakuburb.Instagraaam.encje.Poost;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Poost, Long> {

    List<Poost> findByUser(User user);
}
