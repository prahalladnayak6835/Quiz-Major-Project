package pd.example.demo.major.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import pd.example.demo.major.project.model.Proleap;

@Repository
public interface ProleapRepository extends MongoRepository <Proleap, Long>{

}
