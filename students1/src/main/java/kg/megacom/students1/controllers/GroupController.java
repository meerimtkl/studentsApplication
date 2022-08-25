package kg.megacom.students1.controllers;

import kg.megacom.students1.models.Group;
import kg.megacom.students1.models.dto.GroupDto;
import kg.megacom.students1.models.dto.LessonDto;
import kg.megacom.students1.models.requests.GroupRequest;
import kg.megacom.students1.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
    @PostMapping("/createGroup")
    public GroupDto createGroup(@RequestBody Group group){
      //  System.out.println("title course"+group.getCourse().getTitle());
        return groupService.createGroup(group);


    }
    @PostMapping("/create")
    public Group create(@RequestBody GroupRequest groupRequest){
        return groupService.create(groupRequest);

    }
    @GetMapping("/all")
    public List<GroupDto> findAll(){return groupService.findAll();}

}
