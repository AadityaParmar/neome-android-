// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSwimlane;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoSwimlane
{
  @Nullable
  public DefnDtoColor color;

  @Nullable
  public DefnDtoColor colorVar;

  @Nullable
  public String label;

  public MetaIdSwimlane metaId;

  @Nullable
  public String valueOptionId;
}
