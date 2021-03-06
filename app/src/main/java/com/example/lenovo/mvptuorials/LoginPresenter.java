package com.example.lenovo.mvptuorials;

/**
 * Created by lenovo on 20/02/2018.
 */

public class LoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView){ //take an object of a class implements the model view
        this.loginView=loginView;
        this.loginModel=new LoginModel();

    }

    public void onLoginClicked(String userName,String password){
        if(isValidFormat(userName,password)){
            requestLoginFromModel(userName,password);
        }else{
            loginView.showError("invalid data");
        }
    }
    private boolean isValidFormat(String userName, String password){
        return true;
    }

    private void requestLoginFromModel(String userName, String password){

        loginView.showProgress();

        boolean success = loginModel.requestLogin(userName,password);

        loginView.hideProgress();

        if(success){
            moveToNextScreen();
        }else{
            loginView.showError("login failed");
        }
    }

    private void moveToNextScreen(){

    }
}
