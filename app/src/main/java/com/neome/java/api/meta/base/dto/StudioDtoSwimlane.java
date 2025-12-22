// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdSwimlane;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoSwimlane extends StudioBase
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public String label;

  public MetaIdSwimlane metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public String valueOptionId;
}
