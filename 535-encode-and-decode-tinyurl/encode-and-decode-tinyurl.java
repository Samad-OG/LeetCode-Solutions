import java.util.HashMap;
import java.util.Map;

public class Codec {
    private final Map<String, String> codeToUrl = new HashMap<>();
    private final Map<String, String> urlToCode = new HashMap<>();
    private final String BASE_HOST = "http://tinyurl.com";

    public String encode(String longUrl) {
        if (urlToCode.containsKey(longUrl)) {
            return BASE_HOST + urlToCode.get(longUrl);
        }
        
        String shortCode = String.valueOf(longUrl.hashCode());
        while (codeToUrl.containsKey(shortCode)) {
            shortCode = String.valueOf((longUrl + Math.random()).hashCode());
        }
        
        codeToUrl.put(shortCode, longUrl);
        urlToCode.put(longUrl, shortCode);
        return BASE_HOST + shortCode;
    }

    public String decode(String shortUrl) {
        String shortCode = shortUrl.replace(BASE_HOST, "");
        return codeToUrl.get(shortCode);
    }
}
