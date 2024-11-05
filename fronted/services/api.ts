import axios,{ AxiosResponse } from 'axios';
import { SigninInputs,LoginResponse } from '../types/auth';
import { TweetResponseDTO } from 'types/tweet';

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
    withCredentials: true,
});

export const login = async (data: SigninInputs): Promise<AxiosResponse<LoginResponse>> => {
    return await api.post<LoginResponse>('/login', data);
}

export const getTweetList = async (): Promise<AxiosResponse<TweetResponseDTO[]>> => {
    return await api.get<TweetResponseDTO[]>('/tweets');
}