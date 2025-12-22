// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class SigUserLastOnline extends Sig
{
  public EntId entId;

  public EntUserId entUserId;

  @Nullable
  public Date lastOnline;

  @Nullable
  public Boolean online;
}
