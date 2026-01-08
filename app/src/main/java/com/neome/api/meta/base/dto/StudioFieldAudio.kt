// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnAudioFormat
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldAudio : StudioFieldEditable
{
  val audioFormatType: EnumDefnAudioFormat?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVarId: MetaIdVar?
}