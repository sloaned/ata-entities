package assessment.entities.team;

import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by mmosley on 4/28/2016.
 */
public class ReviewPeriod {

    @NotEmpty(message = "Name is required")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Name doesn't meet requirements")
    @Length(max = 50, message = "Name can be no longer than 50 characters")
    private String name;

    @NotNull(message = "Frequency cannot be null")
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @NotEmpty(message = "Template ID cannot be empty")
    private String templateId;

    @NotEmpty(message = "Current period ID cannot be empty")
    private String currentPeriodId;

    public ReviewPeriod() {
    }

    public ReviewPeriod(String name, Frequency frequency, String templateId, String currentPeriodId) {
        this.name = name;
        this.frequency = frequency;
        this.templateId = templateId;
        this.currentPeriodId = currentPeriodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getCurrentPeriodId() {
        return currentPeriodId;
    }

    public void setCurrentPeriodId(String currentPeriodId) {
        this.currentPeriodId = currentPeriodId;
    }

    @Override
    public String toString() {
        return "ReviewPeriod{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", templateId='" + templateId + '\'' +
                ", currentPeriodId='" + currentPeriodId + '\'' +
                '}';
    }
}
