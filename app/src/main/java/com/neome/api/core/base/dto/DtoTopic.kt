// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.core.base.Types.EnumTopicType
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types.ArtifactId

class DtoTopic {
    val aboutId: SysId
    val artifactId: ArtifactId
    val type: EnumTopicType
}
