// 添加本项目关于 axios 请求和响应的全局配置
// 声明后端服务的完整域名
const host = 'http://localhost:8080'
// 设置axios默认基地址为后端服务的地址
axios.defaults.baseURL = host

Vue.prototype.$http = axios

// 配置一下请求拦截器
axios.interceptors.request.use(function (config) {
    // 在每次请求执行前先设置一个共同的token请求头
    let token = window.sessionStorage.getItem('token')
    if (token) {
        // 将token令牌放入请求头
        config.headers.Authorization = token
        // config.params.userId= window.sessionStorage.getItem('userId')
    }
    return config
}, function (error) {//出错时自动执行这个函数
    return Promise.reject(error)
})

// 配置一下响应拦截器
axios.interceptors.response.use(
  function (response) {//正常响应执行我
    // 响应状态码在2xx范围内的响应都会触发这个函数
    return response.data;
  },
  function (error) {//异常响应执行我
    // 响应状态码超出了2xx范围内的响应会触发这个函数
    return Promise.reject(error);
  }
)
