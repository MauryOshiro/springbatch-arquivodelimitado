package com.springbatch.arquivodelimitado.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoDelimitadoJobConfig {
	
	@Bean
	public Job arquivoDelimitadoJob(Step leituraArquivoDelimitadoStep, JobRepository repository) {
		return new JobBuilder("arquivoDelimitadoJob", repository)
				.start(leituraArquivoDelimitadoStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
