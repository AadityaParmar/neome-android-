// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickGridId extends DefnFieldEditable
{
  @Nullable
  public MetaIdGrid[] excludeGridIdSet;

  public MetaIdForm formId;
}
