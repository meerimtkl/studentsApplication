package kg.megacom.students1.services;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.Lesson;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.dto.LessonDto;
import kg.megacom.students1.models.requests.GroupRequest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface GroupService {
    GroupDto createGroup(Group group);

    //НАЙТИ КУРС ПО ID
    //duration не должно быть пустой или  меньше или равно 0


    List<GroupDto> findAll();

    Group updateGroup(Long id,    String name);
    void deleteGroup(Long id);
    Group create(GroupRequest groupRequest);
    Group findByID(Long id);

}
