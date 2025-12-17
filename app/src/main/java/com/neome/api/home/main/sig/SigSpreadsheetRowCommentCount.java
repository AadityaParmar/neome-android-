// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigSpreadsheetRowCommentCount extends SigVersion
{
  @Nullable
  public Long commentCount;

  @Nullable
  public Long unreadCommentCount;
}
