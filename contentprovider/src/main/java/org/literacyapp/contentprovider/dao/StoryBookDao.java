package org.literacyapp.contentprovider.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.Calendar;
import org.literacyapp.contentprovider.dao.converter.CalendarConverter;
import org.literacyapp.contentprovider.dao.converter.ContentStatusConverter;
import org.literacyapp.contentprovider.dao.converter.GradeLevelConverter;
import org.literacyapp.contentprovider.dao.converter.LocaleConverter;
import org.literacyapp.contentprovider.model.content.multimedia.Image;
import org.literacyapp.model.enums.GradeLevel;
import org.literacyapp.model.enums.Locale;
import org.literacyapp.model.enums.content.ContentStatus;

import org.literacyapp.contentprovider.model.content.StoryBook;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STORY_BOOK".
*/
public class StoryBookDao extends AbstractDao<StoryBook, Long> {

    public static final String TABLENAME = "STORY_BOOK";

    /**
     * Properties of entity StoryBook.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Locale = new Property(1, String.class, "locale", false, "LOCALE");
        public final static Property TimeLastUpdate = new Property(2, Long.class, "timeLastUpdate", false, "TIME_LAST_UPDATE");
        public final static Property RevisionNumber = new Property(3, Integer.class, "revisionNumber", false, "REVISION_NUMBER");
        public final static Property ContentStatus = new Property(4, String.class, "contentStatus", false, "CONTENT_STATUS");
        public final static Property Title = new Property(5, String.class, "title", false, "TITLE");
        public final static Property CoverImageId = new Property(6, long.class, "coverImageId", false, "COVER_IMAGE_ID");
        public final static Property GradeLevel = new Property(7, String.class, "gradeLevel", false, "GRADE_LEVEL");
    }

    private DaoSession daoSession;

    private final LocaleConverter localeConverter = new LocaleConverter();
    private final CalendarConverter timeLastUpdateConverter = new CalendarConverter();
    private final ContentStatusConverter contentStatusConverter = new ContentStatusConverter();
    private final GradeLevelConverter gradeLevelConverter = new GradeLevelConverter();

    public StoryBookDao(DaoConfig config) {
        super(config);
    }
    
    public StoryBookDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STORY_BOOK\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"LOCALE\" TEXT NOT NULL ," + // 1: locale
                "\"TIME_LAST_UPDATE\" INTEGER," + // 2: timeLastUpdate
                "\"REVISION_NUMBER\" INTEGER NOT NULL ," + // 3: revisionNumber
                "\"CONTENT_STATUS\" TEXT NOT NULL ," + // 4: contentStatus
                "\"TITLE\" TEXT NOT NULL ," + // 5: title
                "\"COVER_IMAGE_ID\" INTEGER NOT NULL ," + // 6: coverImageId
                "\"GRADE_LEVEL\" TEXT NOT NULL );"); // 7: gradeLevel
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STORY_BOOK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StoryBook entity) {
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
        stmt.bindString(6, entity.getTitle());
        stmt.bindLong(7, entity.getCoverImageId());
        stmt.bindString(8, gradeLevelConverter.convertToDatabaseValue(entity.getGradeLevel()));
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StoryBook entity) {
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
        stmt.bindString(6, entity.getTitle());
        stmt.bindLong(7, entity.getCoverImageId());
        stmt.bindString(8, gradeLevelConverter.convertToDatabaseValue(entity.getGradeLevel()));
    }

    @Override
    protected final void attachEntity(StoryBook entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StoryBook readEntity(Cursor cursor, int offset) {
        StoryBook entity = new StoryBook( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            localeConverter.convertToEntityProperty(cursor.getString(offset + 1)), // locale
            cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)), // timeLastUpdate
            cursor.getInt(offset + 3), // revisionNumber
            contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)), // contentStatus
            cursor.getString(offset + 5), // title
            cursor.getLong(offset + 6), // coverImageId
            gradeLevelConverter.convertToEntityProperty(cursor.getString(offset + 7)) // gradeLevel
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StoryBook entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocale(localeConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setTimeLastUpdate(cursor.isNull(offset + 2) ? null : timeLastUpdateConverter.convertToEntityProperty(cursor.getLong(offset + 2)));
        entity.setRevisionNumber(cursor.getInt(offset + 3));
        entity.setContentStatus(contentStatusConverter.convertToEntityProperty(cursor.getString(offset + 4)));
        entity.setTitle(cursor.getString(offset + 5));
        entity.setCoverImageId(cursor.getLong(offset + 6));
        entity.setGradeLevel(gradeLevelConverter.convertToEntityProperty(cursor.getString(offset + 7)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StoryBook entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StoryBook entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StoryBook entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getImageDao().getAllColumns());
            builder.append(" FROM STORY_BOOK T");
            builder.append(" LEFT JOIN IMAGE T0 ON T.\"COVER_IMAGE_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected StoryBook loadCurrentDeep(Cursor cursor, boolean lock) {
        StoryBook entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Image coverImage = loadCurrentOther(daoSession.getImageDao(), cursor, offset);
         if(coverImage != null) {
            entity.setCoverImage(coverImage);
        }

        return entity;    
    }

    public StoryBook loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<StoryBook> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<StoryBook> list = new ArrayList<StoryBook>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<StoryBook> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<StoryBook> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
