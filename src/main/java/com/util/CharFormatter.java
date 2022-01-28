package com.util;

public class CharFormatter {

    public static StringBuilder valueFormat(Integer currency) {

        StringBuilder stringBuilder = new StringBuilder();
        String currency_string = currency_string = currency.toString();

        currency_string = currency_string.replace("0", "섎");
        currency_string = currency_string.replace("1", "섏");
        currency_string = currency_string.replace("2", "섐");
        currency_string = currency_string.replace("3", "섑");
        currency_string = currency_string.replace("4", "섒");
        currency_string = currency_string.replace("5", "섓");
        currency_string = currency_string.replace("6", "섔");
        currency_string = currency_string.replace("7", "섕");
        currency_string = currency_string.replace("8", "섖");
        currency_string = currency_string.replace("9", "섗");

        for (int i = 0; i < currency_string.length(); i++) {


            stringBuilder.append(currency_string.charAt(i));


        }


        return stringBuilder;
    }

}
