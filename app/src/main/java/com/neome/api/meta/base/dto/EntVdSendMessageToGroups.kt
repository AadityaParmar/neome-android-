// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoUserFilter
import com.neome.api.meta.base.dto.StudioValueParagraph

open class EntVdSendMessageToGroups : EntVdAutoStep()
{
  var message: StudioValueParagraph? = null
  var sender: StudioBuildArgBinder? = null
  var toGroupIdSet: Array<MetaIdGroup>? = null
  var toUsers: StudioDtoUserFilter? = null
}