package tk.npars.apartment;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tk.npars.apartment.scheduler.OlxJob;
import tk.npars.apartment.telegram.BotInit;

public class Index {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        BotInit botTelegram = BotInit.getInstance();
        try {
            telegramBotsApi.registerBot(botTelegram);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        quartz();
    }

    private static void quartz() {
        JobDetail job = JobBuilder
                .newJob(OlxJob.class)
                .withIdentity("QuartzJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("QuartzTrigger", "group1")
                .withSchedule(CronScheduleBuilder
                        .cronSchedule("0 0/10 9-20 * * ?"))
                .build();

        SchedulerFactory schedFact = new StdSchedulerFactory();
        Scheduler sched = null;
        try {
            sched = schedFact.getScheduler();
            sched.start();
            sched.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}