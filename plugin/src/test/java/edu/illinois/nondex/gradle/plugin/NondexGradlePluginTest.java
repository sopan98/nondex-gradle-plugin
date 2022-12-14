/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.illinois.nondex.gradle.plugin;

import edu.illinois.nondex.gradle.plugin.tasks.NonDexHelp;
import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A simple unit test for the 'edu.illinois.nondex.gradle.plugin.greeting' plugin.
 */
class NondexGradlePluginTest {

    @Test void pluginRegistersATask() {
        // Create a test project and apply the plugin
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("edu.illinois.NondexGradlePlugin");
        // Verify the result
        assertNotNull(project.getTasks().findByName("greeting"));
    }
    @Test
    public void testAddTasksToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("edu.illinois.NondexGradlePlugin");
        assertTrue(project.getTasks().getByName(NonDexHelp.TASK_NAME) instanceof NonDexHelp);
    }
}
