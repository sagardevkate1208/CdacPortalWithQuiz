package Team_13.CdacPortalWithQuiz.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MongoDBRepo extends MongoRepository<studymaterial, String> {

}
