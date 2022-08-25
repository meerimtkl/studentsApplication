package kg.megacom.students1.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.students1.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface LessonRepo extends JpaRepository<Lesson,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update lessons set day=?2 where id=?1",nativeQuery = true)
     void update(@Param("id")Long id, @Param ("day")@DateTimeFormat(pattern="dd-MM-yyyy")Date day);

}
