// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdGenerateDeeplink : EntVdAutoStep
{
  val deeplinkId: MetaIdDeeplink?
  val outputField: StudioDtoArgValueParameter?
  val spreadsheetEditorActionId: MetaIdAction?
}