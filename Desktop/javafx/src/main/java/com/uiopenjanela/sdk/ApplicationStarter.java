package com.uiopenjanela.sdk;

import com.uiopenjanela.sdk.util.Callback;
import com.uiopenjanela.sdk.util.SimpleApplicationStarter;
import javafx.stage.Stage;

import java.util.function.Consumer;


public class ApplicationStarter {

    public static void run(Consumer<Stage> runner) {
        SimpleApplicationStarter.setStarter(runner);
        SimpleApplicationStarter.launch(SimpleApplicationStarter.class);
    }

    public static void run(Consumer<Stage> runner, Callback stopCallback) {
        SimpleApplicationStarter.setStarter(runner);
        SimpleApplicationStarter.setStopCallback(stopCallback);
        SimpleApplicationStarter.launch(SimpleApplicationStarter.class);
    }
}
