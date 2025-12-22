// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.home.base.Types.EnumReceiptStatus;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigMessage extends SigMessageBase
{
  @Nullable
  public EnumReceiptStatus receiptStatus;

  @Nullable
  public String version;
}
