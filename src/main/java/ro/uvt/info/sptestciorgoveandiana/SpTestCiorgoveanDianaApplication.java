package ro.uvt.info.sptestciorgoveandiana;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class SpTestCiorgoveanDianaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpTestCiorgoveanDianaApplication.class, args);
        try {
            MessageObjectMapper messageService = new MessageObjectMapper(new ObjectMapper());
            List<Message> messages = messageService.readMessagesFromFile();


            for (Message message : messages) {
                System.out.println("Original Message: " + message.getMessage());
                if (message.getDecodingStrategy() != null) {
                    System.out.println("Decoded Message: " + message.decodeMessage());
                } else {
                    System.out.println("Unable to decode!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



