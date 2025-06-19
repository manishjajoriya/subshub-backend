package com.manishjajoriya.subshub.utils;

import com.manishjajoriya.subshub.entity.ServiceEntity;
import com.manishjajoriya.subshub.entity.UserDataEntity;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * A utility class to generate temporary/sample data for services.
 */
public class DataGeneratorUtil {

  /**
   * Creates and returns a list of sample ServiceEntity objects.
   *
   * @return A list of populated ServiceEntity objects.
   */
  public static List<ServiceEntity> getSampleServices() {
    List<ServiceEntity> services = new ArrayList<>();

    // 1. Spotify (Music Streaming)
    services.add(new ServiceEntity(1, "Spotify",
        "A digital music, podcast, and video service that gives you access to millions of "
            + "songs.", Arrays.asList("Free", "Premium", "Premium Duo", "Premium Family"),
        "Music Streaming", ""));

    // 2. Netflix (Video Streaming)
    services.add(new ServiceEntity(2, "Netflix",
        "A streaming service that offers a wide variety of award-winning TV shows, movies, "
            + "and documentaries.", Arrays.asList("Standard with ads", "Standard", "Premium"),
        "Video Streaming", ""));

    // 3. Google Drive (Cloud Storage)
    services.add(new ServiceEntity(3, "Google Drive",
        "A file storage and synchronization service that allows users to store files in the "
            + "cloud.", Arrays.asList("Free (15 GB)", "Basic (100 GB)", "Premium (2 TB)"),
        "Cloud Storage", ""));

    // 4. YouTube Premium (Video Streaming)
    services.add(new ServiceEntity(4, "YouTube Premium",
        "A subscription service offering ad-free access to all of YouTube's content and "
            + "premium originals.", Arrays.asList("Individual", "Family", "Student"),
        "Video Streaming", ""));

    // 5. Microsoft 365 (Productivity)
    services.add(new ServiceEntity(5, "Microsoft 365",
        "A line of subscription services offering access to Microsoft Office software and "
            + "cloud-based services.", Arrays.asList("Personal", "Family", "Business Basic"),
        "Productivity", ""));

    return services;
  }

  public static List<UserDataEntity> getSampleUserData() {
    List<UserDataEntity> userData = new ArrayList<>();
    LocalDate today = LocalDate.now();

    // User 1 (uid=101)
    // 1. Active Spotify Subscription (Monthly)
    userData.add(
        new UserDataEntity(1, UUID.fromString("3494b435-5004-4607-8d45-28de28ca4a31"), "Spotify",
            "9.99",
            "Music Streaming", "USD", Date.valueOf(today.minusMonths(6)),
            Date.valueOf(today.plusDays(10)), 1, true, false, false));

    // 2. Active Netflix Subscription (Monthly)
    userData.add(
        new UserDataEntity(2, UUID.fromString("3494b435-5004-4607-8d45-28de28ca4a31"), "Netflix",
            "15.49",
            "Video Streaming", "USD", Date.valueOf(today.minusYears(1)),
            Date.valueOf(today.plusDays(20)), 1, true, false, false));

    // 3. Canceled Microsoft 365 Subscription
    userData.add(new UserDataEntity(3, UUID.fromString("3494b435-5004-4607-8d45-28de28ca4a31"),
        "Microsoft 365", "6.99",
        "Productivity", "USD", Date.valueOf(today.minusMonths(3)),
        Date.valueOf(today.minusMonths(2).plusDays(5)), 1, false, false,
        true));

    // User 2 (uid=102)
    // 4. Active YouTube Premium Subscription (Monthly)
    userData.add(new UserDataEntity(4, UUID.fromString("b3f743bc-49a7-4051-9783-fef51c5ec808"),
        "YouTube Premium", "11.99",
        "Video Streaming", "USD", Date.valueOf(today.minusMonths(2)),
        Date.valueOf(today.plusDays(15)), 1, true, false, false));

    // 5. Active Google Drive Subscription (Yearly)
    userData.add(new UserDataEntity(5, UUID.fromString("b3f743bc-49a7-4051-9783-fef51c5ec808"),
        "Google Drive", "29.99",
        "Cloud Storage", "USD", Date.valueOf(today.minusYears(2)),
        Date.valueOf(today.plusMonths(11)), 12, true, false, false));

    // 6. Deleted (Old) Subscription for User 2
    userData.add(new UserDataEntity(6, UUID.fromString("b3f743bc-49a7-4051-9783-fef51c5ec808"),
        "Adobe Creative Cloud", "52.99",
        "Productivity", "USD", Date.valueOf(today.minusYears(3)),
        Date.valueOf(today.minusYears(2).minusMonths(1)), 1, false, true,
        true));

    return userData;
  }

}