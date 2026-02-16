package engine;

import org.apache.commons.io.FileUtils;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class ReadFromJson {

public List <HashMap<String,String>> readJsonFile(String path) throws IOException {
    ObjectMapper mapper=new ObjectMapper();
    String jsonContent= FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
    return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
    });
}
}
