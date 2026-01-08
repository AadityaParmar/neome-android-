// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.Types.MetaIdVar

interface EntVdAiFormToClassification : EntVdAi
{
  val classificationVarId: MetaIdVar?
}