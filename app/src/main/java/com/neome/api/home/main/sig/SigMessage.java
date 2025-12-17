// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.home.base.Types.EnumReceiptStatus;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigMessage extends SigMessageBase
{
  @Nullable
  public EnumReceiptStatus receiptStatus;

  @Nullable
  public String version;
}
