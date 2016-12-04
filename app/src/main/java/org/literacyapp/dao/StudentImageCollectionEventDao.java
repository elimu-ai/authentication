package org.literacyapp.dao;

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
import org.literacyapp.dao.converter.CalendarConverter;
import org.literacyapp.model.Device;
import org.literacyapp.model.Student;

import org.literacyapp.model.StudentImageCollectionEvent;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT_IMAGE_COLLECTION_EVENT".
*/
public class StudentImageCollectionEventDao extends AbstractDao<StudentImageCollectionEvent, Long> {

    public static final String TABLENAME = "STUDENT_IMAGE_COLLECTION_EVENT";

    /**
     * Properties of entity StudentImageCollectionEvent.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property DeviceId = new Property(1, long.class, "deviceId", false, "DEVICE_ID");
        public final static Property Time = new Property(2, long.class, "time", false, "TIME");
        public final static Property StudentId = new Property(3, long.class, "studentId", false, "STUDENT_ID");
        public final static Property SvmTrainingExecuted = new Property(4, boolean.class, "svmTrainingExecuted", false, "SVM_TRAINING_EXECUTED");
    }

    private DaoSession daoSession;

    private final CalendarConverter timeConverter = new CalendarConverter();

    public StudentImageCollectionEventDao(DaoConfig config) {
        super(config);
    }
    
    public StudentImageCollectionEventDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT_IMAGE_COLLECTION_EVENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"DEVICE_ID\" INTEGER NOT NULL ," + // 1: deviceId
                "\"TIME\" INTEGER NOT NULL ," + // 2: time
                "\"STUDENT_ID\" INTEGER NOT NULL ," + // 3: studentId
                "\"SVM_TRAINING_EXECUTED\" INTEGER NOT NULL );"); // 4: svmTrainingExecuted
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT_IMAGE_COLLECTION_EVENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StudentImageCollectionEvent entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDeviceId());
        stmt.bindLong(3, timeConverter.convertToDatabaseValue(entity.getTime()));
        stmt.bindLong(4, entity.getStudentId());
        stmt.bindLong(5, entity.getSvmTrainingExecuted() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StudentImageCollectionEvent entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDeviceId());
        stmt.bindLong(3, timeConverter.convertToDatabaseValue(entity.getTime()));
        stmt.bindLong(4, entity.getStudentId());
        stmt.bindLong(5, entity.getSvmTrainingExecuted() ? 1L: 0L);
    }

    @Override
    protected final void attachEntity(StudentImageCollectionEvent entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StudentImageCollectionEvent readEntity(Cursor cursor, int offset) {
        StudentImageCollectionEvent entity = new StudentImageCollectionEvent( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // deviceId
            timeConverter.convertToEntityProperty(cursor.getLong(offset + 2)), // time
            cursor.getLong(offset + 3), // studentId
            cursor.getShort(offset + 4) != 0 // svmTrainingExecuted
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StudentImageCollectionEvent entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDeviceId(cursor.getLong(offset + 1));
        entity.setTime(timeConverter.convertToEntityProperty(cursor.getLong(offset + 2)));
        entity.setStudentId(cursor.getLong(offset + 3));
        entity.setSvmTrainingExecuted(cursor.getShort(offset + 4) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StudentImageCollectionEvent entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StudentImageCollectionEvent entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StudentImageCollectionEvent entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getDeviceDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getStudentDao().getAllColumns());
            builder.append(" FROM STUDENT_IMAGE_COLLECTION_EVENT T");
            builder.append(" LEFT JOIN DEVICE T0 ON T.\"DEVICE_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN STUDENT T1 ON T.\"STUDENT_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected StudentImageCollectionEvent loadCurrentDeep(Cursor cursor, boolean lock) {
        StudentImageCollectionEvent entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Device device = loadCurrentOther(daoSession.getDeviceDao(), cursor, offset);
         if(device != null) {
            entity.setDevice(device);
        }
        offset += daoSession.getDeviceDao().getAllColumns().length;

        Student student = loadCurrentOther(daoSession.getStudentDao(), cursor, offset);
         if(student != null) {
            entity.setStudent(student);
        }

        return entity;    
    }

    public StudentImageCollectionEvent loadDeep(Long key) {
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
    public List<StudentImageCollectionEvent> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<StudentImageCollectionEvent> list = new ArrayList<StudentImageCollectionEvent>(count);
        
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
    
    protected List<StudentImageCollectionEvent> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<StudentImageCollectionEvent> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
