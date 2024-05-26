// 注册接口
import request from '@/utils/request'

export const collectid = () => {
    return request.post('/userMassage/id');
};

export const collectaccount = () => {
    return request.post('/userMassage/account');
};
