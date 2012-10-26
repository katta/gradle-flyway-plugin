package org.katta.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway

class FlywayTask extends AbstractFlywayTask {

    @Override
    void executeTask(Flyway flyway) {
        def taskAction = this.name.replaceFirst("flyway","").toLowerCase();
        println "Executing flyway $taskAction"

        flyway ."$taskAction"()
    }
}
