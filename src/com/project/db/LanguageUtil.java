package com.project.db;

import java.util.ArrayList;

public class LanguageUtil {

    private static ArrayList<String> englishItems = new ArrayList<>();

    private static ArrayList<String> russianItems = new ArrayList<>();

    private static ArrayList<String> kazakhItems = new ArrayList<>();



    static{



        englishItems.add("Home");

        russianItems.add("ИМЯ");

        kazakhItems.add("АТЫ");



        englishItems.add("SURNAME");

        russianItems.add("ФАМИЛИЯ");

        kazakhItems.add("ТЕГI");



        englishItems.add("AGE");

        russianItems.add("ВОЗРАСТ");

        kazakhItems.add("ЖАСЫ");



        englishItems.add("SET");

        russianItems.add("НАСТРОИТЬ");

        kazakhItems.add("ЕНГIЗУ");



        englishItems.add("LANGUAGE");

        russianItems.add("ЯЗЫК");

        kazakhItems.add("ТIЛ");



        englishItems.add("ADD");

        russianItems.add("ДОБАВИТЬ");

        kazakhItems.add("ҚОСУ");



    }



    public static ArrayList<String> getItemsByLangId(int id) {

        if(id==1){

            return englishItems;

        }else if(id==2){

            return russianItems;

        }else if(id==3){

            return kazakhItems;

        }

        return null;

    }
}
