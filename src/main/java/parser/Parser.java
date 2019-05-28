package parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Parser {

    List<Map<String, String>> parse() throws IOException, Exception;
}
