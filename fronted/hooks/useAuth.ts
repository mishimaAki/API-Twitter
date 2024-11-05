import { useState } from 'react';
import { useNavigate } from 'react-router-dom'
import { SigninInputs } from '../types/auth';
import { login } from '../services/api';

export const useAuth = () => {
    const [error, setError] = useState<String>('');
    const navigate = useNavigate();
    const signin = async (data: SigninInputs) => {
        try {
            const response = await login(data);
            console.log('Login response:', response);
            if (response.status == 200) {
                navigate('/top');
            } else {
                setError(response.data.error || 'ログインに失敗しました。');
            }
        } catch (err) {
            setError('ログイン処理中にエラーが発生しました。');
        }
    }
    return { signin, error };
};
