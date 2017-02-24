package org.literacyapp.contentprovider.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.Calendar;
import org.literacyapp.contentprovider.dao.converter.CalendarConverter;
import org.literacyapp.contentprovider.dao.converter.ConsonantPlaceConverter;
import org.literacyapp.contentprovider.dao.converter.ConsonantTypeConverter;
import org.literacyapp.contentprovider.dao.converter.ConsonantVoicingConverter;
import org.literacyapp.contentprovider.dao.converter.ContentStatusConverter;
import org.literacyapp.contentprovider.dao.converter.LipRoundingConverter;
import org.literacyapp.contentprovider.dao.converter.LocaleConverter;
import org.literacyapp.contentprovider.dao.converter.SoundTypeConverter;
import org.literacyapp.contentprovider.dao.converter.VowelFrontnessConverter;
import org.literacyapp.contentprovider.dao.converter.VowelHeightConverter;
import org.literacyapp.contentprovider.dao.converter.VowelLengthConverter;
import org.literacyapp.model.enums.Locale;
import org.literacyapp.model.enums.content.ContentStatus;
import org.literacyapp.model.enums.content.allophone.ConsonantPlace;
import org.literacyapp.model.enums.content.allophone.ConsonantType;
import org.literacyapp.model.enums.content.allophone.ConsonantVoicing;
import org.literacyapp.model.enums.content.allophone.LipRounding;
import org.literacyapp.model.enums.content.allophone.SoundType;
import org.literacyapp.model.enums.content.allophone.VowelFrontness;
import org.literacyapp.model.enums.content.allophone.VowelHeight;
import org.literacyapp.model.enums.content.allophone.VowelLength;

import org.literacyapp.contentprovider.model.content.Allophone;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ALLOPHONE".
*/
public class AllophoneDao extends AbstractDao<Allophone, Long> {

    public static final String TABLENAME = "ALLOPHONE";

    /**
     * Properties of entity Allophone.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Locale = new Property(1, String.class, "locale", false, "LOCALE");
        public final static Property TimeLastUpdate = new Property(2, Long.class, "timeLastUpdate", false, "TIME_LAST_UPDATE");
        public final static Property RevisionNumber = new Property(3, Integer.class, "revisionNumber", false, "REVISION_NUMBER");
        public final static Property ContentStatus = new Property(4, String.class, "contentStatus", false, "CONTENT_STATUS");
        public final static Property ValueIpa = new Property(5, String.class, "valueIpa", false, "VALUE_IPA");
        public final static Property ValueSampa = new Property(6, String.class, "valueSampa", false, "VALUE_SAMPA");
        public final static Property SoundType = new Property(7, String.class, "soundType", false, "SOUND_TYPE");
        public final static Property VowelLength = new Property(8, String.class, "vowelLength", false, "VOWEL_LENGTH");
        public final static Property VowelHeight = new Property(9, String.class, "vowelHeight", false, "VOWEL_HEIGHT");
        public final static Property VowelFrontness = new Property(10, String.class, "vowelFrontness", false, "VOWEL_FRONTNESS");
        public final static Property LipRounding = new Property(11, String.class, "lipRounding", false, "LIP_ROUNDING");
        public final static Property ConsonantType = new Property(12, String.class, "consonantType", false, "CONSONANT_TYPE");
        public final static Property ConsonantPlace = new Property(13, String.class, "consonantPlace", false, "CONSONANT_PLACE");
        public final static Property ConsonantVoicing = new Property(14, String.class, "consonantVoicing", false, "CONSONANT_VOICING");
    }

    private final LocaleConverter localeConverter = new LocaleConverter();
    private final CalendarConverter timeLastUpdateConverter = new CalendarConverter();
    private final ContentStatusConverter contentStatusConverter = new ContentStatusConverter();
    private final SoundTypeConverter soundTypeConverter = new SoundTypeConverter();
    private final VowelLengthConverter vowelLengthConverter = new VowelLengthConverter();
    private final VowelHeightConverter vowelHeightConverter = new VowelHeightConverter();
    private final VowelFrontnessConverter vowelFrontnessConverter = new VowelFrontnessConverter();
    private final LipRoundingConverter lipRoundingConverter = new LipRoundingConverter();
    private final ConsonantTypeConverter consonantTypeConverter = new ConsonantTypeConverter();
    private final ConsonantPlaceConverter consonantPlaceConverter = new ConsonantPlaceConverter();
    private final ConsonantVoicingConverter consonantVoicingConverter = new ConsonantVoicingConverter();

    public AllophoneDao(DaoConfig config) {
        super(config);
    }
    
    public AllophoneDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALLOPHONE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"LOCALE\" TEXT NOT NULL ," + // 1: locale
                "\"TIME_LAST_UPDATE\" INTEGER," + // 2: timeLastUpdate
                "\"REVISION_NUMBER\" INTEGER NOT NULL ," + // 3: revisionNumber
                "\"CONTENT_STATUS\" TEXT NOT NULL ," + // 4: contentStatus
                "\"VALUE_IPA\" TEXT NOT NULL ," + // 5: valueIpa
                "\"VALUE_SAMPA\" TEXT NOT NULL ," + // 6: valueSampa
                "\"SOUND_TYPE\" TEXT," + // 7: soundType
                "\"VOWEL_LENGTH\" TEXT," + // 8: vowelLength
                "\"VOWEL_HEIGHT\" TEXT," + // 9: vowelHeight
                "\"VOWEL_FRONTNESS\" TEXT," + // 10: vowelFrontness
                "\"LIP_ROUNDING\" TEXT," + // 11: lipRounding
                "\"CONSONANT_TYPE\" TEXT," + // 12: consonantType
                "\"CONSONANT_PLACE\" TEXT," + // 13: consonantPlace
                "\"CONSONANT_VOICING\" TEXT);"); // 14: consonantVoicing
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALLOPHONE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Allophone entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, localeConverter.convertToDatabaseValue(entity.getLocale()));
 
        Calendar timeLastUpdate = entity.getTimeLastUpdate();
        if (timeLastUpdate != null) {
            stmt.bindLong(3, timeLastUpdateConverter.convertToDatabaseValue(timeLastUpdate));
        }
        stmt.bindLong(4, entity.getRevisionNumber());
        stmt.bindString(5, contentStatusConverter.convertToDatabaseValue(entity.getContentStatus()));
        stmt.bindString(6, entity.getValueIpa());
        stmt.bindString(7, entity.getValueSampa());
 
        SoundType soundType = entity.getSoundType();
        if (soundType != null) {
            stmt.bindString(8, soundTypeConverter.convertToDatabaseValue(soundType));
        }
 
        VowelLength vowelLength = entity.getVowelLength();
        if (vowelLength != null) {
            stmt.bindString(9, vowelLengthConverter.convertToDatabaseValue(vowelLength));
        }
 
        VowelHeight vowelHeight = entity.getVowelHeight();
        if (vowelHeight != null) {
            stmt.bindString(10, vowelHeightConverter.convertToDatabaseValue(vowelHeight));
        }
 
        VowelFrontness vowelFrontness = entity.getVowelFrontness();
        if (vowelFrontness != null) {
            stmt.bindString(11, vowelFrontnessConverter.convertToDatabaseValue(vowelFrontness));
        }
 
        LipRounding lipRounding = entity.getLipRounding();
        if (lipRounding != null) {
            stmt.bindString(12, lipRoundingConverter.convertToDatabaseValue(lipRounding));
        }
 
        ConsonantType consonantType = entity.getConsonantType();
        if (consonantType != null) {
            stmt.bindString(13, consonantTypeConverter.convertToDatabaseValue(consonantType));
        }
 
        ConsonantPlace consonantPlace = entity.getConsonantPlace();
        if (consonantPlace != null) {
            stmt.bindString(14, consonantPlaceConverter.convertToDatabaseValue(consonantPlace));
        }
 
        ConsonantVoicing consonantVoicing = entity.getConsonantVoicing();
        if (consonantVoicing != null) {
            stmt.bindString(15, consonantVoicingConverter.convertToDatabaseValue(consonantVoicing));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Allophone entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, localeConverter.convertToDatabaseValue(entity.getLocale()));
 
        Calendar timeLastUpdate = entity.getTimeLastUpdate();
        if (timeLastUpdate != null) {
            stmt.bindLong(3, timeLastUpdateConverter.convertToDatabaseValue(timeLastUpdate));
        }
        stmt.bindLong(4, entity.getRevisionNumber());
        stmt.bindString(5, contentStatusConverter.convertToDatabaseValue(entity.getContentStatus()));
        stmt.bindString(6, entity.getValueIpa());
        stmt.bindString(7, entity.getValueSampa());
 
        SoundType soundType = entity.getSoundType();
        if (soundType != null) {
            stmt.bindString(8, soundTypeConverter.convertToDatabaseValue(soundType));
        }
 
        VowelLength vowelLength = entity.getVowelLength();
        if (vowelLength != null) {
            stmt.bindString(9, vowelLengthConverter.convertToDatabaseValue(vowelLength));
        }
 
        VowelHeight vowelHeight = entity.getVowelHeight();
        if (vowelHeight != null) {
            stmt.bindString(10, vowelHeightConverter.convertToDatabaseValue(vowelHeight));
        }
 
        VowelFrontness vowelFrontness = entity.getVowelFrontness();
        if (vowelFrontness != null) {
            stmt.bindString(11, vowelFrontnessConverter.convertToDatabaseValue(vowelFrontness));
        }
 
        LipRounding lipRounding = entity.getLipRounding();
        if (lipRounding != null) {
            stmt.bindString(12, lipRoundingConverter.convertToDatabaseValue(lipRounding));
        }
 
        ConsonantType consonantType = entity.getConsonantType();
        if (consonantType != null) {
            stmt.bindString(13, consonantTypeConverter.convertToDatabaseValue(consonantType));
        }
 
        ConsonantPlace consonantPlace = entity.getConsonantPlace();
        if (consonantPlace != null) {
            stmt.bindString(14, consonantPlaceConverter.convertToDatabaseValue(consonantPlace));
        }
 
        ConsonantVoicing consonantVoicing = entity.getConsonantVoicing();
        if (consonantVoicing != null) {
            stmt.bindString(15, consonantVoicingConverter.convertToDatabaseValue(consonantVoicing));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Allophone readEntity(Cursor cursor, int offset) {
        Allophone entity = new Allophone( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            localeConverter.convertToEntityProperty(cursor.getString(offset + 1)), // locale
            cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)), // timeLastUpdate
            cursor.getInt(offset + 3), // revisionNumber
            contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)), // contentStatus
            cursor.getString(offset + 5), // valueIpa
            cursor.getString(offset + 6), // valueSampa
            cursor.isNull(offset + 7) ? null : soundTypeConverter.convertToEntityProperty(cursor.getString(offset + 7)), // soundType
            cursor.isNull(offset + 8) ? null : vowelLengthConverter.convertToEntityProperty(cursor.getString(offset + 8)), // vowelLength
            cursor.isNull(offset + 9) ? null : vowelHeightConverter.convertToEntityProperty(cursor.getString(offset + 9)), // vowelHeight
            cursor.isNull(offset + 10) ? null : vowelFrontnessConverter.convertToEntityProperty(cursor.getString(offset + 10)), // vowelFrontness
            cursor.isNull(offset + 11) ? null : lipRoundingConverter.convertToEntityProperty(cursor.getString(offset + 11)), // lipRounding
            cursor.isNull(offset + 12) ? null : consonantTypeConverter.convertToEntityProperty(cursor.getString(offset + 12)), // consonantType
            cursor.isNull(offset + 13) ? null : consonantPlaceConverter.convertToEntityProperty(cursor.getString(offset + 13)), // consonantPlace
            cursor.isNull(offset + 14) ? null : consonantVoicingConverter.convertToEntityProperty(cursor.getString(offset + 14)) // consonantVoicing
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Allophone entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocale(localeConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setTimeLastUpdate(cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)));
        entity.setRevisionNumber(cursor.getInt(offset + 3));
        entity.setContentStatus(contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setValueIpa(cursor.getString(offset + 5));
        entity.setValueSampa(cursor.getString(offset + 6));
        entity.setSoundType(cursor.isNull(offset + 7) ? null : soundTypeConverter.convertToEntityProperty(cursor.getString(offset + 7)));
        entity.setVowelLength(cursor.isNull(offset + 8) ? null : vowelLengthConverter.convertToEntityProperty(cursor.getString(offset + 8)));
        entity.setVowelHeight(cursor.isNull(offset + 9) ? null : vowelHeightConverter.convertToEntityProperty(cursor.getString(offset + 9)));
        entity.setVowelFrontness(cursor.isNull(offset + 10) ? null : vowelFrontnessConverter.convertToEntityProperty(cursor.getString(offset + 10)));
        entity.setLipRounding(cursor.isNull(offset + 11) ? null : lipRoundingConverter.convertToEntityProperty(cursor.getString(offset + 11)));
        entity.setConsonantType(cursor.isNull(offset + 12) ? null : consonantTypeConverter.convertToEntityProperty(cursor.getString(offset + 12)));
        entity.setConsonantPlace(cursor.isNull(offset + 13) ? null : consonantPlaceConverter.convertToEntityProperty(cursor.getString(offset + 13)));
        entity.setConsonantVoicing(cursor.isNull(offset + 14) ? null : consonantVoicingConverter.convertToEntityProperty(cursor.getString(offset + 14)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Allophone entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Allophone entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Allophone entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}