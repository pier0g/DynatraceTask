package pl.dynatrace.task;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplicationWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Prime Numbers Task");
        VBox vBox = new VBox(5);
        Label dataLabel = new Label("Data");
        Label primesLabel = new Label("Prime Numbers");
        TextArea dataTextArea = new TextArea();
        TextArea primesTextArea = new TextArea();
        Button button = new Button("GENERATE");

        dataTextArea.setWrapText(true);
        dataTextArea.setEditable(false);
        primesTextArea.setWrapText(true);
        primesTextArea.setEditable(false);

        vBox.setPadding(new Insets(5));
        vBox.getChildren().addAll(dataLabel, dataTextArea, primesLabel, primesTextArea, button);

        button.setOnAction(e -> {
            RandomNumberGeneratorClient randomNumberGeneratorClient = new RandomNumberGeneratorClient();
            RandomNumbersResponse response = randomNumberGeneratorClient.readRandomNumbers();

            PrimesExtractor primesExtractor = new PrimesExtractor();
            dataTextArea.setText(response.getData().toString());
            primesTextArea.setText(primesExtractor.extract(response).toString());
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(vBox);

        Scene scene = new Scene(layout, 700, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
