// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAiAgentControlMap
import com.neome.api.meta.base.dto.EntVdAiWithOutput
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioValueParagraph

open class EntVdAiAgent : EntVdAiWithOutput()
{
  var agentControlMap: EntVdAiAgentControlMap? = null
  var outputForm: FormRefKey? = null
  var systemMessage: StudioValueParagraph? = null
  var userMessage: StudioValueParagraph? = null
}