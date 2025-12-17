// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutForm extends StudioBase
{
  @Nullable
  public String description;

  public MetaIdLayoutForm metaId;

  public Symbol name;

  @Nullable
  public EnumDefnFormLayoutType type;
}
