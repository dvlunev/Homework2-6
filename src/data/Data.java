package data;

import java.util.regex.Pattern;

public class Data {

    private Boolean result;

    public Data(Boolean result) {
        if (result == null) {
            result = false;
        }
        this.result = result;
    }

    public boolean checkForm(String login,
                             String password,
                             String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (StringUtils.isNullOrEmptyOrBlank(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть от 1 до 20 символов");
        }
        if (StringUtils.isNullOrEmptyOrBlank(password) ||
                StringUtils.isNullOrEmptyOrBlank(confirmPassword) ||
                password.length() > 20 ||
                confirmPassword.length() > 20
        ) {
            throw new WrongPasswordException("Длина пароля должна быть от 1 до 20 символов");
        }
        if (!Pattern.matches("[a-zA-Z0-9_]*$", login)) {
            throw new WrongLoginException("Пароль должен состоять из латинских букв, цифр или знака подчеркивания");
        }
        if (!Pattern.matches("[a-zA-Z0-9_]*$", password) || !Pattern.matches("[a-zA-Z0-9_]*$", confirmPassword)) {
            throw new WrongLoginException("Пароль должен состоять из латинских букв, цифр или знака подчеркивания");
        }

        /*for (int i = 0; i < login.length(); i++) {
            if ((Character.isLetter(login.charAt(i)) &&
                    (login.toLowerCase().charAt(i) > 'a' && login.toLowerCase().charAt(i) < 'z'))
                    || Character.isDigit(login.charAt(i)) ||
                    (login.charAt(i) == '_')) {

            } else {
                throw new WrongLoginException("Логин должен состоять из латинских букв, цифр или знака подчеркивания");
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if ((Character.isLetter(password.charAt(i)) &&
                    (password.toLowerCase().charAt(i) > 'a' && password.toLowerCase().charAt(i) < 'z')) ||
                    Character.isDigit(password.charAt(i)) || (password.charAt(i) == '_')) {

            } else {
                throw new WrongLoginException("Пароль должен состоять из латинских букв, цифр или знака подчеркивания");
            }
        }
        for (int i = 0; i < confirmPassword.length(); i++) {
            if ((Character.isLetter(confirmPassword.charAt(i)) &&
                    (confirmPassword.toLowerCase().charAt(i) > 'a' && confirmPassword.toLowerCase().charAt(i) < 'z')) ||
                    Character.isDigit(confirmPassword.charAt(i)) || (confirmPassword.charAt(i) == '_')) {

            } else {
                throw new WrongLoginException("Пароль должен состоять из латинских букв, цифр или знака подчеркивания");
            }
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Data{" +
                "result=" + result +
                '}';
    }
}
