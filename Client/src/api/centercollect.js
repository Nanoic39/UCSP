// 注册接口
import request from '@/utils/request'

export const collectid = () => {
    return request.post('/userInfo/id');
};

export const collectaccount = () => {
    return request.post('/userInfo/account');
};

export const collectavatar = () => {
    return request.post('/userInfo/avatar');
};
