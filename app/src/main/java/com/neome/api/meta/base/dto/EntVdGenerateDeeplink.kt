// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdGenerateDeeplink : EntVdAutoStep()
{
  var deeplinkId: MetaIdDeeplink? = null
  var outputField: StudioDtoArgValueParameter? = null
  var spreadsheetEditorActionId: MetaIdAction? = null
}