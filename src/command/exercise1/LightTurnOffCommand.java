/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2022, Heinz Kabutz, All rights reserved.
 */

package command.exercise1;

public class LightTurnOffCommand implements Command {
    private final Light light;

    public LightTurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
