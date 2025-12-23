// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.meta.base.SysId

open class DtoTopic
{
  lateinit var aboutId: SysId
  lateinit var artifactId: ArtifactId
  lateinit var type: EnumTopicType
}