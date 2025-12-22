// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigSpreadsheetRowCommentCount extends SigVersion
{
  @Nullable
  public Long commentCount;

  @Nullable
  public Long unreadCommentCount;
}
