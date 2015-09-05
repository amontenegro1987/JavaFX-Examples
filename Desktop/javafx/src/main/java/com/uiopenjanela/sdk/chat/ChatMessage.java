package com.uiopenjanela.sdk.chat;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

public interface ChatMessage {

    BooleanProperty sendByMeProperty();

    StringProperty messageProperty();
}
