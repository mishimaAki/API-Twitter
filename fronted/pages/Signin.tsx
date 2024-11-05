import React from 'react';
import { SigninForm } from '../components/auth/SigninForm';

export const Signin: React.FC = () => {
    return (
        <div className='signin-page'>
            <h1>ログイン</h1>
            <SigninForm />
        </div>
    )
}