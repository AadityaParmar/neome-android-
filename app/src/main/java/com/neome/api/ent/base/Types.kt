// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base

class Types {
    enum class EnumAuditAction {
        INSERT,
        UPDATE,
        REMOVE
    }

    enum class EnumAutomationStateFilterKind {
        completed,
        pause,
        terminated,
        wait
    }

    enum class EnumAutomationStateKind {
        completed,
        pause,
        running,
        terminated,
        wait
    }

    enum class EnumFieldFilterValueType {
        bool,
        dateRange,
        longRange,
        doubleRange,
        stringSet,
        sysIdSet,
        nullable
    }

    enum class EnumGuaranteedRequestType {
        pluginRequest
    }

    enum class EnumLogType {
        pluginApi,
        report,
        location
    }

    enum class EnumWorkflowDebugActionKind {
        run,
        next
    }

    enum class EnumWorkflowResultKind {
        completed,
        pause,
        running,
        terminated,
        wait
    }
}
