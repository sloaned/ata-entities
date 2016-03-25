package assessment.entities.Assessment;

import assessment.entities.Question.Question;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Assessment {

    @Id
    private String id;

    private String version;

    private String name;

    private List<Question> questions;

    private Assessment() {}

    public Assessment(String version, String name, List<Question> questions) {
        this.version = version;
        this.name = name;
        this.questions = questions;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
