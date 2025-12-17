// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSection;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickSectionId extends DefnFieldEditable
{
  @Nullable
  public MetaIdSection[] excludeSectionIdSet;

  public MetaIdForm formId;
}
