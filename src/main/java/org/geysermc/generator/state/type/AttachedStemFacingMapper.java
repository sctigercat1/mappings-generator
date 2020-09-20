package org.geysermc.generator.state.type;

import org.geysermc.generator.Pair;
import org.geysermc.generator.state.StateMapper;
import org.geysermc.generator.state.StateRemapper;
// TODO: See if this is necessary
//@StateRemapper(value = "facing", blockRegex = ".*attached_.*_stem.?")
public class AttachedStemFacingMapper extends StateMapper<Integer> {

    @Override
    public Pair<String, Integer> translateState(String fullIdentifier, String value) {
        int direction = 0;
        switch (value) {
            case "north":
                direction = 3; // Actually faces south
                break;
            case "west":
                direction = 2;
                break;
            case "south":
                direction = 1; // Correct
                break;
            case "east":
                direction = 0; // Likely needs to be west
                break;
        }
        return new Pair<>("facing_direction", direction);
    }
}
