package com.company.Interfaces;

public interface ICommand {
    boolean isMatch(String header, String body);

    String getName();

    String getDescription();
}