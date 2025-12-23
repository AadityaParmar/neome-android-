// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnStudioBuildArgBinder
import com.neome.api.meta.base.dto.DefnStudioPickPluginFieldId

open class DefnStudioBuildMapping : DefnField()
{
  var from: DefnStudioBuildArgBinder? = null
  var to: DefnStudioPickPluginFieldId? = null
}