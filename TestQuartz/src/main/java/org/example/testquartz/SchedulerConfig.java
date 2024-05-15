package org.example.testquartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

@Configuration
public class SchedulerConfig {


    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(EmailJob.class);
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean trigger(JobDetail jobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail);
        // Exécution tous les jours à 9h
        trigger.setCronExpression("0 44 10 * * ?");
        return trigger;
    }
    /*
    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(PrintJob.class);
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean trigger(JobDetail jobDetail) {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(jobDetail);
        trigger.setRepeatInterval(5000); // Répéter toutes les 5 secondes
        return trigger;
    }

     */


}
