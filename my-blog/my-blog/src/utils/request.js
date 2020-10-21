import axios from 'axios'

//create a axios instance
const service = axios.create({
  baseURL:'',
  timeout:5000
})

export default service
