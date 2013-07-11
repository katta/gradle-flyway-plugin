package org.katta.gradle.plugin.flyway.task

import com.googlecode.flyway.core.Flyway
import com.googlecode.flyway.core.api.MigrationInfo

class StatusTask extends AbstractFlywayTask {

    @Override
    void executeTask(Flyway flyway) {

        MigrationInfo info = flyway.info().current()
        StringBuilder builder = new StringBuilder("-------------Schema Status------------\n")
        builder.append("Version :").append(info.getVersion()).append("\n")
                .append("Description :").append(info.getDescription()).append("\n")
                .append("Type :").append(info.getType()).append("\n")
                .append("Installed On :").append(info.getInstalledOn()).append("\n")
                .append("State :").append(info.getState())

        println builder.toString()
    }
}