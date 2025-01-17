package org.example.exercisetwospringbatch.config;

import org.example.exercisetwospringbatch.entity.Person;
import org.example.exercisetwospringbatch.tasklet.DeleteFileTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {
    private final DeleteFileTasklet deleteFileTasklet;

    public BatchConfig(DeleteFileTasklet deleteFileTasklet) {
        this.deleteFileTasklet = deleteFileTasklet;
    }

    @Bean
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("static/people.csv"))
                .linesToSkip(1)
                .delimited()
                .names("id", "firstname", "lastname", "age")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {
                    {
                        setTargetType(Person.class);
                    }
                })
                .build();
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return person -> person;
    }

    @Bean
    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO person (id, lastname, firstname, age) VALUES (:id, :lastName, :firstName, :age)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importJob(JobRepository jobRepository, Step step, Step removalStep) {
        return new JobBuilder("importPeople", jobRepository)
                .start(step)
                .next(removalStep)
                .build();
    }

    @Bean
    public Step step(ItemReader<Person> reader,
                     ItemProcessor<Person, Person> processor,
                     ItemWriter<Person> writer,
                     JobRepository jobRepository,
                     PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .<Person, Person>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Step removalStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("removalStep", jobRepository)
                .tasklet(deleteFileTasklet)
                .transactionManager(transactionManager)
                .build();
    }
}
