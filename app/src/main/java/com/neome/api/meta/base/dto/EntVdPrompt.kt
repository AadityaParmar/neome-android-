// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.GhostId
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

open class EntVdPrompt : StudioBase()
{
  lateinit var metaId: GhostId
  var prompt: StudioValueCodeJavascript? = null
  var promptForm: FormRefKey? = null
}