package com.lautner.mindful_loading_info;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

// Add import statement for PreLaunch class
import com.lautner.mindful_loading_info.PreLaunch;

import javax.swing.*;

public class Initializer implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("loading-window");

    public Initializer() {
    }

    public void onInitialize() {
        WindowOpenListener.getListeners().add(() -> {
            PreLaunch preLaunch = new PreLaunch(); // Initialize PreLaunch instance
            PreLaunch.getFrame().ifPresent((frame) -> {
                frame.setVisible(false);
                frame.dispose();
                PreLaunch.setFrame(new JFrame());// Use preLaunch instead of PreLaunch
            });
        });
    }
}
