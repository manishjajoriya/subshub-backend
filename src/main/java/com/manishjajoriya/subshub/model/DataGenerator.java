package com.manishjajoriya.subshub.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility class to generate temporary/sample data for services.
 */
public class DataGenerator {

  /**
   * Creates and returns a list of sample ServiceModel objects.
   *
   * @return A list of populated ServiceModel objects.
   */
  public static List<ServiceModel> getSampleServices() {
    List<ServiceModel> services = new ArrayList<>();

    // 1. Spotify (Music Streaming)
    services.add(new ServiceModel(1, "Spotify",
        "A digital music, podcast, and video service that gives you access to millions of "
            + "songs.", Arrays.asList("Free", "Premium", "Premium Duo", "Premium Family"),
        "Music Streaming", ""));

    // 2. Netflix (Video Streaming)
    services.add(new ServiceModel(2, "Netflix",
        "A streaming service that offers a wide variety of award-winning TV shows, movies, "
            + "and documentaries.", Arrays.asList("Standard with ads", "Standard", "Premium"),
        "Video Streaming", ""));

    // 3. Google Drive (Cloud Storage)
    services.add(new ServiceModel(3, "Google Drive",
        "A file storage and synchronization service that allows users to store files in the "
            + "cloud.", Arrays.asList("Free (15 GB)", "Basic (100 GB)", "Premium (2 TB)"),
        "Cloud Storage", ""));

    // 4. YouTube Premium (Video Streaming)
    services.add(new ServiceModel(4, "YouTube Premium",
        "A subscription service offering ad-free access to all of YouTube's content and "
            + "premium originals.", Arrays.asList("Individual", "Family", "Student"),
        "Video Streaming", ""));

    // 5. Microsoft 365 (Productivity)
    services.add(new ServiceModel(5, "Microsoft 365",
        "A line of subscription services offering access to Microsoft Office software and "
            + "cloud-based services.", Arrays.asList("Personal", "Family", "Business Basic"),
        "Productivity", ""));

    return services;
  }

  public static List<UserDataModel> getSampleUserData() {
    List<UserDataModel> userData = new ArrayList<>();
    LocalDate today = LocalDate.now();

    // User 1 (uid=101)
    // 1. Active Spotify Subscription (Monthly)
    userData.add(new UserDataModel(1, 101, "Spotify", "9.99",
        "Music Streaming", "USD", Date.valueOf(today.minusMonths(6)),
        Date.valueOf(today.plusDays(10)), 1, true, false, false));

    // 2. Active Netflix Subscription (Monthly)
    userData.add(new UserDataModel(2, 101, "Netflix", "15.49",
        "Video Streaming", "USD", Date.valueOf(today.minusYears(1)),
        Date.valueOf(today.plusDays(20)), 1, true, false, false));

    // 3. Canceled Microsoft 365 Subscription
    userData.add(new UserDataModel(3, 101, "Microsoft 365", "6.99",
        "Productivity", "USD", Date.valueOf(today.minusMonths(3)),
        Date.valueOf(today.minusMonths(2).plusDays(5)), 1, false, false,
        true));

    // User 2 (uid=102)
    // 4. Active YouTube Premium Subscription (Monthly)
    userData.add(new UserDataModel(4, 102, "YouTube Premium", "11.99",
        "Video Streaming", "USD", Date.valueOf(today.minusMonths(2)),
        Date.valueOf(today.plusDays(15)), 1, true, false, false));

    // 5. Active Google Drive Subscription (Yearly)
    userData.add(new UserDataModel(5, 102, "Google Drive", "29.99",
        "Cloud Storage", "USD", Date.valueOf(today.minusYears(2)),
        Date.valueOf(today.plusMonths(11)), 12, true, false, false));

    // 6. Deleted (Old) Subscription for User 2
    userData.add(new UserDataModel(6, 102, "Adobe Creative Cloud", "52.99",
        "Productivity", "USD", Date.valueOf(today.minusYears(3)),
        Date.valueOf(today.minusYears(2).minusMonths(1)), 1, false, true,
        true));

    return userData;
  }

}