import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("Hong");
        user.setAge(24);

        Car car1 = new Car();
        car1.setName("k5");
        car1.setCarNumber("1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("X5");
        car2.setCarNumber("2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1,car2);
        user.setCars(carList);

        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : "+_name);
        System.out.println("age : "+_age);

        //리스트 노드 접근 Json의 형태를 알 경우
        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode)cars;

        List<Car> _cars =objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });
        System.out.println(_cars);

        //값 변경법
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name","gudals");
        objectNode.put("age",30);
        System.out.println(objectNode.toPrettyString());
    }
}
