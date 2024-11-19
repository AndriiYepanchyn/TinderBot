package com.javarush.telegram;

import com.javarush.telegram.ChatGPTService;
import com.javarush.telegram.DialogMode;
import com.javarush.telegram.MultiSessionTelegramBot;
import com.javarush.telegram.UserInfo;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class TinderBoltApp extends MultiSessionTelegramBot {
    public static final String TELEGRAM_BOT_NAME = "AndriiY_test-bot"; //TODO: додай ім'я бота в лапках
    public static final String TELEGRAM_BOT_TOKEN = "7836670250:AAE1BBOC83Pjxbt74B4Naw9OiFJ62PbjVok"; //TODO: додай токен бота в лапках
    public static final String OPEN_AI_TOKEN = "chat-gpt-token"; //TODO: додай токен ChatGPT у лапках


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
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TinderBoltApp());
    }
}
