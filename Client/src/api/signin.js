// 注册接口
import request from '@/utils/request'

export const readsign = ( id ) => {
    return request.post('/button/select_attendance', id );
};

export const sign = ( id ) => {
    return request.post('/button/attendance', id );
};