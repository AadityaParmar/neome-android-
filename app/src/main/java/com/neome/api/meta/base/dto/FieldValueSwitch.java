// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class FieldValueSwitch
{
  @Nullable
  public FieldValueLocation captureLocation;

  @Nullable
  public Date captureTime;

  @Nullable
  public FieldValueEntUserId captureUser;

  public boolean value;
}
