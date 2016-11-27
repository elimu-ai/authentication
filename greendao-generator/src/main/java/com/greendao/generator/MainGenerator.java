package com.greendao.generator;

import org.literacyapp.model.gson.DeviceGson;
import org.literacyapp.model.gson.StudentGson;
import org.literacyapp.model.gson.StudentImageFeatureGson;
import org.literacyapp.model.gson.StudentImageGson;
import org.literacyapp.model.gson.analytics.StudentImageCollectionEventGson;
import org.literacyapp.model.gson.content.AllophoneGson;
import org.literacyapp.model.gson.content.LetterGson;
import org.literacyapp.model.gson.content.NumberGson;
import org.literacyapp.model.gson.content.WordGson;
import org.literacyapp.model.gson.content.multimedia.AudioGson;
import org.literacyapp.model.gson.content.multimedia.ImageGson;
import org.literacyapp.model.gson.content.multimedia.VideoGson;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    /**
     * This file is executed when a Gradle build is triggered from the project's root directory.
     * E.g. "./gradlew clean build"
     */
    public static void main(String [] args) {
        System.out.println("greendao-generator main");

        int schemaVersion = 1001018; // 1.1.18 (this should match the version of the dependency org.literacyapp:literacyapp-model)
        // NOTE: If you upgrade to a version of literacyapp-model that involves changes in the entities,
        // you might need to add a custom DB migration script in CustomDaoMaster.DevOpenHelper#onUpgrade
        Schema schema = new Schema(schemaVersion, "org.literacyapp.dao");

        // Model entities
        Entity device = EntityHelper.createEntityFromClass(DeviceGson.class, schema);
        Entity student = EntityHelper.createEntityFromClass(StudentGson.class, schema);

        // Face recognition entities
        Entity studentImageFeature = EntityHelper.createEntityFromClass(StudentImageFeatureGson.class, schema);
        Entity studentImage = EntityHelper.createEntityFromClass(StudentImageGson.class, schema);

        // Content entities
        Entity allophone = EntityHelper.createEntityFromClass(AllophoneGson.class, schema);
        Entity letter = EntityHelper.createEntityFromClass(LetterGson.class, schema);
        Entity audio = EntityHelper.createEntityFromClass(AudioGson.class, schema);
        Entity word = EntityHelper.createEntityFromClass(WordGson.class, schema);
        Entity number = EntityHelper.createEntityFromClass(NumberGson.class, schema);
        Entity image = EntityHelper.createEntityFromClass(ImageGson.class, schema);
        Entity video = EntityHelper.createEntityFromClass(VideoGson.class, schema);

        // Device event entities
        Entity studentImageCollectionEvent = EntityHelper.createEntityFromClass(StudentImageCollectionEventGson.class, schema);

        try {
            DaoGenerator daoGenerator = new DaoGenerator();
            daoGenerator.generateAll(schema, "../app/src/main/java");
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
