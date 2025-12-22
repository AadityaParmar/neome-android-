// neome.ai API - do not change
//

package com.neome.java.api.core.otp.msg;

import com.neome.java.api.meta.base.AnyKey;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgQrCodeVerify extends Msg
{
  public AnyKey verifyKey;
}
