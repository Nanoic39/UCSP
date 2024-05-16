// 注册接口
import request from '@/utils/request'

export const fetchData = ({ type, name }) => {
    if (type === 'blur') {
      return request.post('/date',{ type:'blur',name: ''});
    } else if (type === 'accurate') {
      return request.post('/date',{ type:'accurate',name: name});
    }
  };
  