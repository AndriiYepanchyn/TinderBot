package com.javarush.telegram;

public class UserInfo {
    public String name; //Ім'я
    public String sex; //Стать
    public String age; //Вік
    public String city; //Місто
    public String occupation; //Професія
    public String hobby; //Хобі
    public String handsome; //Краса, привабливість
    public String wealth; //Дохід, багатство
    public String annoys; //Мене дратує у людях
    public String goals; //Цілі знайомства

    private String fieldToString(String str, String description) {
        if (str != null && !str.isEmpty())
            return description + ": " + str + "\n";
        else
            return "";
    }

    @Override
    public String toString() {
        System.out.println("==========WARNING=====");
        StringBuilder result = new StringBuilder();

        result.append(fieldToString(name, "Ім'я"));
        result.append(fieldToString(sex, "Стать"));
        result.append(fieldToString(age, "Вік"));
        result.append(fieldToString(city, "Місто"));
        result.append(fieldToString(occupation, "Професія"));
        result.append(fieldToString(hobby, "Хобі"));
        result.append(fieldToString(handsome, "Краса, привабливість у балах (максимум 10 балів)"));
        result.append(fieldToString(wealth, "Доход, богатство"));
        result.append(fieldToString(annoys, "В людях дратує"));
        result.append(fieldToString(goals, "Цілі знайомства"));

        return result.toString();
    }
}
