package com.osmanceylan.stepone;

import java.util.Scanner;

public class MainProgram {
    public static int numberOfAttempts = 3;
    public static void main(String[] args) throws InterruptedException {
        BankService myService = new BankService();
        User myUser = new User();
        Scanner myScanner = new Scanner(System.in);
        long amount = 0L;
        String destination;
        String mail;
        while(MainProgram.numberOfAttempts>0)
        {
            System.out.println("Lütfen kullanici adini giriniz: ");
            myUser.setUsername(myScanner.nextLine());
            System.out.println("Lütfen sifrenizi giriniz: ");
            myUser.setPassword(myScanner.nextLine());
            if (myService.Login(myUser)){
                myUser.setBalance(1000L);
                int cmd = 0;
                while(cmd != 6){
                    if(myUser.getBalance() == 0){
                        System.out.println("Lütfen islem yapabilmek icin para yatırın");
                        System.out.println("Yatirilacak miktari giriniz: ");
                        amount = myScanner.nextInt();
                        myService.AddMoney(myUser,amount);
                    }
                    System.out.println("Lütfen menüden bir islem seciniz.");
                    System.out.println("0-) Bakiye görüntüle\n" +
                            "1-) Para Yatırma\n" +
                            "2-) Para Çekme\n" +
                            "3-) Havale Hap \n" +
                            "4-) EFT yapabileceğim \n" +
                            "5-) Mail Gönder \n" +
                            "6-) Çıkış");

                    cmd = myScanner.nextInt();
                    switch(cmd) {
                        case 0:
                            myService.ShowBalance(myUser);
                            break;
                        case 1:
                            System.out.println("Lütfen miktar giriniz: ");
                            amount = myScanner.nextInt();
                            myService.AddMoney(myUser,amount);
                            break;
                        case 2:
                            System.out.println("Lütfen miktar giriniz: ");
                            amount = myScanner.nextInt();
                            myService.DrawMoney(myUser,amount);
                            break;
                        case 3:
                            System.out.println("Lütfen miktar giriniz: ");
                            amount = myScanner.nextInt();
                            System.out.print("Lütfen hedef hesabı giriniz: ");
                            myScanner.nextLine();
                            destination = myScanner.nextLine();
                            myService.Transfer(myUser,amount,destination);
                            break;
                        case 4:
                            System.out.println("Lütfen miktar giriniz: ");
                            amount = myScanner.nextInt();
                            System.out.println("Lütfen hedef hesabı giriniz: ");
                            myScanner.nextLine();
                            destination = myScanner.nextLine();
                            myService.EFT(myUser,amount,destination);
                            break;
                        case 5:
                            System.out.println("Lütfen maili giriniz: ");
                            myScanner.nextLine();
                            mail = myScanner.nextLine();
                            myService.MailLog(mail);
                            break;
                        case 6:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Lutfen gecerli bir islem giriniz.");

                    }
                }

            }
            else{
                MainProgram.numberOfAttempts -=1;
                System.out.println("Kullanici adi veya sifre yanlis. Kalan deneme hakkiniz: "+MainProgram.numberOfAttempts);

            }

        }

    }
}
