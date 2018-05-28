package lawn.mower;

import lawn.mower.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by antoinevergos on 28/05/2018.
 */
public class LawnMowerEngine {

    public void processFile(String filename) throws IOException {
        String[] lines = Files.lines(Paths.get(filename)).toArray(String[]::new);
        processFile(lines).forEach(System.out::println);
    }

    public  String print(Mower m){
        return String.format("%s %s %s", m.getPosition().getX(), m.getPosition().getY(), Direction.getOutputValue(m.getDirection()));
    }

    public List<String> processFile(String[] lines){
        if(lines == null ) throw new IllegalStateException("input data cannot be null");
        if(lines.length <3 || lines.length %2  == 0) throw new IllegalStateException("Incorrect input format");
        String[] pos = lines[0].split(" ");
        List<Mower> result = new ArrayList<>();
        LawnMowers lawnMowers = new LawnMowers(new Lawn(new Position(pos[0], pos[1])));
        for (int i = 1; i < lines.length; ++i) {
            pos = lines[i].split(" ");
            Mower m = new Mower(new Position(pos[0], pos[1]), Direction.fromString(pos[2]));
            String actions = lines[i + 1];
            List<Action> actionList = actions.chars().boxed().map(Action::fromChar).collect(Collectors.toList());
            result.add(lawnMowers.processMower(m, actionList));
            ++i;
        }
        return result.stream().map(m -> print(m)).collect(Collectors.toList());
    }


    public static void main(String[] args) throws IOException {
        new LawnMowerEngine().processFile("/Users/antoinevergos/IdeaProjects/lawn-mower/test/data/test.txt");
    }
}
