package me.xelantro.info;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;

public class Test4 extends Main.Run implements org.jnativehook.mouse.NativeMouseListener{
	@Override
	public void run()
	{
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeMouseListener(this);
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		sysLog("jo");

	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
