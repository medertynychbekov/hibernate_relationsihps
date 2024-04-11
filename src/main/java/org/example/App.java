package org.example;

import org.example.model.Passport;
import org.example.model.SocialMedia;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.impl.SocialMediaService;
import org.example.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Hello world!
 */
public class App {
    private static final UserService USER_SERVICE = new UserServiceImpl();
    private static final SocialMediaService SM_SERVICE = new SocialMediaService();

    public static void main(String[] args) {

        User samira = USER_SERVICE.findById(1L);
        User rabia = USER_SERVICE.findById(2L);

        SocialMedia whatsApp = new SocialMedia("whatsApp", 1_000_000_000);
        SocialMedia youTube = new SocialMedia("youtube", 1_500_000_000);
        SocialMedia tiktok = new SocialMedia("tiktok", 1_000_000_000);

        whatsApp.setUsers(Collections.singletonList(samira));
        tiktok.setUsers(Collections.singletonList(samira));

        whatsApp.setUsers(Collections.singletonList(rabia));
        youTube.setUsers(Collections.singletonList(rabia));

        ArrayList<SocialMedia> socialMedia = new ArrayList<>(Arrays.asList(whatsApp, youTube));
        ArrayList<SocialMedia> socialMedia1 = new ArrayList<>(Arrays.asList(whatsApp, tiktok));

        samira.setSocialMedias(socialMedia);
        rabia.setSocialMedias(socialMedia1);

        USER_SERVICE.save(samira);
        USER_SERVICE.save(rabia);


    }

}
