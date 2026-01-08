// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdWizard

interface DefnWizard : DefnComp
{
  val compositeIdSet: Array<MetaIdComposite>?
  val metaId: MetaIdWizard
  val navigationMode: EnumDefnWizardNavigationMode?
  val nextButtonLabel: String?
  val prevButtonLabel: String?
}