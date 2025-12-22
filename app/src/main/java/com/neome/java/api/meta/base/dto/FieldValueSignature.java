// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class FieldValueSignature
{
  @Nullable
  public FieldValueLocation captureLocation;

  @Nullable
  public Date captureTime;

  @Nullable
  public FieldValueEntUserId captureUser;

  public String handle;

  public String signature;
}
