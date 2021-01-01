/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/** RoomDatabase를 상속받는 추상 클래스를 만든다.
 *  데이터베이스 어노테이션으로 클래스에 선언한다.
 *  데이터베이스의 entities 및 버전을 선언해야한다.
 *  이 두 매개변수를 데이터베이스 어노테이션에 전달한다.
 *  테이블이 하나뿐이므로 SleepNight 클래스를 제공한다.
 *  테이블이 두 개 이상인 경우 이 목록에 모두 추가해야한다.
 *  버전은 첫 번째 버전이기 때문에 1로 시작된다.
 *  스키마를 변경할 때마다 버전번호를 올려야 한다. (이렇게 하지 않으면 앱이 더 이상 작동하지 않는다)
 *  exportSchema는 기본적으로 true이며, 데이터베이스의 스키마 폴더에 저장된다.(데이터베이스의 버전 기록을 제공한다) -> 자꾸 변경되는 복잡한 데이터베이스에 유용
 *  */
@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    /** 데이터베이스에 어떤 entity를 사용할지 알렸고,
     * 데이터베이스와 상호작용할 수 있도록 entity와 연결된 dao에 대해 알려야한다.*/
    abstract val sleepDatabaseDao: SleepDatabaseDao

    /** 컴패니언 객체는 클라이언트가 클래스를 인스턴스화 하지않고 데이터베이스를 만들거나 가져온다.
     * 지금은 데이터베이스를 제공하는것이 목적이기 때문에 인스턴스화 할 필요가 없다. */
    companion object {

        /** 데이터베이스에 대한 private nullable 변수를 null로 초기화하여 선언한다.
         * INSTANCE는 데이터베이스가 있으면 데이터베이스에 대한 참조를 유지한다.
         * 이렇게 하면 데이터베이스에 대한 연결에 반복적으로 비용이 들지 않는다.
         * Volatile어노테이션을 통해 INSTANCE의 가치는 항상 캐시되지 않는다. */
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        /** SleepDatabase에 대한 참조를 반환한다. */
        fun getInstance(context: Context): SleepDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            SleepDatabase::class.java,
                            "sleep_history_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}