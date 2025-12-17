// neome.ai API - do not change
//

package com.neome.api.core.otp.msg;

import com.neome.api.meta.base.AnyKey;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgQrCodeVerify extends Msg
{
  public AnyKey verifyKey;
}