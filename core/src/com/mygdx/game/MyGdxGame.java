
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends Game
	{

	private GameScreen gameScreen;
	private MenuScreen menuScreen;
	private SettingsScreen settingsScreen;

	private int dt;

	public static final int MENU = 0;
	public static final int GAME = 1;
	public static final int SETTINGS = 2;

	@Override
	public void create()
		{
		dt = 0;

		menuScreen = new MenuScreen(this);
		this.setScreen(menuScreen);
		}

	@Override
	public void render()
		{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		dt += Gdx.graphics.getDeltaTime();

		this.getScreen().render(dt);
		}

	@Override
	public void dispose()
		{
		}

	public void changeScreen(int screen)
		{
		switch(screen)
			{
			case MENU:
				if (menuScreen == null)
					{
					menuScreen = new MenuScreen(this);
					}
				setScreen(menuScreen);
				break;

			case GAME:
				if (gameScreen == null)
					{
					gameScreen = new GameScreen(this);
					}
				setScreen(gameScreen);
				break;

			case SETTINGS:
				if (settingsScreen == null)
					{
					settingsScreen = new SettingsScreen(this);
					}
				setScreen(settingsScreen);
				break;
			default:
				break;
			}
		}
	}
