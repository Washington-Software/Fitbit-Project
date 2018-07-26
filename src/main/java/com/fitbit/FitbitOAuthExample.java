/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fitbit;

import com.fitbit.model.*;
import com.google.gson.annotations.SerializedName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
@EnableOAuth2Sso
@RestController
@EnableWebSecurity
public class FitbitOAuthExample extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2RestTemplate fitbitOAuthRestTemplate;

    @Value("${fitbit.api.resource.activitiesUri}")
    String fitbitActivitiesUri;

    @RequestMapping("/lifetime-activity")
    public LifetimeActivity lifetimeActivity() {
        LifetimeActivity lifetimeActivity;

        try {
            Activity a = fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri, Activity.class);
            lifetimeActivity = a.getLifetime().getTotal();


        } catch (Exception e) {
            lifetimeActivity = new LifetimeActivity();
        }

        return lifetimeActivity;
    }

    @RequestMapping("/best-activity")
    public BestActivity bestActivity() {
        BestActivity bestActivity;
        try {
            Activity a = fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri, Activity.class);
            bestActivity = a.getBest().getTotal();

        } catch (Exception e) {
            bestActivity = new BestActivity();
        }

        return bestActivity;

    }


//	@Value("${fitbit.api.resource.dailyActivitiesUri}")
//	String fitbitDailyActivitiesUri;
//
//	@RequestMapping("/daily-activity")
//	public Daily daily() {
//		Daily daily;
//		try {
//			daily = fitbitOAuthRestTemplate.getForObject(fitbitDailyActivitiesUri, Daily.class);
//		}
//		catch(Exception e) {
//			daily = new Daily();
//		}
//
//		return daily;
//	}

//	@Value("${fitbit.api.resource.sleepUri}")
//	String fitbitSleepUri;
//
//	@RequestMapping("/sleep-log")
//	public SleepLog sleepLog() {
//		SleepLog sleepLog;
//		try {
//			sleepLog = fitbitOAuthRestTemplate.getForObject(fitbitSleepUri, SleepLog.class);
//		}
//		catch(Exception e) {
//			sleepLog = new SleepLog();
//		}
//		return sleepLog;
//	}




    @Value("${fitbit.api.resource.stepsUri}")
    String fitbitStepsUri;

    @RequestMapping("/steps-log")
    public String stepsLog() {
        try {
            ResponseEntity<String> a = fitbitOAuthRestTemplate.getForEntity(fitbitStepsUri, String.class);
            return a.getBody();
        } catch (Exception e) {
            ResponseEntity<String> a;
        }
        return "N/A";
    }


    @Value("${fitbit.api.resource.multiSleepUri}")
    String fitbitSleepUri;



    @RequestMapping("/multi-sleep-log")
    public SleepLog sleepLog() {
        SleepLog sleepLog;
        try {
            sleepLog = fitbitOAuthRestTemplate.getForObject(fitbitSleepUri, SleepLog.class);
//            ResponseEntity<String> a = fitbitOAuthRestTemplate.getForEntity(fitbitSleepUri, String.class);
//            String[] startend1 = parseJsonSE(a.getBody());
//            startend = startend1;
            return sleepLog;
        } catch (Exception e) {
            sleepLog = new SleepLog();
        }
        return sleepLog;
    }

    //@Value("${fitbit.api.resource.intradayHRUri}")
    //String fitbitIHRUri = "https://api.fitbit.com/1/user/-/activities/heart/date/" + startend[0];



    @RequestMapping("/intraday-heart-rate/{date}/{today}")
    public ArrayList[] heartRate(@PathVariable("date") String date, @PathVariable("today") String today) {
        try {
            fitbitSleepUri = "https://api.fitbit.com/1.2/user/-/sleep/list.json?beforeDate=" + today + "&sort=desc&offset=0&limit=100";
            ResponseEntity<String> b = fitbitOAuthRestTemplate.getForEntity(fitbitSleepUri, String.class);
            String[] startend = parseJsonSE(b.getBody(), date);
            String fitbitIHRUri = "https://api.fitbit.com/1/user/-/activities/heart/date/" + startend[0] + "/" + startend[1] + "/1min/time/" + startend[2].substring(11,16) + "/" + startend[3].substring(11,16) + ".json";
            //String fitbitIHRUri = "https://api.fitbit.com/1/user/-/activities/heart/date/" + "2018-07-08"  + "/1d/1min/time/" + "01:31" + "/" + "10:00" + ".json";
            ResponseEntity<String> a = fitbitOAuthRestTemplate.getForEntity(fitbitIHRUri, String.class);
            ArrayList[] tom = parseJsonHR(a.getBody(), startend[0], startend[1]);
            return tom;
        } catch (Exception e) {
            ResponseEntity<String> a;
        }
        return null;
    }


    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
                .authenticated();
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FitbitOAuthExample.class, args);
    }

//	public static void main(String[] args) throws IOException
//	{
//		parseJson();
//
//		saveJson();
//
//		perfTest();
//	}
    public static String[] parseJsonSE (String jsonStr, String date) throws IOException {
//        int trueNum = Integer.valueOf(num);
        Gson gson = new Gson();
        SleepLog sleepLog;
        sleepLog = gson.fromJson(jsonStr, SleepLog.class);
        for (int i = 0; i < sleepLog.sleep.length; i++) {
            if (sleepLog.sleep[i].startTime.substring(0,10).equals(date)) {
                String[] startend = {sleepLog.sleep[i].startTime.substring(0,10), sleepLog.sleep[i].endTime.substring(0,10), sleepLog.sleep[i].startTime, sleepLog.sleep[i].endTime};
                return startend;
            }
        }
//        String[] startend = {sleepLog.sleep[trueNum].startTime.substring(0,10), sleepLog.sleep[trueNum].endTime.substring(0,10), sleepLog.sleep[trueNum].startTime, sleepLog.sleep[trueNum].endTime};
//        return startend;
        return null;
    }
    public static ArrayList[] parseJsonHR(String jsonStr, String start, String end) throws IOException {
        //String jsonStr = "{ \"author\": \"Steve Jin\", \"title\" : \"vSphere SDK\", \"obj\" : {\"objint\" : {}} }";
//		Object obj = gson.fromJson(jsonStr, Object.class);
//
//		System.out.println("obj type: " + obj.getClass().toString()); // com.google.gson.internal.LinkedTreeMap
//		System.out.println("obj: " + obj);
        Gson gson = new Gson();
        HeartRate heartRate;
        heartRate = gson.fromJson(jsonStr, HeartRate.class);
        ArrayList<String> dateTimeArray = new ArrayList<>();
        ArrayList<Integer> valueArray = new ArrayList<>();
        for (int i=0; i<heartRate.activitiesHeartIntraday.dataset.length;i++) {
            dateTimeArray.add(heartRate.activitiesHeartIntraday.dataset[i].time);
            valueArray.add(heartRate.activitiesHeartIntraday.dataset[i].value);
        }
        ArrayList<String> startenddate = new ArrayList<>();
        startenddate.add(start);
        startenddate.add(end);
        ArrayList[] tom = new ArrayList[3];
        tom[0] = startenddate;
        tom[1] = dateTimeArray;
        tom[2] = valueArray;
        return tom;

//        Map m = gson.fromJson(jsonStr, Map.class);
//        System.out.println("m: " + m.size());  // 3
//
//        for (Object key : m.keySet()) {
//            System.out.println("key:" + key);
//        }

//		Book book = gson.fromJson(jsonStr, Book.class);
//		System.out.println("book: " + book);
//		System.out.println("book.author: " + book.author);
//		System.out.println("book.obj class: " + book.obj.getClass()); //com.google.gson.internal.LinkedTreeMap
//		System.out.println("book.obj: " + book.obj);
    }

//    public static void saveJson() throws IOException {
//        Gson gson = new Gson();
//        Book book = new Book();
//        book.author = "Steve Jin";
//        book.title = "VMware vSphere and VI SDK";
//
//        String bookJson = gson.toJson(book);
//        System.out.println("bookJson: " + bookJson);
//    }
//
//    public static void perfTest() throws IOException {
//        Gson gson = new Gson();
//
//        long start = System.nanoTime();
//
//        // http://www.json-generator.com/# for generating a JSON file
//        gson.fromJson(new FileReader("src/main/resources/bigjson.json"), Map[].class);
//
//        long end = System.nanoTime();
//        System.out.println("Time taken (nano seconds): " + (end - start));
//    }

}

//class Book {
//    public String author;
//    public String title;
//    public Map obj;
//}

//best steps: 16,243
//best floors: 28
