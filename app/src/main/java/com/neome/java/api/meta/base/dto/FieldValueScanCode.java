// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnScanCodeType;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class FieldValueScanCode
{
  @Nullable
  public FieldValueLocation captureLocation;

  @Nullable
  public Date captureTime;

  @Nullable
  public FieldValueEntUserId captureUser;

  public String scanCode;

  public EnumDefnScanCodeType scanCodeType;
}
