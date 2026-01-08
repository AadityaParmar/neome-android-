// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnAudioFormat
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldAudio : DefnFieldEditable
{
  val audioFormatType: EnumDefnAudioFormat?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVar: Long?
}