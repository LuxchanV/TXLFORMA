import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // ton back Spring Boot
});

export default api;
