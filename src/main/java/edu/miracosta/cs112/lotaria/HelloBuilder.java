package edu.miracosta.cs112.lotaria;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class HelloBuilder implements Builder<Region> {

    public HelloBuilder()
    {

    }
    private LoteriaCard currentCard;
    private ImageView cardImage;
    private Label cardText;
    private Button drawButton;

    private Random rand = new Random();

    private ArrayList<LoteriaCard> cardsLeft;
    @Override
    public Region build() {
        cardsLeft = new ArrayList<LoteriaCard>(Arrays.asList(HelloApplication.LOTERIA_CARDS));

        Label label = new Label("Loteria!");
        label.setAlignment(Pos.CENTER);
        cardImage = new ImageView();
        cardImage.setFitWidth(350);
        cardImage.setFitHeight(500);
        cardText = new Label();
        cardText.setAlignment(Pos.CENTER);

        drawButton = new Button("Draw Random");
        drawButton.setOnAction(ev -> drawRandom());
        drawButton.setAlignment(Pos.CENTER);

        drawRandom();

        VBox box = new VBox(label, cardImage, cardText, drawButton);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    private void drawRandom() {
        int idx = rand.nextInt(cardsLeft.size());
        currentCard = cardsLeft.get(idx);
        cardsLeft.remove(idx);

        cardImage.setImage(currentCard.getImage());
        cardText.setText(currentCard.getCardName());
        if (cardsLeft.size() == 0) {
            drawButton.setDisable(true);
        }
    }
}