package edu.illinois.nondex.gradle.plugin.tasks;

import edu.illinois.nondex.common.ConfigurationDefaults;
import edu.illinois.nondex.common.Utils;
import org.gradle.api.logging.LogLevel;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.tasks.testing.Test;
import org.gradle.api.Project;

import org.gradle.api.logging.Logger;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NonDexTest extends JavaExec {
    Project project = getProject();
    Logger logger = project.getLogger();

    public static final String TASK_NAME = "nondexTest";

    @Inject
    public NonDexTest() {
        System.out.println("Inside constructor");
        for (String str: getAllJvmArgs())
            System.out.println(str);
        System.out.println("Classpath");
        for (File str: getClasspath()){
            System.out.println(str.getName());
            System.out.println(str.getAbsolutePath());
            System.out.println(str.getPath());
        }
        System.out.println(getName());
        String classpath[] = System.getProperty("java.class.path").split(";");
        String instrumentedJarPath = Arrays.stream(classpath).filter(str -> str.contains("nondex-instrumentation")).collect(Collectors.joining());
        String commonJarPath = Arrays.stream(classpath).filter(str -> str.contains("nondex-common")).collect(Collectors.joining());
        String args = "-Xbootclasspath/p:" + instrumentedJarPath + File.pathSeparator + commonJarPath;
        String jvmArgs[] = new String[]{args, "-D" + ConfigurationDefaults.PROPERTY_EXECUTION_ID + "=" + Utils.getFreshExecutionId()};
        System.out.println("Running with arguments: " + getJvmArgs());
        setJvmArgs(Arrays.asList(jvmArgs));
        logger.log(LogLevel.DEBUG,"Running with arguments: " + getJvmArgs());
    }

    public void init() {
        setDescription("Test with NonDex");
        setGroup("NonDex");
    }

    @Override
    public void exec() {
        super.exec();
    }
}
