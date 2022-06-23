package Main;

import Controller.*;
import Entity.ProdukEntity;
import GUI.DashboardGui;
import GUI.LoginPegawaiGUI;

import java.sql.SQLOutput;
import java.util.Scanner;



public class Main {
    public static  Scanner input = new Scanner(System.in);
    public static ProdukController pdk = new ProdukController();


    public static void main(String[] args) {
        new LoginPegawaiGUI();
    }
}


