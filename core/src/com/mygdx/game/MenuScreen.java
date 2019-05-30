
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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen
	{

	private MyGdxGame parent;
	private Stage stage;
	private SpriteBatch batch;
	private Texture background;
	private Sound menuMusic;
	private Sound clickSound;
	//	private OrthographicCamera cam;

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public MenuScreen(MyGdxGame parent)
		{
		batch = new SpriteBatch();
		//		this.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.parent = parent;
		this.background = new Texture("background-menu.jpg");
		this.menuMusic = Gdx.audio.newSound(Gdx.files.internal("music/menu-music.ogg"));
		this.clickSound = Gdx.audio.newSound(Gdx.files.internal("music/click-sound.mp3"));
		//		this.stage = new Stage(new ScreenViewport(cam));
		this.stage = new Stage(new ScreenViewport());
		//		this.stage.getViewport().setScreenSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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

		Label lblTitle = new Label("YARTS", skin);

		TextButton btnNewGame = new TextButton("New Game", skin);
		TextButton btnSettings = new TextButton("Settings", skin);
		TextButton btnExit = new TextButton("Exit", skin);

		table.row().padBottom(80);
		table.row().width(300);
		table.add(lblTitle).height(20).width(50).center();
		table.row().width(300);
		table.row().pad(80, 0, 10, 0);
		table.add(btnNewGame).height(40).fillX().uniformX().center();
		table.row().pad(10, 0, 10, 0);
		table.add(btnSettings).height(40).fillX().uniformX().center();
		table.row().pad(10, 0, 10, 0);
		table.add(btnExit).height(40).fillX().uniformX().center();

		btnNewGame.addListener(new ChangeListener()
			{

			@Override
			public void changed(ChangeEvent event, Actor actor)
				{
				menuMusic.stop();
				clickSound.play();
				MenuScreen.this.parent.changeScreen(MyGdxGame.GAME);
				}
			});

		btnSettings.addListener(new ChangeListener()
			{

			@Override
			public void changed(ChangeEvent event, Actor actor)
				{
				clickSound.play();
				MenuScreen.this.parent.changeScreen(MyGdxGame.SETTINGS);
				}
			});

		btnExit.addListener(new ChangeListener()
			{

			@Override
			public void changed(ChangeEvent event, Actor actor)
				{
				clickSound.play();
				//				try
				//					{
				//					Thread.sleep(500);
				//					}
				//				catch (InterruptedException e)
				//					{
				//					// TODO Auto-generated catch block
				//					e.printStackTrace();
				//					}
				Gdx.app.exit();
				}
			});

		menuMusic.loop();

		}

	@Override
	public void render(float delta)
		{
		// clear the screen ready for next set of images to be drawn
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//		batch.setProjectionMatrix(cam.combined);
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

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
