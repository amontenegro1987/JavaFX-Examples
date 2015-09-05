package com.uiopenjanela.sdk.demos;

import com.uiopenjanela.sdk.Application;
import com.uiopenjanela.sdk.action.Action;
import com.uiopenjanela.sdk.chat.ChatTimeline;
import com.uiopenjanela.sdk.chat.DefaultChatMessage;
import com.uiopenjanela.sdk.container.WorkbenchView;
import com.uiopenjanela.sdk.footer.ActionFooter;
import com.uiopenjanela.sdk.form.EditorType;
import com.uiopenjanela.sdk.form.FormLayout;
import com.uiopenjanela.sdk.image.SimpleImageView;
import com.uiopenjanela.sdk.list.MediaList;
import com.uiopenjanela.sdk.overlay.Overlay;
import com.uiopenjanela.sdk.util.DefaultMedia;
import com.uiopenjanela.sdk.util.Icon;
import com.uiopenjanela.sdk.util.Media;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;

public class SimpleViewAppDemo1 {

    public static void main(String... args) {

        Application app = new Application();
        app.setTitle("MyApp");
        app.setBaseColor(Color.DARKORCHID);
        app.addToolbarItem(new Action(Icon.VOLUMNE_DOWN, () -> app.animateToolbarToLargeVersion()));
        app.addToolbarItem(new Action(Icon.VOLUMNE_UP, () -> app.animateToolbarToSmallVersion()));

        app.setToolbarBackgroundImage(SimpleViewAppDemo1.class.getResource("toolbar-background.png").toExternalForm());

        app.addMenuEntry(new Action(Icon.CALENDAR, "Google Calendar", () -> showPersonList(app)));
        app.addMenuEntry(new Action(Icon.COGS, "System Settings", () -> showForm(app)));
        app.addMenuEntry(new Action(Icon.MAIL, "Mail", () -> showImage(app)));

        app.setMediaAsMenuHeader(new DefaultMedia("User4711", "Ich bin eine Beschreibung.", SimpleViewAppDemo1.class.getResource("user-13.jpg").toExternalForm()));

        app.setMenuFooter(new Action(Icon.COGS, "Configure"));

        showImage(app);

        app.show();
    }

    private static void showForm(Application app) {
        FormLayout formLayout = new FormLayout();

        formLayout.addHeader("Ich bin eine Form");
        formLayout.addField("Name");
        formLayout.addField("Description", EditorType.TEXTAREA);

        formLayout.addSeperator();

        formLayout.addField("Gender", EditorType.COMBOBOX);
        formLayout.addField("Age");

        formLayout.addHeader("Adresse", "Bitte die Mail-Adresse angeben.");
        formLayout.addField("Mail");
        formLayout.addField("Mail2");
        formLayout.addField("Phone");
        formLayout.addField("Skype");
        formLayout.addActions(new Action("Save"), new Action("Cancel"));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(formLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        WorkbenchView view = new WorkbenchView();
        view.setCenterNode(scrollPane);


        app.setWorkbench(view);
        app.clearGlobalActions();
    }

    private static void showImage(Application app) {
        SimpleImageView imageView = new SimpleImageView();
        imageView.setImage(SimpleViewAppDemo1.class.getResource("pic.jpg").toExternalForm());

        imageView.setOverlay(new Overlay());

        WorkbenchView view = new WorkbenchView();
        view.setCenterNode(imageView);
        app.setWorkbench(view);

        app.clearGlobalActions();
        app.addGlobalAction(new Action(Icon.NAV, () -> imageView.toggleOverlayVisibility()));
    }

    private static void showPersonList(Application app) {
        WorkbenchView view = new WorkbenchView();

        MediaList<Media> list = new MediaList<>();

        list.getItems().add(new DefaultMedia("Test01", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-01.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test02", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-02.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test03", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-03.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test04", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-04.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test05", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-05.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test06", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-06.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test07", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-07.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test08", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-08.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test09", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-09.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test10", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-10.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test11", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-11.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test12", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-12.jpg").toExternalForm()));
        list.getItems().add(new DefaultMedia("Test13", "Ich bin eine Beschreibung", SimpleViewAppDemo1.class.getResource("user-13.jpg").toExternalForm()));

        view.setCenterNode(list);

        ActionFooter footer = new ActionFooter();
        footer.addAction(new Action(Icon.PHONE, "Call"));
        footer.addAction(new Action(Icon.MAIL, "Send message", () -> view.setCenterNode(createChatTimeline())));
        view.setFooterNode(footer);

        app.setWorkbench(view);

        app.clearGlobalActions();
        app.addGlobalAction(new Action(Icon.VOLUMNE_DOWN));
        app.addGlobalAction(new Action(Icon.VOLUMNE_UP));
    }

    private static ChatTimeline<DefaultChatMessage> createChatTimeline() {
        ChatTimeline<DefaultChatMessage> timeline = new ChatTimeline<>();
        timeline.getItems().add(new DefaultChatMessage(true, "Hello"));
        timeline.getItems().add(new DefaultChatMessage(false, "How are you"));
        timeline.getItems().add(new DefaultChatMessage(true, "Fine, thanks. Do you want to go to the cinema today?"));
        timeline.getItems().add(new DefaultChatMessage(true, "Or having some drinks?"));
        timeline.getItems().add(new DefaultChatMessage(false, "Oh no, I already have a date this evening with Steve. We want to go to a club. If you want you can come with us."));
        timeline.getItems().add(new DefaultChatMessage(true, "Cool, when do you want to start?"));
        return timeline;
    }
}
