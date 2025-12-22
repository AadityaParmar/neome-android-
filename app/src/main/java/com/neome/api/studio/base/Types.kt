// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base

class Types {
    enum class EnumEntActivityState {
        active,
        inactive,
        dead
    }

    enum class EnumEntDeployExecutionState {
        created,
        initiated,
        inProgress,
        completed,
        failed
    }
}
