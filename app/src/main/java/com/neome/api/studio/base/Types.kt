// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base

object Types
{
  enum class EnumEntActivityState(val value: String)
  {
    active("active"),
    inactive("inactive"),
    dead("dead")
  }

  enum class EnumEntDeployExecutionState(val value: String)
  {
    created("created"),
    initiated("initiated"),
    inProgress("inProgress"),
    completed("completed"),
    failed("failed")
  }
}