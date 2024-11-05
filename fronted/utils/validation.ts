export const usernameValidation = {
    required: 'ユーザーIDを入力してください。',
    maxLength: {
      value: 20,
      message: '20文字以内で入力してください。'
    },
    pattern: {
      value: /^[A-Za-z0-9-]+$/i,
      message: 'ユーザーIDの形式が不正です。',
    },
  };
  
  export const passwordValidation = {
    required: 'パスワードを入力してください。',
    maxLength: {
      value: 20,
      message: '20文字以内で入力してください。'
    },
    pattern: {
      value: /^[A-Za-z0-9]+$/i,
      message: 'パスワードの形式が不正です。',
    },
  };