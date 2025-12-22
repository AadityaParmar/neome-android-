// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDetails extends StudioBase
{
  @Nullable
  public String description;

  @Nullable
  public String label;

  @Nullable
  public StudioModuleSelection modules;

  public Symbol name;
}
