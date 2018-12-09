package com.company.ServerApi.SampleClient;

import java.util.Scanner;

public class DataListener implements Runnable {

    private Scanner scanner;

    public DataListener(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (scanner.hasNext()) {
            String rawData = scanner.nextLine();
            System.out.println(rawData);
        }
    }
}