package ro.uvt.info.sptestciorgoveandiana;

// Strategy pattern
//Visitor Strategy
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

public class Message {
    @Getter
    @Setter
    private String house;
    private String message;

    private String date;
    @Getter
    private DecodingStrategy decodingStrategy;

    public Message() {
    }

    public Message(String house, String message, String date, DecodingStrategy decodingStrategy) {
        this.house = house;
        this.message = message;
        this.date = date;
        this.decodingStrategy = decodingStrategy;
    }

    @JsonIgnore
    public void setDate(String date) {
        this.date = date;
    }

    public String decodeMessage() {

        return decodingStrategy.decode(message);
    }

    public void setDecodingStrategy(DecodingStrategy atreidesStrategy) {

        this.decodingStrategy = decodingStrategy;
    }

    public String getMessage() {

        return message;
    }

    public void accept(MessageVisitor visitor) {

        visitor.visit(this);
    }

}
