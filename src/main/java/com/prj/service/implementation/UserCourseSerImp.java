package com.prj.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prj.dto.UserCoursedto;
import com.prj.entities.UserCourse;
import com.prj.exception.ResourceNotFound;
import com.prj.mapper.UserCourseMapper;
import com.prj.repository.UserCourseRepository;
import com.prj.service.UserCourseService;

import lombok.AllArgsConstructor;

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
