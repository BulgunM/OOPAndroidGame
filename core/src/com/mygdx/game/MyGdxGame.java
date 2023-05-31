package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameOOP.Game;
import com.mygdx.game.GameOOP.Magican.Magican;
import com.mygdx.game.GameOOP.Magican.Monk;
import com.mygdx.game.GameOOP.Shooter.Crossbowman;
import com.mygdx.game.GameOOP.Shooter.Sniper;
import com.mygdx.game.GameOOP.Units.Peasant;
import com.mygdx.game.GameOOP.Units.Spearman;
import com.mygdx.game.GameOOP.Units.Thief;
import com.mygdx.game.GameOOP.Units.Unit;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, thief, monk, peasant, rouge, sniper, spMan, crBowMan;
	Music music;
	Game game;
	
	@Override
	public void create () {
		game = new Game();

		batch = new SpriteBatch();
		fon = new Texture("фоны/"+Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Музыка/paul-romero-rob-king-combat-theme-0"+ (new Random().nextInt(4) + 1) +".mp3"));
		music.setVolume(.25f);
		music.setLooping(true);
		music.play();

		crBowMan = new Texture("персонажи/CrossBowMan.png");
		thief = new Texture("персонажи/Thief.png");
		monk = new Texture("персонажи/Monk.png");
		peasant = new Texture("персонажи/Peasant.png");
		rouge = new Texture("персонажи/Rouge.png");
		sniper = new Texture("персонажи/Sniper.png");
		spMan = new Texture("персонажи/SpearMan.png");
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		int dx = Gdx.graphics.getWidth()/12;
		int dy = Gdx.graphics.getHeight()/13;

		for (int i = Game.team1.size()-1; i >= 0; i--) {
			if(!Game.team1.get(i).die()) {
				if (Game.team1.get(i) instanceof Crossbowman) {
					batch.draw(crBowMan, Game.team1.get(i).getCoords()[1] * dx, Game.team1.get(i).getCoords()[0] * dy);
				}
				if (Game.team1.get(i) instanceof Peasant) {
					batch.draw(peasant, Game.team1.get(i).getCoords()[1] * dx, Game.team1.get(i).getCoords()[0] * dy);
				}
				if (Game.team1.get(i) instanceof Spearman) {
					batch.draw(spMan, Game.team1.get(i).getCoords()[1] * dx, Game.team1.get(i).getCoords()[0] * dy);
				}
			}
		}

		for (int i = Game.team2.size()-1; i >= 0; i--) {
			if(!Game.team2.get(i).die()) {
				if (Game.team2.get(i) instanceof Monk) {
					batch.draw(monk, Game.team2.get(i).getCoords()[1] * dx + monk.getWidth(),
							Game.team2.get(i).getCoords()[0] * dy, -monk.getWidth(), monk.getHeight());
				}
				if (Game.team2.get(i) instanceof Peasant) {
					batch.draw(peasant, Game.team2.get(i).getCoords()[1] * dx + peasant.getWidth(),
							Game.team2.get(i).getCoords()[0] * dy, -peasant.getWidth(), peasant.getHeight());
				}
				if (Game.team2.get(i) instanceof Sniper) {
					batch.draw(sniper, Game.team2.get(i).getCoords()[1] * dx + sniper.getWidth(),
							Game.team2.get(i).getCoords()[0] * dy, -sniper.getWidth(), sniper.getHeight());
				}
				if (Game.team2.get(i) instanceof Thief) {
					batch.draw(thief, Game.team2.get(i).getCoords()[1] * dx + thief.getWidth(),
							Game.team2.get(i).getCoords()[0] * dy, -thief.getWidth(), thief.getHeight());
				}
			}
		}
		batch.end();
		//if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
		//	game.step();
		}

	//}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}
