package org.gradle.plugin.flyway.task

import org.gradle.api.tasks.TaskAction
import com.googlecode.flyway.core.metadatatable.MetaDataTableRow

class StatusTask extends AbstractFlywayTask {

    @TaskAction
    def status() {
        MetaDataTableRow metaTableRow = flyway.status()
        StringBuilder builder = new StringBuilder("-------------Schema Status------------\n")
        builder.append("Version :").append(metaTableRow.getVersion()).append("\n")
            .append("Description :").append(metaTableRow.getDescription()).append("\n")
            .append("Type :").append(metaTableRow.getMigrationType()).append("\n")
            .append("Installed On :").append(metaTableRow.getInstalledOn()).append("\n")
            .append("State :").append(metaTableRow.getState())

        println builder.toString()
    }
}