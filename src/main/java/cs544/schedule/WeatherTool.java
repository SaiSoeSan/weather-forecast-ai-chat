package cs544.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.List;
import java.util.Random;

public class WeatherTool {
    private static final Logger logger = LoggerFactory.getLogger(WeatherTool.class);
    private static final List<String> RESPONSES = List.of(
            "Sunny with a high of 28°C",
            "Partly cloudy with a chance of thunderstorms",
            "Light showers expected later in the afternoon",
            "Overcast and 15°C",
            "Windy with scattered clouds",
            "Clear skies and 30°C"
    );

    private final  Random random = new Random();

    @Tool(description = "Get the current weather forecast for a given location")
    public String getWeather(@ToolParam(description = "The location to get the weather for") String location){
        logger.info("WeatherTool invoked for location: {}", location);
        String forecast = RESPONSES.get(random.nextInt(RESPONSES.size()));
        return "Weather forecast for " + location + ": " + forecast;
    }


}
