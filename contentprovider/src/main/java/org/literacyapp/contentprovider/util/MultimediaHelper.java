package org.literacyapp.contentprovider.util;

import android.os.Environment;

import org.literacyapp.contentprovider.model.content.multimedia.Audio;
import org.literacyapp.contentprovider.model.content.multimedia.Image;
import org.literacyapp.contentprovider.model.content.multimedia.Video;

import java.io.File;
import java.util.Locale;

/**
 * Helper class for determining folder paths of multimedia content.
 */
public class MultimediaHelper {

    public static File getMultimediaDirectory() {
        String language = Locale.getDefault().getLanguage(); // E.g. "en"
        File multimediaDirectory = new File(Environment.getExternalStorageDirectory() + "/.literacyapp/multimedia/" + language);
        if (!multimediaDirectory.exists()) {
            multimediaDirectory.mkdirs();
        }
        return multimediaDirectory;
    }

    public static File getAudioDirectory() {
        File audioDirectory = new File(getMultimediaDirectory(), "audio");
        if (!audioDirectory.exists()) {
            audioDirectory.mkdir();
        }
        return audioDirectory;
    }

    public static File getImageDirectory() {
        File imageDirectory = new File(getMultimediaDirectory(), "image");
        if (!imageDirectory.exists()) {
            imageDirectory.mkdir();
        }
        return imageDirectory;
    }

    public static File getVideoDirectory() {
        File videoDirectory = new File(getMultimediaDirectory(), "video");
        if (!videoDirectory.exists()) {
            videoDirectory.mkdir();
        }
        return videoDirectory;
    }

    public static File getFile(Audio audio) {
        File file = null;

        if (audio == null) {
            return null;
        }

        File audioDirectory = getAudioDirectory();
        file = new File(audioDirectory, audio.getId() + "_r" + audio.getRevisionNumber() + "." + audio.getAudioFormat().toString().toLowerCase());

        return file;
    }

    public static File getFile(Image image) {
        File file = null;

        if (image == null) {
            return null;
        }

        File imageDirectory = getImageDirectory();
        file = new File(imageDirectory, image.getId() + "_r" + image.getRevisionNumber() + "." + image.getImageFormat().toString().toLowerCase());

        return file;
    }

    public static File getFile(Video video) {
        File file = null;

        if (video == null) {
            return null;
        }

        File videoDirectory = getVideoDirectory();
        file = new File(videoDirectory, video.getId() + "_r" + video.getRevisionNumber() + "." + video.getVideoFormat().toString().toLowerCase());

        return file;
    }

    public static File getVideoThumbnail(Video video) {
        File file = null;

        if (video == null) {
            return null;
        }

        File videoDirectory = getVideoDirectory();
        file = new File(videoDirectory, video.getId() + "_r" + video.getRevisionNumber() + ".png");

        return file;
    }
}
