package utils;

import java.util.Arrays;
import java.util.List;

public interface Constant {
    int FPS = 120;
    float SIZE = 2.5f;
    float GROUNDGAP = 2.8f;
    float BACKDROP_SCALE = 3f;
    int vx = 2;
    List<Integer> FIGHTER_CONTROLS_1 = Arrays.asList(87, 83, 68, 65, 53, 54, 84, 89);
    List<Integer> FIGHTER_CONTROLS_2 = Arrays.asList(38, 40, 39, 37);
    List<List<Integer>> FIGHTER_COMBO = Arrays.asList(
            Arrays.asList(68, 83, 84)
    );
}
