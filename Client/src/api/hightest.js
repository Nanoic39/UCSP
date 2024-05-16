// 注册接口
import request from '@/utils/request'

export const hightest = () => {
    return request.post('/selectPastPapers');
};

export const highselect = (papersType) => {
    return request.post('/selectPastPapersByType',papersType);
};
