package com.javarush.telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TinderBoltApp extends MultiSessionTelegramBot {
    public static  String TELEGRAM_BOT_NAME = ""; //Please fill it in tokens\config.file
    public static  String TELEGRAM_BOT_TOKEN="";  //Please fill it in tokens\config.file
    public static  String OPEN_AI_TOKEN ="";      //Please fill it in tokens\config.file


    public TinderBoltApp() {
        super(TELEGRAM_BOT_NAME, TELEGRAM_BOT_TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
       String msg =  getMessageText();
       switch (msg.toLowerCase()){
           case "/start":
               sendTextMessage("Вітаю на порталі знайомств для прибульців");
               sendPhotoMessage("alien01");
               sendTextButtonsMessage("Із ким хочете познайомитись?",
                       "Мініксоїди", "Minixoids",
                       "Клінгони", "Klingons",
                       "Вулканці", "Vulcans",
                       "Ференги", "Pherenghy");
               break;
           default:
               return;
       }
    }

    public static void main(String[] args) throws TelegramApiException {
        init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TinderBoltApp());
    }

    private static void init(){
        String sep = File.separator;
        try (FileReader newReader = new FileReader("src" + sep +"main" + sep +"resources" + sep +"tokens" + sep + "config.file");
             Scanner scanner = new Scanner(newReader);) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains("TELEGRAM_BOT_NAME=")){
                    TELEGRAM_BOT_NAME = line.substring(line.indexOf('=')+1);
                }
                if(line.contains("TELEGRAM_BOT_TOKEN=")){
                    TELEGRAM_BOT_TOKEN = line.substring(line.indexOf('=')+1);
                }
                if(line.contains("OPEN_AI_TOKEN=")){
                    OPEN_AI_TOKEN = line.substring(line.indexOf('=')+1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
