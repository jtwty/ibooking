import request from '../utils/request';

//学生登录
export const manageLogin = query => {
    return request({
        url: 'student/login',
        method: 'post',
        params: query
    });
};

//学生注册
export const manageRegister = query => {
    return request({
        url: 'user/register',
        method: 'post',
        params: query
    });
};

//学生预约座位
export const seatAppointment = query => {
    return request({
        url: 'student/seat/booking',
        method: 'get',
        params: query
    });
};

//学生签到
export const seatSignin = query => {
    return request({
        url: 'student/signin',
        method: 'get',
        params: query
    });
};

//学生抢位
export const takePosition = query => {
    return request({
        url: 'student/onsite/book',
        method: 'get',
        params: query
    });
};

//学生查看预约记录
export const getRecord = query => {
    return request({
        url: 'student/record/list/' + query.sid,
        method: 'get'
    });
};

//学生取消预约
export const deleteAppointment = query => {
    return request({
        url: 'student/cancel/' + query.id,
        method: 'get'
    });
};
// //学生查看预约记录
// export const getRecord = query => {
//     return request({
//         url: 'student/record/list',
//         method: 'get',
//         data: query
//     });
// };

// //学生取消预约
// export const deleteAppointment = query => {
//     return request({
//         url: 'student/cancel/',
//         method: 'get',
//         data: query
//     });
// };

//管理员登录
export const adminLogin = query => {
    return request({
        url: 'admin/login',
        method: 'post',
        params: query
    });
};

// //学生登录
// export const manageLogin = query => {
//     return request({
//         url: 'student/login',
//         method: 'post',
//         params: query
//     });
// };

//管理员设定可用自习室
export const adminSetStudyroom = query => {
    return request({
        url: 'admin/room/save',
        method: 'post',
        params: query
    });
};

//管理员修改可用自习室
export const adminUpdateStudyroom = query => {
    return request({
        url: 'admin/room/update',
        method: 'post',
        params: query
    });
};

//查询所有自习室
export const getAllStudyroom = query => {
    return request({
        url: 'room/list',
        method: 'get',
        params: query
    });
};

//查询自习室所有座位信息
export const getAllSeat = query => {
    return request({
        url: 'seat/list/' + query.rid,
        method: 'get'
    });
};

//查询座位详细信息
export const getSeatInfo = query => {
    return request({
        url: 'seat/info/' + query.id,
        method: 'get'
    });
};

//查询指定时段空闲的座位
export const getSeatFree = query => {
    return request({
        url: 'seat/free',
        method: 'get',
        params: query
    });
};

export const needSignIn = query => {
    return request({
        url: 'check',
        method: 'get',
        params: query
    });
}