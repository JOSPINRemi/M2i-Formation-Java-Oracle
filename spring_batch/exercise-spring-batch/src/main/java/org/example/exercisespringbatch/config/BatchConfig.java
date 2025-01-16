package org.example.exercisespringbatch.config;

import org.example.exercisespringbatch.entity.Dinosaur;
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
    public BatchConfig() {
    }

    @Bean
    public FlatFileItemReader<Dinosaur> reader() {
        return new FlatFileItemReaderBuilder<Dinosaur>()
                .name("dinosaurItemReader")
                .resource(new ClassPathResource("dinosaurs.csv"))
                .linesToSkip(1)
                .delimited().names("id", "name", "species", "age_million_years")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {
            {
                setTargetType(Dinosaur.class);
            }
        }).build();
    }

    @Bean
    public ItemProcessor<Dinosaur, Dinosaur> processor() {
        return dinosaur -> {
            dinosaur.setAgeMillionYears(dinosaur.getAgeMillionYears() * 25);
            return dinosaur;
        };
    }

    @Bean
    public JdbcBatchItemWriter<Dinosaur> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Dinosaur>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO dinosaur (id, name, species, age_million_years) VALUES (:id, :name, :species, :ageMillionYears)")
                .dataSource(dataSource).build();
    }

    @Bean
    public Job importJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("importDinosaursJob", jobRepository).start(step).build();
    }

    @Bean
    public Step step(ItemReader<Dinosaur> reader, ItemProcessor<Dinosaur, Dinosaur> processor, ItemWriter<Dinosaur> writer, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .<Dinosaur, Dinosaur>chunk(10, transactionManager)
                .reader(reader).processor(processor).writer(writer).build();
    }
}
