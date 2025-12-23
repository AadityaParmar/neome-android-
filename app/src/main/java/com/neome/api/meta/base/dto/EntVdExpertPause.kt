// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdExpertPause : EntVdAutoStep()
{
  var canAdminResume: Boolean? = null
  var message: StudioValueParagraph? = null
  var option: MetaIdVar? = null
  var pauseKey: StudioValueText? = null
}