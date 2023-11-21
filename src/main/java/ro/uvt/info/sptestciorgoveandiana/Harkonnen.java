package ro.uvt.info.sptestciorgoveandiana;
// Strategy pattern
public class Harkonnen implements DecodingStrategy {
    @Override
    public String decode(String message) {
        return "Messi";
    }
}