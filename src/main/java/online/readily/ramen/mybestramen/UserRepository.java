package online.readily.ramen.mybestramen;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByNameAndEmail(String name, String email);
    public User findByEmail(String email);
}
