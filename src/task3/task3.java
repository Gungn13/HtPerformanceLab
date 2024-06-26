package task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String pathValues = sc.nextLine();
        String pathTests = sc.nextLine();
        String report = sc.nextLine();

        sc.close();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode valuesNode = mapper.readTree(new File(pathValues));
        JsonNode testsNode = mapper.readTree(new File(pathTests));

        Map<Integer, String> valuesMap = new HashMap<>();
        for (JsonNode valueNode : valuesNode.get("values")) {
            int id = valueNode.get("id").asInt();
            String value = valueNode.get("value").asText();
            valuesMap.put(id, value);
        }

        fillValues(testsNode, valuesMap);


        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(report), testsNode);
    }

    private static void fillValues(JsonNode node, Map<Integer, String> valuesMap) {
        if (node.has("tests")) {
            for (JsonNode testNode : node.get("tests")) {
                fillValues(testNode, valuesMap);
            }
        }

        if (node.has("id")) {
            int id = node.get("id").asInt();
            if (valuesMap.containsKey(id)) {
                ((ObjectNode) node).put("value", valuesMap.get(id));
            }
        }

        if (node.has("values")) {
            for (JsonNode valueNode : node.get("values")) {
                fillValues(valueNode, valuesMap);
            }
        }
    }

}
