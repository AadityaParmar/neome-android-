// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigSpreadsheetRowExpiry extends Sig
{
  @Nullable
  public Long remainingInvisibleProgressPercentage;

  @Nullable
  public Long remainingInvisibleTimeMillis;

  @Nullable
  public Long remainingReadProgressPercentage;

  @Nullable
  public Long remainingReadTimeMillis;

  @Nullable
  public Boolean showTimer;
}
