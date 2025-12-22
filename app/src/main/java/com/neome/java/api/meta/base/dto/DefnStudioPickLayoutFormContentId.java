// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnFormLayoutType;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickLayoutFormContentId extends DefnField
{
  @Nullable
  public MetaIdLayoutForm[] excludeLayoutFormContentIdSet;

  @Nullable
  public EnumDefnFormLayoutType[] filterKindSet;

  public MetaIdForm formId;
}
