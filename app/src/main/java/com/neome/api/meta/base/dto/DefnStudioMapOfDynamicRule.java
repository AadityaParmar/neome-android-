// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioMapOfDynamicRule extends DefnField
{
  @Nullable
  public MetaIdComposite[] compositeIdSet;

  public MetaIdForm formId;
}
