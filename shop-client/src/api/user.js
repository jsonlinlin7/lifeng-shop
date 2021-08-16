import request from '@/plugins/axios';

export const loginByUsername = (user) => request({
    url: '/api/blade-auth/oauth/token',
    method: 'post',
    headers: {
        'type': "web",
    },
    params: {
        username: user.username,
        password: user.password
    }
})

export const getUser = () => request({
    url: '/api/user',
    method: 'get'
})
