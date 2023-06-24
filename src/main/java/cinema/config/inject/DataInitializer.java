package cinema.config.inject;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class DataInitializer {
    private final InjectController injectController;

    public DataInitializer(InjectController injectController) {
        this.injectController = injectController;
    }

    @PostConstruct
    public void inject() {
        injectController.injectUser();
    }
}
