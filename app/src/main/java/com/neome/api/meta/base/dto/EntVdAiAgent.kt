// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAiAgentControlMap
import com.neome.api.meta.base.dto.EntVdAiWithOutput
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioValueParagraph

interface EntVdAiAgent : EntVdAiWithOutput
{
  val agentControlMap: EntVdAiAgentControlMap?
  val outputForm: FormRefKey?
  val systemMessage: StudioValueParagraph?
  val userMessage: StudioValueParagraph?
}