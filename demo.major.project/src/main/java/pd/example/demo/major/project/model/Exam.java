package pd.example.demo.major.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exam")
public class Exam {

    private Long examId;
    private String name;
    private String email;
    private String phone;
    private String slot;
    // Add other demographic details as needed

    // Getters and setters

    // Constructor(s)
}
