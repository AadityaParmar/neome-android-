// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickFormId extends DefnField
{
  @Nullable
  public String alias;

  @Nullable
  public Boolean allowSystemForms;

  @Nullable
  public MetaIdForm[] excludeFormIdSet;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;
}
