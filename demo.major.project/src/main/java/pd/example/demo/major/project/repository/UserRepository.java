package pd.example.demo.major.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pd.example.demo.major.project.model.User;
@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);

    //User findByEmail(String );
}
