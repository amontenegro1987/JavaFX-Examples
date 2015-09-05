package com.uiopenjanela.sdk.list;

import com.uiopenjanela.sdk.util.Media;
import com.uiopenjanela.sdk.util.RoundImageView;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class SimpleMediaListCell<T extends Media> extends MediaListCell<T> {

    private RoundImageView imageView;

    public SimpleMediaListCell() {
        imageView = new RoundImageView();
        setLeftContent(imageView);
        getStyleClass().add("simple-media-cell");
        itemProperty().addListener(e -> {
            titleProperty().unbind();
            descriptionProperty().unbind();
            imageView.imageProperty().unbind();
            if(getItem() != null) {
                titleProperty().bind(getItem().titleProperty());
                descriptionProperty().bind(getItem().descriptionProperty());
                imageView.imageProperty().bind(getItem().imageProperty());
            }
        });
    }

    public static <T extends Media> Callback<ListView<T>, ListCell<T>> createDefaultCallback() {
        return v -> new SimpleMediaListCell<>();
    }
}
