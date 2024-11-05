import React from 'react';
import { useForm, SubmitHandler } from 'react-hook-form';
import { ErrorMessage } from '@hookform/error-message';
import { useAuth } from '../../hooks/useAuth';
import { SigninInputs } from '../../types/auth';
import { usernameValidation, passwordValidation } from '../../utils/validation';

export const SigninForm: React.FC = () => {
    const { signin, error } = useAuth();
    const {
        register,
        handleSubmit,
        reset,
        formState: { errors }
    } = useForm<SigninInputs>({
        mode: 'onChange',
    });

    const onSubmit: SubmitHandler<SigninInputs> = async (data) => {
        await signin(data);
        reset();
    };

    return (
        <div className="formContainer">
      <form onSubmit={handleSubmit(onSubmit)}>
        <hr />
        <div className='uiForm'>
          {error && <p className="errorMsg">{error}</p>}
          <div className='formField'>
            <label htmlFor="userID">ユーザーID</label>
            <input 
              id="userID"
              type="text"
              placeholder='userID'
              {...register('username', usernameValidation)}
            />
          </div>
          <ErrorMessage
            errors={errors}
            name="username"
            render={({message}) => <span>{message}</span>}
          />
          <div className='formField'>
            <label htmlFor="password">パスワード</label>
            <input 
              id="password"
              type="password" 
              placeholder='password'
              {...register('password', passwordValidation)}
            />
          </div>
          <ErrorMessage
            errors={errors}
            name="password"
            render={({message}) => <span>{message}</span>}
          />
          <div className='loginButton'>
            <button
              type="submit"
              className="submitButton"
            >
              ログイン
            </button>
            <button
              type="button"
              className="clearButton"
              onClick={() => reset()}
            >
              クリア
            </button>
          </div>
        </div>
      </form>
    </div>
    );
};
