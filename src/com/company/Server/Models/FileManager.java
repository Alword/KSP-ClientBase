package com.company.Server.Models;

import com.company.Common.Models.ClientBaseContext;
import com.company.Server.IOC;
import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    public void SaveContext() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("local.damp");
            String damp = gson.toJson(IOC.DatabaseInstance, ClientBaseContext.class);
            writer.write(damp);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void LoadContext() {
        Gson gson = new Gson();
        Scanner reader = null;
        try {
            reader = new Scanner(new File("local.damp"));
            IOC.DatabaseInstance = gson.fromJson(reader.next(), ClientBaseContext.class);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
