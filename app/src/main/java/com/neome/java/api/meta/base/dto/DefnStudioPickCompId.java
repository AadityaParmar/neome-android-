// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnCompType;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickCompId extends DefnFieldEditable
{
  @Nullable
  public MetaIdComposite[] excludeCompositeIdSet;

  @Nullable
  public EnumDefnCompType[] filterCompTypeSet;

  public MetaIdForm formId;
}
