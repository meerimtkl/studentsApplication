package kg.megacom.students1.mappers;

import kg.megacom.students1.configuration.ModelMapperConfiguration;
import kg.megacom.students1.models.Course;
import kg.megacom.students1.models.Student;
import kg.megacom.students1.models.dto.CourseDto;
import kg.megacom.students1.models.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;
    public Course toEntity(CourseDto courseDto){
        return Objects.isNull(courseDto)?null:modelMapper.map(courseDto,Course.class);
    }
    public CourseDto toDto(Course course){
        return Objects.isNull(course)?null:modelMapper.map(course,CourseDto.class);

    }
    public List<CourseDto> toDtoList(List<Course> courseListList){
        //  List<StudentDto> postDtoList = Arrays.asList(modelMapper.map(studentList, StudentDto[].class));

        //  return Objects.isNull(studentList)?null: Arrays.asList(modelMapper.map(studentList, StudentDto[].class));

        return courseListList.stream().map(course->modelMapper.map(course,CourseDto.class))
                .collect(Collectors.toList());
    }


}
