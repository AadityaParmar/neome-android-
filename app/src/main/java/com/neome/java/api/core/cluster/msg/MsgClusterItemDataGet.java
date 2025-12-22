// neome.ai API - do not change
//

package com.neome.java.api.core.cluster.msg;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgClusterItemDataGet extends Msg
{
  public String clusterItemId;

  @Nullable
  public EntId entId;
}
