package cc.nanoic.ucsp.server.controller;

import cc.nanoic.ucsp.server.common.Result;
import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.service.UserMassageService;
import cc.nanoic.ucsp.server.utils.TokenUtils;
import cn.hutool.core.date.DateTime;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userMassage")
public class userMassageController {
    @Resource
    UserMassageService userMassageService;

    @RequestMapping("/id")
    public Result getId() {
        User user = TokenUtils.getCurrentUser();
        Integer id = userMassageService.returnId(user.getId());
        return Result.success(id);
    }

    @RequestMapping("/age")
    public Result getAge() {
        User user = TokenUtils.getCurrentUser();
        Integer age = userMassageService.returnAge(user.getId());
        return Result.success(age);
    }

    @RequestMapping("/userId")
    public Result getUserId() {
        User user = TokenUtils.getCurrentUser();
        Integer userId = userMassageService.returnUserId(user.getId());
        return Result.success(userId);
    }

    @RequestMapping("/roleId")
    public Result getRoleId() {
        User user = TokenUtils.getCurrentUser();
        Integer RoleId = userMassageService.returnRoleId(user.getId());
        return Result.success(RoleId);
    }

    @RequestMapping("/sex")
    public Result getSex() {
        User user = TokenUtils.getCurrentUser();
        String sex = userMassageService.returnSex(user.getId());
        return Result.success(sex);
    }

    @RequestMapping("/hobby")
    public Result getHobby() {
        User user = TokenUtils.getCurrentUser();
        String Hobby = userMassageService.returnHobby(user.getId());
        System.out.println(Hobby);
        return Result.success(Hobby);
    }

    @RequestMapping("/day")
    public Result getDay() {
        User user = TokenUtils.getCurrentUser();
        Integer Day = userMassageService.returnDay(user.getId());
        return Result.success(Day);
    }

    @RequestMapping("/level")
    public Result getLevel() {
        User user = TokenUtils.getCurrentUser();
        Integer Level = userMassageService.returnLevel(user.getId());
        return Result.success(Level);
    }

    @RequestMapping("/levelIntro")
    public Result getLevelIntro() {
        User user = TokenUtils.getCurrentUser();
        String LevelIntro = userMassageService.returnLevelIntro(user.getId());
        return Result.success(LevelIntro);
    }

    @RequestMapping("/authorityId")
    public Result getAuthorityId() {
        User user = TokenUtils.getCurrentUser();
        Integer AuthorityId = userMassageService.returnAuthorityId(user.getId());
        return Result.success(AuthorityId);
    }

    @RequestMapping("/password")
    public Result getPassword() {
        User user = TokenUtils.getCurrentUser();
        String Password = userMassageService.returnPassword(user.getId());
        return Result.success(Password);
    }

    @RequestMapping("/count")
    public Result getCount() {
        User user = TokenUtils.getCurrentUser();
        String Count = userMassageService.returnCount(user.getId());
        return Result.success(Count);
    }

    @RequestMapping("/phone")
    public Result getPhone() {
        User user = TokenUtils.getCurrentUser();
        String Phone = userMassageService.returnPhone(user.getId());
        return Result.success(Phone);
    }

    @RequestMapping("/registrationDate")
    public Result getRegistrationDate() {
        User user = TokenUtils.getCurrentUser();
        DateTime RegistrationDate = userMassageService.returnRegistrationDate(user.getId());
        return Result.success(RegistrationDate);
    }

    @RequestMapping("/email")
    public Result getEmail() {
        User user = TokenUtils.getCurrentUser();
        String Email = userMassageService.returnEmail(user.getId());
        return Result.success(Email);
    }

    @RequestMapping("/status")
    public Result getStatus() {
        User user = TokenUtils.getCurrentUser();
        Integer Status = userMassageService.returnStatus(user.getId());
        return Result.success(Status);
    }

    @RequestMapping("/avatar")
    public Result getAvatar() {
        User user = TokenUtils.getCurrentUser();
        String Avatar = userMassageService.returnAvatar(user.getId());
        return Result.success(Avatar);
    }
}
