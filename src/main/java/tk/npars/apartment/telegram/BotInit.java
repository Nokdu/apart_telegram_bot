package tk.npars.apartment.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotInit extends TelegramLongPollingBot {

    private static BotInit instance;

    public static synchronized BotInit getInstance() {
        if (instance == null) {
            instance = new BotInit();
        }
        return instance;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String msg = "" + chat_id;
            SendMessage message = new SendMessage() //
                    .setChatId(chat_id)
                    .setText(msg);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    //-484521743 -> Чат Квартиры
    //36777709L -> Мой чат
    public void SendMessage(String messages){
        SendMessage message = new SendMessage()
                .setChatId(-484521743L)
                .setText(messages);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
        return "notify";
    }
    @Override
    public String getBotToken() {
        return "1024474040:AAEdLfkXYfb6fsL2LbVgY5ut19-adEZ1I4g";
    }
}

