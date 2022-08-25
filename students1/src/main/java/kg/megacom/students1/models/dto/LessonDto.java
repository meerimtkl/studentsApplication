package kg.megacom.students1.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonDto {
    Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date day;
    GroupDto group;
}

