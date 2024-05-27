package cc.nanoic.ucsp.server.service;

import cc.nanoic.ucsp.server.mapper.UserMassageMapper;
import cn.hutool.core.date.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMassageService {
    @Autowired
    UserMassageMapper userMassageMapper;

    public Integer returnUserId(Integer id) {return userMassageMapper.returnUserId(id);}

    public Integer returnRoleId(Integer id) {return userMassageMapper.returnRoleId(id);}

    public String returnSex(Integer id) {return userMassageMapper.returnSex(id);}

    public Integer returnAge(Integer id) {return userMassageMapper.returnAge(id);}

    public String returnHobby(Integer id) {return userMassageMapper.returnHobby(id);}

    public Integer returnDay(Integer id) {return userMassageMapper.returnDay(id);}

    public Integer returnLevel(Integer id) {return userMassageMapper.returnLevel(id);}

    public String returnLevelIntro(Integer id) {return userMassageMapper.returnLevelIntro(id);}

    public Integer returnAuthorityId(Integer id) {return userMassageMapper.returnAuthorityId(id);}

    public String returnPassword(Integer id) {return userMassageMapper.returnPassword(id);}

    public String returnAccount(Integer id) {return userMassageMapper.returnAccount(id);}

    public String returnPhone(Integer id) {return userMassageMapper.returnPhone(id);}

    public String returnEmail(Integer id) {return userMassageMapper.returnEmail(id);}

    public DateTime returnRegistrationDate(Integer id) {return userMassageMapper.returnRegistrationDate(id);}

    public Integer returnStatus(Integer id) {return userMassageMapper.returnStatus(id);}

    public String returnAvatar(Integer id) {return userMassageMapper.returnAvatar(id);}

    public String returnNickname(Integer id) {return userMassageMapper.returnNickname(id);
    }
}
