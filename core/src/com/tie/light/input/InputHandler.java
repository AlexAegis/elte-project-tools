package com.tie.light.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputHandler implements InputProcessor, ControllerListener {

	private final Logger logger = Logger.getLogger(InputHandler.class.getName());

	// Stores which key is currently being pressed and when it got pressed
	private Map<InputKey, InputEvent> inputMap = new HashMap<>();

	// System input handling

	@Override
	public boolean keyDown(int keycode) {
		//logger.log(Level.INFO, "keyDown: " + keycode + ", " + Input.Keys.toString(keycode));
		inputMap.put(new InputKey(keycode, null), new InputEvent(System.currentTimeMillis()));
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		//logger.log(Level.INFO, "keyDown: " + keycode + ", " + Input.Keys.toString(keycode));
		inputMap.remove(new InputKey(keycode, null));
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	// Controller Handling

	@Override
	public void connected(Controller controller) {
		logger.log(Level.FINE, controller + " connected.");
	}

	@Override
	public void disconnected(Controller controller) {
		logger.log(Level.FINE, controller + " disconnected.");
	}

	@Override
	public boolean buttonDown(Controller controller, int buttonCode) {
		//logger.log(Level.FINER, controller + " buttonDown: " + buttonCode + ", ");
		inputMap.put(new InputKey(buttonCode, controller), new InputEvent(System.currentTimeMillis()));
		return false;
	}

	@Override
	public boolean buttonUp(Controller controller, int buttonCode) {
		//logger.log(Level.FINER, controller + " buttonUp  : " + buttonCode + ", " );
		inputMap.remove(new InputKey(buttonCode, controller));
		return false;
	}

	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value) {
		return false;
	}

	@Override
	public boolean povMoved(Controller controller, int povCode, PovDirection value) {
		return false;
	}

	@Override
	public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
		return false;
	}

	@Override
	public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
		return false;
	}

	@Override
	public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
		return false;
	}

	// Getters and Setters

	public Map<InputKey, InputEvent> getInputMap() {
		return inputMap;
	}

}