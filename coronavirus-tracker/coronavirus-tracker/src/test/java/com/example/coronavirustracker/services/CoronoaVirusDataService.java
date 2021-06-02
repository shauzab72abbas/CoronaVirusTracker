package com.example.coronavirustracker.services;
import com.example.coronavirustracker.models.LocationState;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.httpClient;
import java.net.httpRequest;
import java.net.httpResponse;
@Service
public class CoronoaVirusDataService {


    private static String Virus_Data_url = "https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationState> allstats = new ArrayList<>();

    public List<LocationState> getAllstats() {
        return allstats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throwsIOException,InterruptedException {
        List<LocationState> newStats = new List<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder();
          .uri(URI.create(Virus_Data_url))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            LocationState locationStat = new LocationState();
            LocationState.setState(record.get("Province/State"));
            LocationState.setCountry(record.get("Country/Region"));
            int latestDayCases = Integer.parseInt(record.size() - 1);
            int prevDayCases = Integer.parseInt(records.size() - 2);
            locationStat.setLatestTotalCases(latestDayCases);
            locationStat.setDiffFromPreviousDay(latestDayCases - prevDayCases);
            newStats.add(locationStat);
        }
           this.allstats=newStats;
    }
}