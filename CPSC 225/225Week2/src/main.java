import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class main extends Application {

	private Canvas canvas;

	private Image cardImages;

	private Player human = new Player();
	private Player cpu = new Player();
	private Card humanMiddle = null;
	private Card cpuMiddle = null;

	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage) {
		cardImages = new Image("cards.png");

		canvas = new Canvas(10 * 75 + 40, 110 * 5 + 150);
		draw();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent event) -> {
			game_played(canvas, event);
		});

		Pane root = new Pane(canvas);

		stage.setScene(new Scene(root, Color.BLACK));
		stage.setTitle("Random Cards");
		stage.setResizable(false);
		stage.show();
	}

	private void game_played(Canvas canvas, MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		boolean played = false;
		boolean cpu_played = false;

		for (int i = 0; i < human.getHand().size(); i++) {
			if (x > 20 + 75 * (i % 10) && x < 20 + 75 * (i % 10) + 75 && y > 400 + 110 * (i / 10)
					&& y < 400 + 110 * (i / 10) + 110 && (cpuMiddle == null || human.getCard(i).color == cpuMiddle.color
							|| human.getCard(i).value == cpuMiddle.value || cpu.getCard(i).color == Card.BLACK)) {
				Card c = human.getHand().get(i);
				humanMiddle = c;
				human.getHand().remove(i);
				played = true;
				break;
			}
		}

		if (x > 340 && x < 460 && y > 640 && y < 680) {
			human.draw();
			played = true;
		}

		// if (!played)
		// return;
		if (played == true) {
			if (cpu.getHand().size() > 0 && humanMiddle != null) { // CPU side.

				if (humanMiddle.value == Card.draw) { // If the last card human played is +2
					for (int i = 0; i < 2; i++)
						cpu.draw();
				}

				if (humanMiddle.value != Card.skip) {
					for (int i = 0; i < cpu.getHand().size(); i++) { // check which card the cpu can play
						if (cpu.getCard(i).color == humanMiddle.color || cpu.getCard(i).value == humanMiddle.value
								|| cpu.getCard(i).color == Card.BLACK || humanMiddle.color == Card.BLACK) {
							cpuMiddle = cpu.getHand().get(i);
							cpu.getHand().remove(i);
							cpu_played = true;
							break;
						}
					}
					if (!cpu_played) // If the cpu couldn't play
						cpu.draw();
				}
			}

			if (humanMiddle == null) {
				cpuMiddle = cpu.getHand().get(0);
				cpu.getHand().remove(0);
			}

			if (cpuMiddle.value == Card.draw) { // If the last card cpu played is +2
				for (int i = 0; i < 2; i++)
					human.draw();
			}
		}

		GraphicsContext g = canvas.getGraphicsContext2D();
		g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		draw();
	}

	private void draw() {

		GraphicsContext g = canvas.getGraphicsContext2D();

		g.setTextAlign(TextAlignment.CENTER);
		g.setFill(Color.WHITE);
		g.setFont(new Font(40));
		g.fillText("DRAW", Math.round(canvas.getWidth() / 2), 670);

		double sx, sy;
		double dx, dy;

		for (int i = 0; i < human.getHand().size(); i++) {
			Card card = human.getHand().get(i);

			sx = 411 + card.value * 73;
			sy = 120 + card.color * 115;
			dx = 20 + 75 * (i % 10);
			dy = 400 + 110 * (i / 10);
			if (card.color == card.BLACK) {
				sx = 411;
				sy = 120 + card.color * 115;
			}
			g.drawImage(cardImages, sx, sy, 73, 115, dx, dy, 75, 110);
		}

		for (int i = 0; i < cpu.getHand().size(); i++) {
			Card card = cpu.getHand().get(i);

			sx = 5;
			sy = 14;
			dx = 20 + 75 * (i % 10);
			dy = 0 + 110 * (i / 10);
			g.drawImage(cardImages, sx, sy, 73, 115, dx, dy, 75, 110);
		}

		if (humanMiddle != null) {
			sx = 411 + humanMiddle.value * 73;
			sy = 120 + humanMiddle.color * 115;
			dx = 20 + 75 * 4.5;
			dy = 280;

			if (humanMiddle.color == humanMiddle.BLACK) {
				sx = 411;
				sy = 120 + humanMiddle.color * 115;
			}

			g.setGlobalAlpha(0.7);
			g.drawImage(cardImages, sx, sy, 73, 115, dx, dy, 75, 110);
			g.setGlobalAlpha(1);
		}

		if (cpuMiddle != null) {
			sx = 411 + cpuMiddle.value * 73;
			sy = 120 + cpuMiddle.color * 115;
			dx = 20 + 75 * 4.5 + 20;
			dy = 230;
			if (cpuMiddle.color == cpuMiddle.BLACK) {
				sx = 411;
				sy = 120 + cpuMiddle.color * 115;
			}
			g.drawImage(cardImages, sx, sy, 73, 115, dx, dy, 75, 110);
		}

	}

}