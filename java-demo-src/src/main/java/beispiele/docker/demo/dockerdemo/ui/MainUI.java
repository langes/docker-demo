package beispiele.docker.demo.dockerdemo.ui;

import com.github.javafaker.Faker;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Timer;
import java.util.TimerTask;

@SpringUI
@Theme(ValoTheme.THEME_NAME)
@Push
public class MainUI extends UI {

    private static final Faker faker = new Faker();

    private Timer timer;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout root = new VerticalLayout();
        root.setWidth("100%");

        final Label fact = new Label(faker.chuckNorris().fact());
        fact.addStyleNames(ValoTheme.LABEL_HUGE, "v-align-center");
        fact.setWidth("50%");

        final Label author = new Label("<em>Chuck Norris</em>");
        author.setCaptionAsHtml(true);
        author.setContentMode(ContentMode.HTML);

        root.addComponents(fact, author);
        root.setComponentAlignment(fact, Alignment.MIDDLE_CENTER);
        root.setComponentAlignment(author, Alignment.MIDDLE_CENTER);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getUI().access(() -> {
                    fact.setValue(faker.chuckNorris().fact());
                });
            }
        }, 15000, 15000);

        setContent(root);
    }

    @Override
    public void close() {
        timer.cancel();
    }
}
