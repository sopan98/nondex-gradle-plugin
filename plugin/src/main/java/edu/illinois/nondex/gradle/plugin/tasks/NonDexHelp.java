package edu.illinois.nondex.gradle.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

public class NonDexHelp extends DefaultTask {
    public static final String TASK_NAME = "nondexHelp";

    public void init() {
        setDescription("Display NonDex Help");
        setGroup("NonDex");
    }

    @TaskAction
    public void helpMessage() throws IOException {
        String helpMessage = IOUtils.toString(NonDexHelp.class.getClassLoader().getResourceAsStream("nondexHelp.txt"), StandardCharsets.UTF_8);
        System.out.println(helpMessage);
    }
}
