
package com.prj.projectweb.service.implementation;

import com.prj.projectweb.dto.UserCoursedto;
import com.prj.projectweb.entities.UserCourse;
import com.prj.projectweb.mapper.UserCourseMapper;
import com.prj.projectweb.repositories.UserCourseRepository;
import com.prj.projectweb.service.UserCourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserCourseSerImp implements UserCourseService{

    private UserCourseRepository usercourseRepository;

    @Override
    public UserCoursedto addUserCourse(UserCoursedto usercoursedto) {
        UserCourse usercourse = UserCourseMapper.mapUserCourse(usercoursedto);
        UserCourse usercourseSaved = usercourseRepository.save(usercourse);
        return UserCourseMapper.mapUserCoursedto(usercourseSaved);
    }

    @Override
    public UserCoursedto getUserCourseById(Long usercourseID) {
        UserCourse usercourse = usercourseRepository.findById(usercourseID).orElse(null);
        return UserCourseMapper.mapUserCoursedto(usercourse);
    }

    @Override
    public List<UserCoursedto> getAllUserCourses() {
        List<UserCourse> usercourses = usercourseRepository.findAll();
        return usercourses.stream().map((usercourse) -> UserCourseMapper.mapUserCoursedto(usercourse)).collect(Collectors.toList());
    }

    @Override
    public UserCoursedto updateUserCourse(Long usercourseID, UserCoursedto updatedUserCourse) {
        UserCourse usercourse = usercourseRepository.findById(usercourseID).orElse(null);

        usercourse.setUser(updatedUserCourse.getUser());
        usercourse.setCourse(updatedUserCourse.getCourse());

        UserCourse updatedUserCourseObj = usercourseRepository.save(usercourse);

        return UserCourseMapper.mapUserCoursedto(updatedUserCourseObj);
    }

    @Override
    public void deleteUserCourse(Long usercourseID) {
        UserCourse usercourse = usercourseRepository.findById(usercourseID).orElse(null);

        usercourseRepository.deleteById(usercourseID);
    }

}
