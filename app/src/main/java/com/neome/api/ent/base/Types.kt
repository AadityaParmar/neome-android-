// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base

class Types {
    enum class EnumAuditAction(val value: String) {
        INSERT("INSERT"),
        UPDATE("UPDATE"),
        REMOVE("REMOVE")
    }

    enum class EnumAutomationStateFilterKind(val value: String) {
        completed("completed"),
        pause("pause"),
        terminated("terminated"),
        wait("wait")
    }

    enum class EnumAutomationStateKind(val value: String) {
        completed("completed"),
        pause("pause"),
        running("running"),
        terminated("terminated"),
        wait("wait")
    }

    enum class EnumFieldFilterValueType(val value: String) {
        bool("bool"),
        dateRange("dateRange"),
        longRange("longRange"),
        doubleRange("doubleRange"),
        stringSet("stringSet"),
        sysIdSet("sysIdSet"),
        nullable("nullable")
    }

    enum class EnumGuaranteedRequestType(val value: String) {
        pluginRequest("pluginRequest")
    }

    enum class EnumLogType(val value: String) {
        pluginApi("pluginApi"),
        report("report"),
        location("location")
    }

    enum class EnumWorkflowDebugActionKind(val value: String) {
        run("run"),
        next("next")
    }

    enum class EnumWorkflowResultKind(val value: String) {
        completed("completed"),
        pause("pause"),
        running("running"),
        terminated("terminated"),
        wait("wait")
    }
}
