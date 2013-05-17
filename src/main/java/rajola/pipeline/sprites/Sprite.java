package rajola.pipeline.sprites;

import java.util.ArrayList;
import java.util.Collection;

import org.newdawn.slick.Image;

public class Sprite {

	private int height;
	private int width;
	private Collection<Image> frames;
	private int currentFrame;
	private int animationSpeed;
	
	public Sprite() {
		frames = new ArrayList<Image>();
		animationSpeed = 1000;
	}
	
	/**
	 * @param animationSpeed the animation speed in milliseconds
	 */
	public Sprite(int animationSpeed) {
		frames = new ArrayList<Image>();
		this.animationSpeed = animationSpeed;
	}
	
	/*
	 * Sets width and height in pixels
	 * Sets animation speed in milliseconds
	 */
	public Sprite(int height, int width, int animationSpeed){
		this();
		this.height = height;
		this.width = width;
		this.animationSpeed = animationSpeed;
	}
	

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the frames collection
	 */
	public Collection<Image> getFrames() {
		return frames;
	}

	/**
	 * @param frame adds a frame
	 */
	public void addFrame(Image frame) {
		this.frames.add(frame);
	}
	
	/**
	 * @param frame removes a frame
	 */
	public void removeFrame(Image frame) {
		this.frames.remove(frame);
	}
	
	/**
	 * Removes all frames
	 */
	public void removeAllFrame() {
		this.frames.clear();
		currentFrame = 0;
	}

	/**
	 * @return the currentFrame
	 */
	public int getCurrentFrame() {
		return currentFrame;
	}

	/**
	 * @param currentFrame the currentFrame to set
	 */
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	/**
	 * @return the animationSpeed
	 */
	public int getAnimationSpeed() {
		return animationSpeed;
	}

	/**
	 * @param animationSpeed the animationSpeed to set
	 */
	public void setAnimationSpeed(int animationSpeed) {
		this.animationSpeed = animationSpeed;
	}
	
}
