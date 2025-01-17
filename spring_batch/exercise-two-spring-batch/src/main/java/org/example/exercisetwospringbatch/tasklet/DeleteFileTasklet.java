package org.example.exercisetwospringbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DeleteFileTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String filename = chunkContext.getStepContext().getJobParameters().get("filename").toString();
        File file = new File("./src/main/resources/static" + filename);
        if (file.exists()) {
            file.delete();
        }
        return RepeatStatus.FINISHED;
    }
}
