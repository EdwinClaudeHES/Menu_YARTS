
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen
	{

	private Game parent;

	SpriteBatch batch;
	Texture img;

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public GameScreen(Game parent)
		{
		this.parent = parent;

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void show()
		{
		//TODO
		}

	@Override
	public void render(float delta)
		{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		}

	@Override
	public void resize(int width, int height)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void pause()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void resume()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void hide()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void dispose()
		{
		batch.dispose();
		img.dispose();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
