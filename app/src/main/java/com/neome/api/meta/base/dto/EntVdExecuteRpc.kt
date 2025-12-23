// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.Types.EnumDefnHttpMethod
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioValueText

open class EntVdExecuteRpc : EntVdAutoStepWithOutputAndError()
{
  var apiMethod: EnumDefnHttpMethod? = null
  var apiName: StudioValueText? = null
  var inputParamId: MetaIdPipelineParam? = null
  var outputForm: FormRefKey? = null
  var sendKeychainId: KeychainId? = null
}