
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SettingsScreen implements Screen
	{

	private MyGdxGame parent;
	private Stage stage;
	private SpriteBatch batch;
	private Texture background;
	private Sound clickSound;

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SettingsScreen(MyGdxGame parent)
		{
		this.parent = parent;
		this.stage = new Stage(new ScreenViewport());
		this.batch = new SpriteBatch();
		this.background = new Texture("background-menu.jpg");
		this.clickSound = Gdx.audio.newSound(Gdx.files.internal("music/click-sound.mp3"));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void show()
		{
		Gdx.input.setInputProcessor(stage);
		Table table = new Table();
		table.setFillParent(true);
		//		table.setSize(400, stage.getHeight());
		stage.addActor(table);

		Skin skin = new Skin(Gdx.files.internal("skin/neutralizer-ui.json"));

		Label lblTitle = new Label("Settings", skin);
		Label lblResolution = new Label("Resolution : ", skin);
		Label lblVolume = new Label("Volume : ", skin);

		SelectBox<String> slbResolution = new SelectBox<String>(skin);
		slbResolution.setItems("1024x720");

		Slider sldVolume = new Slider(0f, 1f, 0.1f, false, skin);

		TextButton btnBack = new TextButton("Back", skin);
		TextButton btnApply = new TextButton("Apply", skin);

		table.row().padBottom(80);
		table.row().width(300);
		table.add(lblTitle).height(20).width(100).center().colspan(2);
		table.row().width(300);
		table.row().pad(80, 0, 10, 0);
		table.add(lblResolution).height(40).left();
		table.add(slbResolution).height(40);
		table.row().pad(10, 0, 10, 0);
		table.add(lblVolume).height(40).left();
		table.add(sldVolume).height(40).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);
		table.add(btnApply).height(40).fillX().uniformX().colspan(2);
		table.row().pad(10, 0, 10, 0);
		table.add(btnBack).height(40).fillX().uniformX().colspan(2);

		btnApply.addListener(new ChangeListener()
			{

			@Override
			public void changed(ChangeEvent event, Actor actor)
				{
				clickSound.play();

				}
			});

		btnBack.addListener(new ChangeListener()
			{

			@Override
			public void changed(ChangeEvent event, Actor actor)
				{
				clickSound.play();
				SettingsScreen.this.parent.changeScreen(MyGdxGame.MENU);
				}
			});
		}

	@Override
	public void render(float delta)
		{
		// clear the screen ready for next set of images to be drawn
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(background, 0, 0, stage.getWidth(), stage.getHeight());
		batch.end();

		// tell our stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

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
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
