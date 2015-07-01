package ta.com.component.base;

import ta.com.component.TAMainActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.csipsimple.api.SipManager;

public class TABroardcastManager {

	public static void sendBroardCastStartSipService(final Context context) {

		Thread t = new Thread("StartSip") {
			public void run() {
				Intent serviceIntent = new Intent(SipManager.INTENT_SIP_SERVICE);
				// Optional, but here we bundle so just ensure we are using
				serviceIntent.setPackage(context.getPackageName());
				serviceIntent.putExtra(SipManager.EXTRA_OUTGOING_ACTIVITY, new ComponentName(context, TAMainActivity.class));
				context.startService(serviceIntent);
			};
		};

		t.start();
	}

}