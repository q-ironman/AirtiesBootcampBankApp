package com.osmanceylan.stepone;

import java.io.*;

public class BankService implements IBankService{

    String dfltUsername = "admin@gmail.com";
    String dfltPassword = "root";
    static final String PATH = "D:\\AirtiesBootcamp\\JavaProjects\\GraduationProject\\src\\main\\java\\com\\osmanceylan\\stepone\\log.txt";
    @Override
    public Boolean Login(User user) {
        Boolean canLogin = false;
        System.out.println(user.getUsername().length());
        System.out.println(user.getPassword().length());
        System.out.println(dfltUsername.length());
        System.out.println(dfltPassword.length());
        if (user.getUsername().equals(dfltUsername) ){
            if (user.getPassword().equals(dfltPassword)){
                canLogin = true;
                FileLog(LogMessages.LoginSucces);
                System.out.println(LogMessages.LoginSucces);
            }
            else {
                FileLog(LogMessages.LoginFailPassword);
                System.out.println(LogMessages.LoginFailPassword);
            }
        }
        else {
            FileLog(LogMessages.LoginFailUsername);
            System.out.println(LogMessages.LoginFailUsername);
        }
        return canLogin;
    }

    @Override
    public void FileLog(String msg) {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(PATH,true)))){
            writer.println(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void MailLog(String mail) {
        System.out.println(LogMessages.MailLogSuccess);
        FileLog(LogMessages.MailLogSuccess);

    }

    @Override
    public void ShowBalance(User user) {
        System.out.println("You have "+user.getBalance()+" in your account");
        FileLog(LogMessages.BalanceShowed);
    }

    @Override
    public void SubtractMoney(User user, long amount) {
        user.setBalance(user.getBalance()-amount);
    }

    @Override
    public void AddMoney(User user, long amount) {
        user.setBalance(user.getBalance()+amount);
        System.out.println(amount+ LogMessages.AddMoney);
        FileLog(amount+ LogMessages.AddMoney);
    }

    @Override
    public void DrawMoney(User user, long amount) {
        if (user.getBalance() >= amount){
            SubtractMoney(user,amount);
            System.out.println(amount+LogMessages.DrawMoneySuccesful);
            FileLog(amount+LogMessages.DrawMoneySuccesful);
        }
        else {
            System.out.println(amount+LogMessages.DrawMoneyFailed);
            FileLog(amount+LogMessages.DrawMoneyFailed);
        }
    }

    @Override
    public void Transfer(User user, long amount, String destinationAccount) {
        if (user.getBalance() >= amount){
            SubtractMoney(user,amount);
            System.out.println(LogMessages.TransferSuccessful+destinationAccount);
            FileLog(LogMessages.TransferSuccessful+destinationAccount);

        }
        else {
            System.out.println(amount+LogMessages.TransferFail);
            FileLog(amount+LogMessages.TransferFail);
        }
    }

    @Override
    public void EFT(User user, long amount, String destinationAccount) {
        if (user.getBalance() >= amount){
            SubtractMoney(user,amount);
            System.out.println(LogMessages.EFTSuccesfull+destinationAccount);
            FileLog(LogMessages.EFTSuccesfull+destinationAccount);

        }
        else {
            System.out.println(amount+LogMessages.TransferFail);
            FileLog(amount+LogMessages.TransferFail);
        }
    }
}
