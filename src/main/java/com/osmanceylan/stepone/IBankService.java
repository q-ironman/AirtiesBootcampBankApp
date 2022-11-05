package com.osmanceylan.stepone;

public interface IBankService {
    public Boolean Login(User user);
    public void FileLog(String msg);
    public void MailLog(String mail);
    public void ShowBalance(User user);
    public void SubtractMoney(User user,long amount);
    public void AddMoney(User user, long amount);
    public void DrawMoney(User user, long amount);
    public void Transfer(User user, long amount, String destinationAccount);
    public void EFT(User user, long amount, String destinationAccount);




}
