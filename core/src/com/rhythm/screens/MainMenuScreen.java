package com.rhythm.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.rhythm.game.RhythmGame;

public class MainMenuScreen implements Screen {
	
	private int[] toClick = {0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()};
	
	private RhythmGame rg;
	
	private BitmapFont font;
	
	public MainMenuScreen(RhythmGame rg){
		this.rg = rg;
		Gdx.input.setInputProcessor(new MouseHandler());
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}
	
	@Override
	public void show() {}

	@Override
	public void render(float deltaTime) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		rg.batch.begin();
		font.draw(rg.batch, "Click anywhere", 200, 300);
		rg.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}
	
	public class MouseHandler implements InputProcessor {

		@Override
		public boolean keyDown(int keycode) {
			return false;
		}

		@Override
		public boolean keyUp(int keycode) {
			return false;
		}

		@Override
		public boolean keyTyped(char character) {
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			System.out.print("Test");
			if(screenX > toClick[0] && screenX < toClick[2] && screenY > toClick[1] && screenY < toClick[3]){
				rg.getScreen().dispose();
				rg.setScreen(new GameScreen(rg));
			}
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
		
	}

}
