// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdMapping;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoMappingField extends StudioBase
{
  public StudioBuildArgBinder from;

  public MetaIdMapping metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public Boolean primary;

  public MetaIdField to;
}
