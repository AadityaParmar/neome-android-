// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindReport;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntReport extends StudioBase
{
  public StudioDetails details;

  @Nullable
  public MetaIdForm inputFormId;

  public EnumDefnKindReport kind;

  public MetaIdReport metaId;

  @Nullable
  public MetaIdForm outputFormId;
}
