import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Popup;

//Create Pokemon player and CPU

	


public class PokemonMain extends Application {
	Canvas canvas = new Canvas(400, 300);
	
	Skill sk1 = new Skill("Ember", "Fire", 40);
	Skill sk2 = new Skill("Slash", "Fire", 70);
	Skill sk3 = new Skill("Flamethrower", "Fire", 95);
	Skill sk4 = new Skill("Fire Spin", "Fire", 15);
	
	Skill[] set1 = {sk1, sk2, sk3, sk4};
	Pokemon player = new Pokemon("Charmander", "Fire", 39, 52, 43, 65, set1);
	
	Skill sk5 = new Skill("Absorb", "Grass", 20);
	Skill sk6 = new Skill("Bullet Seed", "Grass", 25);
	Skill sk7 = new Skill("Giga Drain", "Grass", 75);
	Skill sk8 = new Skill("Bounce", "Grass", 85);
	
	Skill[] set2 = {sk1, sk2, sk3, sk4};
	Pokemon opponent = new Pokemon("Skiploom", "Grass", 55, 45, 200, 80, set2);

	public void battle(int choice) {
		
		int move = (int)(Math.random()*4);
		//redraw(0.4, 0.1);
		
		if (player.getPokemonSPD()>opponent.getPokemonSPD()) {
			opponent.assignPokemonHP(opponent.getPokemonHP() - opponent.attack(set1[choice].getSkillATK(), player.getPokemonATK(), opponent.getPokemonDEF(), player.getPokemonType(), set1[choice].getSkillType(), opponent.getPokemonType()));
			if (opponent.dead() == true) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.strokeText("You win!", 150, 20);
				
			}
			
			//System.out.println(opponent.getPokemonHP() - opponent.attack(set1[choice].getSkillATK(), player.getPokemonATK(), opponent.getPokemonDEF(), player.getPokemonType(), set1[choice].getSkillType(), opponent.getPokemonType()));
			player.assignPokemonHP(player.getPokemonHP() - player.attack(set2[move].getSkillATK(), opponent.getPokemonATK(), player.getPokemonDEF(), opponent.getPokemonType(), set2[move].getSkillType(), player.getPokemonType()));
			//ystem.out.println("world");
			if (player.dead() == true) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.strokeText("You loose!", 150, 20);				
			}
		}
		
		else {
			player.assignPokemonHP(player.getPokemonHP() - player.attack(set2[move].getSkillATK(), opponent.getPokemonATK(), player.getPokemonDEF(), opponent.getPokemonType(), set2[move].getSkillType(), player.getPokemonType()));
			//ystem.out.println("world");
			if (player.dead() == true) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.strokeText("You loose!", 150, 20);
				
			}
			opponent.assignPokemonHP(opponent.getPokemonHP() - opponent.attack(set1[choice].getSkillATK(), player.getPokemonATK(), opponent.getPokemonDEF(), player.getPokemonType(), set1[choice].getSkillType(), opponent.getPokemonType()));
			//System.out.println(opponent.getPokemonHP() - opponent.attack(set1[choice].getSkillATK(), player.getPokemonATK(), opponent.getPokemonDEF(), player.getPokemonType(), set1[choice].getSkillType(), opponent.getPokemonType()));
			if (opponent.dead() == true) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.strokeText("You win!", 150, 20);
			}
		}
		
		redraw((player.getPokemonHP()/player.getPokemonOriginalHP()), (opponent.getPokemonHP()/opponent.getPokemonOriginalHP()));
		
		if (player.dead() || opponent.dead()) {
			GraphicsContext gc = canvas.getGraphicsContext2D();		
			gc.strokeText("You win!", 150, 20);
		}
	}

	public void redraw(double playerHPFraction, double cpuHPFraction) {
		GraphicsContext graph = canvas.getGraphicsContext2D();
		graph.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		Image background = new Image("Background/forest.jpg");
		Image front = new Image("Front/188.png");
		Image back = new Image("Back/4.png");
		graph.drawImage(background, 0, 0, 400, 270);
		graph.drawImage(back, 0, 100, 200, 200);
		graph.drawImage(front, 250, 0, 150, 150);
		
		//display player HP
		if (playerHPFraction > 0.5) {
			graph.setFill(Color.GREEN);
		} else if (playerHPFraction > 0.2) {
			graph.setFill(Color.YELLOW);
		} else {
			graph.setFill(Color.RED);
		}
		graph.fillRect(200, 200, 150 * playerHPFraction, 10); // Player HP Bar
		
		//display CPU HP
		if (cpuHPFraction > 0.5) {
			graph.setFill(Color.GREEN);
		} else if (cpuHPFraction > 0.2) {
			graph.setFill(Color.YELLOW);
		} else {
			graph.setFill(Color.RED);
		}
		graph.setStroke(Color.BLACK);
		graph.fillRect(100, 60, 150 * cpuHPFraction, 10); // CPU HP Bar
	}
	
	public void printText(String a) {
		Text text = new Text();
		text.setText(a); 
		text.setX(50); 
	    text.setY(50);
	}	   

	public Scene initialize() {
		redraw(1.0, 1.0);

		Button s1 = new Button("Skill 1");
		s1.setOnAction(evt -> {
			battle(0);
		});
		Button s2 = new Button("Skill 2");
		s2.setOnAction(evt -> {
			battle(1);
		});
		Button s3 = new Button("Skill 3");
		s3.setOnAction(evt -> {
			battle(2);
		});
		Button s4 = new Button("Skill 4");
		s4.setOnAction(evt -> {
			battle(3);
		});
		HBox buttonBar = new HBox(20, s1, s2, s3, s4);
		buttonBar.setAlignment(Pos.CENTER);
		BorderPane root = new BorderPane();
		root.setCenter(canvas);
		root.setBottom(buttonBar);

		Scene scene = new Scene(root, 500, 400);
		return scene;
	}

	public void start(Stage stage) {

		Scene scene = initialize();
		stage.setScene(scene);
		stage.setTitle("Pokemon");
		stage.show();

	} // end start();

	public static void main(String[] args) {
		launch(); // Run this Application.
	}
} // end class HelloWorldFX
