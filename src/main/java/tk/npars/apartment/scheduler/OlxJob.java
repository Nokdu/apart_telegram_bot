package tk.npars.apartment.scheduler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import tk.npars.apartment.manager.OlxManager;


public class OlxJob implements Job {

    private static final Logger logger = LogManager.getLogger(OlxJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        logger.info("start job");
        new OlxManager().checkManager();
    }
}

