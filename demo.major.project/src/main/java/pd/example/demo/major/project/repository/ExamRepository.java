package pd.example.demo.major.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pd.example.demo.major.project.model.Exam;

@Repository
public interface ExamRepository extends CrudRepository <Exam, Long> {
}
