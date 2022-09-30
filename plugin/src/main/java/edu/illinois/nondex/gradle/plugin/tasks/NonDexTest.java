package edu.illinois.nondex.gradle.plugin.tasks;

import edu.illinois.nondex.common.ConfigurationDefaults;
import edu.illinois.nondex.common.Utils;
import edu.illinois.nondex.instr.Main;
import org.gradle.api.tasks.testing.Test;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.Project;

import java.io.File;
import java.util.Arrays;

public class NonDexTest extends Test {
    Project project = getProject();

    public static final String TASK_NAME = "nondexTest";

    public void init() {
        setDescription("Test with NonDex");
        setGroup("NonDex");
    }

    @TaskAction
    public void nondexTest() throws Exception {
        String commonPath = project.getBuildscript().getConfigurations().getByName("classpath").getAsPath();
        String outPath = project.getBuildDir().getAbsolutePath() + File.separator + "out.jar";
        Main.main(outPath);
        String args = "-Xbootclasspath/p:" + outPath + File.pathSeparator + commonPath;
        setJvmArgs(Arrays.asList(new String[]{args, "-D" + ConfigurationDefaults.PROPERTY_EXECUTION_ID + "=" + Utils.getFreshExecutionId()}));
        System.out.println("Running with arguments: " + getJvmArgs());
    }
}
